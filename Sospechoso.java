package dptoPolicia;

import java.util.Date;

public class Sospechoso extends Ciudadano{
	//Declaracion variables
	private Date fechaDetencion;
	private String descripcionSospecha;
	private boolean isCriminal;
	private boolean isDetenido;
	//Metodo constructor
	public Sospechoso(String nombre, String id, String direccion, Date fechaNacimiento, String celular, String descripcionSospecha) {
		super(nombre, id, direccion, fechaNacimiento, celular);
		this.descripcionSospecha = descripcionSospecha;
		this.isCriminal = false;
		this.isDetenido = false;
	}
	//Getters y setters
	public Date getFechaDetencion() {
		return fechaDetencion;
	}
	//Set fecha de detencion con excepcion (si el sospechoso no esta detenido no se puede añadir fecha detencion
	public void setFechaDetencion (Date fechaDetencion)throws EFechaDetencion {
		if(isDetenido==true) {
			this.fechaDetencion = fechaDetencion;
		} else {
			throw new EFechaDetencion();
		}
	}
	public String getDescripcionSospecha() {
		return descripcionSospecha;
	}
	public void setDescripcionSospecha(String descripcionSospecha) {
		this.descripcionSospecha = descripcionSospecha;
	}

	public boolean isCriminal() {
		return isCriminal;
	}
	public void setCriminal(boolean isCriminal) {
		this.isCriminal = isCriminal;
	}
	public boolean isDetenido() {
		return isDetenido;
	}
	public void setDetenido(boolean isDetenido) {
		this.isDetenido = isDetenido;
	}
	
	

}


