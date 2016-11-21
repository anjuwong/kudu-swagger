package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.ColumnInfo;
import io.swagger.model.Error;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import java.util.ArrayList;

import com.stumbleupon.async.Callback;
import com.stumbleupon.async.Deferred;

import org.apache.kudu.client.*;
import org.apache.kudu.ColumnSchema;
import org.apache.kudu.Schema;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-29T00:36:11.447Z")
public class SchemaApiServiceImpl extends SchemaApiService {
    @Override
    public Response schemaGet(String tableId, SecurityContext securityContext) throws Exception {
        // Connect to the Kudu client.
        AsyncKuduClient client = KuduContext.getInstance().getClient();
        final AsyncKuduSession session = client.newSession();

        // Submit an asynchronous request to get the table.
        Deferred<KuduTable> table = client.openTable(tableId);
        KuduTable kuduTable = table.join();

        // Return the columns of a table.
        List<ColumnSchema> kuduColumns = kuduTable.getSchema().getColumns();
        List<ColumnInfo> schemaResponse = new ArrayList<ColumnInfo>();
        for (ColumnSchema kuduColumn: kuduColumns) {
            // Add each column to the response.
            ColumnInfo column = new ColumnInfo();
            column.setName(kuduColumn.getName());
            column.setDataType(kuduColumn.getType().getName().toUpperCase());
            column.setPrimaryKey(kuduColumn.isKey());
            schemaResponse.add(column);
        }
        return Response.ok().entity(schemaResponse).build();
    }

    @Override
    public Response schemaPut(String tableId,
                              List<ColumnInfo> schema,
                              SecurityContext securityContext) throws Exception {
        // Connect to the Kudu client.
        AsyncKuduClient client = KuduContext.getInstance().getClient();

        // Get the a Kudu Schema from the ColumnInfo list.
        List<ColumnSchema> columnSchemaList = new ArrayList<>();
        List<String> rangeKeyList = new ArrayList<>();
        for (ColumnInfo column: schema) {
            columnSchemaList.add(column.buildKuduColumnSchema());
            if (column.getDataType().toUpperCase().equals("INT32")) {
                rangeKeyList.add(column.getName());
            }
        }

        // Submit an asynchronous request to create a table.
        // TODO: Allow users to change CreateTableOptions.
        Deferred<KuduTable> tableHook = client.createTable(tableId,
                new Schema(columnSchemaList),
                new CreateTableOptions()
                        .setNumReplicas(1)
                        .setRangePartitionColumns(rangeKeyList));

        tableHook.addCallback(new Callback<Object, KuduTable>() {
            @Override
            public Object call(KuduTable table) throws Exception {
                return null;
            }
        });
        try {
            tableHook.join();
        } catch (Exception ex) {
            KuduContext.resetInstance();
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Error occurred!")).build();
        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Table created!")).build();
    }
}
