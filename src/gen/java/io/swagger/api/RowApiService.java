package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.RowEntry;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen",date = "2016-09-29T00:36:11.447Z")
public abstract class RowApiService {
    public abstract Response rowPut(String tableId,
                                    RowEntry row,
                                    SecurityContext securityContext) throws NotFoundException;
}
