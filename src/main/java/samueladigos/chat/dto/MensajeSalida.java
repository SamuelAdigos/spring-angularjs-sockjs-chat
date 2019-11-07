package samueladigos.chat.dto;

import java.util.Date;

public class MensajeSalida extends Mensaje {

	private Date hora;
	
	public MensajeSalida(Mensaje original, Date hora) {
		super(original.getId(), original.getMensaje());
		this.hora = hora;
	}
	
	public Date getHora() {
		return hora;
	}
	
	public void setHora(Date hora) {
		this.hora = hora;
	}
}
