package samueladigos.chat.config;

import org.springframework.context.annotation.*;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages = "samueladigos.chat.controller")
public class ConfiguracionSocket extends AbstractWebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry configuracion) {
	  configuracion.enableSimpleBroker("/asunto");
	  configuracion.setApplicationDestinationPrefixes("/app");
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registro) {
	  registro.addEndpoint("/chat").withSockJS();
  }
}
