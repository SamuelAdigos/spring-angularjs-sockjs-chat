package samueladigos.chat.config;

import java.nio.charset.StandardCharsets;

import javax.servlet.*;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class InicializadorApp extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected void customizeRegistration(ServletRegistration.Dynamic registro) {
	  registro.setInitParameter("dispatchOptionsRequest", "true");
	  registro.setAsyncSupported(true);
  }

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { ConfiguracionApp.class, ConfiguracionSocket.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { ConfiguracionWeb.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

  @Override
  protected Filter[] getServletFilters() {
    CharacterEncodingFilter filtroCodificacion = new CharacterEncodingFilter();
    filtroCodificacion.setEncoding(StandardCharsets.UTF_8.name());
    return new Filter[] { filtroCodificacion };
  }
}
