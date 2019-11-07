package samueladigos.chat.dto;

public class Mensaje {

  private String mensaje;
  private int id;
  
  public Mensaje() {
    
  }
  
  public Mensaje(int id, String mensaje) {
    this.id = id;
    this.mensaje = mensaje;
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
