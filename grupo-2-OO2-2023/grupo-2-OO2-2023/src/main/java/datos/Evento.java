package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {

	private int idEvento;
	private String descripcion;
	private Dispositivo dispositivo;
	private LocalDate fecha;
	private LocalTime horaDesde;
	private LocalTime horaHasta;
	
	
	public Evento(String descripcion, Dispositivo dispositivo, LocalDate fecha, LocalTime horaDesde,
			LocalTime horaHasta) {
		super();
		
		this.descripcion = descripcion;
		this.dispositivo = dispositivo;
		this.fecha = fecha;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
		
		
	}


	public int getIdEvento() {
		return idEvento;
	}


	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Dispositivo getDispositivo() {
		return dispositivo;
	}


	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public LocalTime getHoraDesde() {
		return horaDesde;
	}


	public void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}


	public LocalTime getHoraHasta() {
		return horaHasta;
	}


	public void setHoraHasta(LocalTime horaHasta) {
		this.horaHasta = horaHasta;
	}


	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", descripcion=" + descripcion + ", dispositivo=" + dispositivo
				+ ", fecha=" + fecha + ", horaDesde=" + horaDesde + ", horaHasta=" + horaHasta + "]";
	}
	
	
	
	
}
