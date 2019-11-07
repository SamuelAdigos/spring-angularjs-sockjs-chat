package samueladigos.chat.controller;

import java.util.Date;

import org.slf4j.*;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import samueladigos.chat.dto.*;

@Controller
@RequestMapping("/")
public class ChatController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @RequestMapping(method = RequestMethod.GET)
  public String viewApplication() {
    return "index";
  }

  @MessageMapping("/chat")
  @SendTo("/asunto/mensaje")
  public MensajeSalida enviarMensaje(Mensaje mensaje) {
    logger.info("Mensaje enviado");
    return new MensajeSalida(mensaje, new Date());
  }
}
