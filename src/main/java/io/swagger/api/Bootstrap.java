package io.swagger.api;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.*;

import io.swagger.models.auth.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import org.apache.kudu.client.AsyncKuduClient;

import io.swagger.api.KuduContext;

public class Bootstrap extends HttpServlet {
  KuduContext kuduContext;

  @Override
  public void init(ServletConfig config) throws ServletException {
    Info info = new Info()
      .title("Kudu Swagger Server")
      .description("Connect to a Kudu cluster via REST")
      .termsOfService("")
      .contact(new Contact()
        .email(""))
      .license(new License()
        .name("")
        .url(""));

    ServletContext context = config.getServletContext();
    Swagger swagger = new Swagger().info(info);

    new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);

    // Initialize KuduContext singleton.
    AsyncKuduClient client = new AsyncKuduClient.AsyncKuduClientBuilder(
      KuduContext.master_addr_).build();
    KuduContext kuduContext = KuduContext.getInstance(client);
  }
}
