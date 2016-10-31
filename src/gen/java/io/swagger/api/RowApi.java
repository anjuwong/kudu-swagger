package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.RowApiService;
import io.swagger.api.factories.RowApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.RowEntry;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/row")

@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the row API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen",
        date = "2016-09-29T00:36:11.447Z")
public class RowApi  {
   private final RowApiService delegate = RowApiServiceFactory.getRowApi();

    @PUT
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Insert a row to the table.",
            notes = "Given a table_id and a row, insert the row to the corresponding table. ",
            response = void.class,
            tags={ "Table", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Insert was successful.",
                response = void.class)})
    public Response rowPut(@ApiParam(value = "Table identifier", required=true)@QueryParam("table_id") String tableId,
                           @ApiParam(value = "Row entry to insert.", required=true) RowEntry row,
                           @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.rowPut(tableId,row,securityContext);
    }
}
