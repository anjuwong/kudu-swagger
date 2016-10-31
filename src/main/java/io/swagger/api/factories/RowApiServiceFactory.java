package io.swagger.api.factories;

import io.swagger.api.RowApiService;
import io.swagger.api.impl.RowApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-29T00:36:11.447Z")
public class RowApiServiceFactory {
    private final static RowApiService service = new RowApiServiceImpl();

    public static RowApiService getRowApi() {
        return service;
    }
}
