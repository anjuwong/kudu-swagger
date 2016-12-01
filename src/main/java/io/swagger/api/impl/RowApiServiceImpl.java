package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.api.KuduContext;
import io.swagger.model.*;

import io.swagger.model.RowEntry;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.stumbleupon.async.Callback;
import com.stumbleupon.async.Deferred;
import org.apache.kudu.client.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-29T00:36:11.447Z")
public class RowApiServiceImpl extends RowApiService {
    @Override
    public Response rowPut(String tableId, final RowEntry row, SecurityContext securityContext) throws NotFoundException {
        AsyncKuduClient client = KuduContext.getInstance().getClient();
        final AsyncKuduSession session = client.newSession();
        Deferred<KuduTable> table = client.openTable(tableId);
        KuduTable kuduTable = table.join();
        Insert insert = table.newInsert();
        PartialRow kuduRow = insert.getRow();
        row.getKuduRow(kuduRow);
        Deferred<OperationResponse> insertHook = session.apply(insert);
        OperationResponse resp = insertHook.join()
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Row inserted!")).build();
    }

    public Response async_rowPut(String tableId, final RowEntry row, SecurityContext securityContext) throws NotFoundException {
        // Asynchronously add the row to a given table.
        AsyncKuduClient client = KuduContext.getInstance().getClient();
        final AsyncKuduSession session = client.newSession();

        // Submit an asynchronous request to get the table.
        Deferred<KuduTable> table = client.openTable(tableId);

        // Add callback to insert the data if the table does exist.
        table.addCallback(new Callback<Object,  KuduTable>() {
            @Override
            public Object call(KuduTable table) throws Exception {
                Insert insert = table.newInsert();
                PartialRow kuduRow = insert.getRow();
                row.getKuduRow(kuduRow);

                // Asyncronously insert the row. Ignore the result of the insert.
                Deferred<OperationResponse> insertHook = session.apply(insert);
                insertHook.addCallback(new Callback<Object, OperationResponse>() {
                    @Override
                    public Object call(OperationResponse resp) throws Exception {
                        if (resp.hasRowError()) {

                        } else {

                        }
                        return null;
                    }
                });
                return null;
            }
        });
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Row inserted!")).build();
    }
}
