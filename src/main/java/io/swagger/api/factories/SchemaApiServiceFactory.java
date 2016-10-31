package io.swagger.api.factories;
import io.swagger.api.SchemaApiService;
import io.swagger.api.impl.SchemaApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-29T00:36:11.447Z")
public class SchemaApiServiceFactory {
    private final static SchemaApiService service = new SchemaApiServiceImpl();

    public static SchemaApiService getSchemaApi() {
        return service;
    }

    public static SchemaApiService putSchemaApi() {
        return service;
    }
}
