package negocio;

import datos.Dispositivo;

public class EventoAbm {
	

	
	private static EventoAbm instancia=null;
	public EventoAbm() {}
	public static EventoAbm getInstance(){
	if(instancia==null)
	instancia=new EventoAbm();
	return instancia;
	}
	
	
	

}
