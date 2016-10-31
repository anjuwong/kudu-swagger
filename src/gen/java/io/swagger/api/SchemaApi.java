package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SchemaApiService;
import io.swagger.api.factories.SchemaApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.ColumnInfo;
import io.swagger.model.Error;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/schema")

@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the schema API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-29T00:36:11.447Z")
public class SchemaApi  {
   private final SchemaApiService delegate = SchemaApiServiceFactory.getSchemaApi();

    @GET
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a table's schema.",
            notes = "Given a table_id, return the table's schema. ",
            response = ColumnInfo.class,
            responseContainer = "List",
            tags={ "Table", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "The schema of a table, given as an array of columns.",
                response = ColumnInfo.class,
                responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error",
                response = ColumnInfo.class,
                responseContainer = "List") })

    public Response schemaGet(@ApiParam(value = "Table identifier",required=true)
                                  @QueryParam("table_id") String tableId,
                              @Context SecurityContext securityContext) throws Exception {
        return delegate.schemaGet(tableId,securityContext);
    }

    @PUT
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create a table.",
            notes = "Given a table_id, create a new table following a provided schema.",
            response = void.class,
            tags = {"Table", })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200,
                    message = "Table creation was successful.",
                    response = void.class)})
    public Response schemaPut(@ApiParam(value = "Table identifier", required=true)@QueryParam("table_id") String tableId,
                              @ApiParam(value = "Schema of table to create.", required=true) List<ColumnInfo> schema,
                              @Context SecurityContext securityContext) throws Exception {
        return delegate.schemaPut(tableId, schema, securityContext);
    }
}
