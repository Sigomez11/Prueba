package dptoPolicia;

import java.util.Date;

public class Desaparecido extends Ciudadano{
	//Declaracion variables
	private String lugarUltimaVezVisto;
	private boolean isEncontrado;
	private boolean isMuerto;
	private boolean isSecuestrado;
	//Metodo constructor
	public Desaparecido(String nombre, String id, String direccion, Date fechaNacimiento, String celular,
			String lugarUltimaVezVisto, boolean isSecuestrado) {
		super(nombre, id, direccion, fechaNacimiento, celular);
		this.lugarUltimaVezVisto = lugarUltimaVezVisto;
		this.isSecuestrado = isSecuestrado;
	}
	//Getters y setters
	public String getLugarUltimaVezVisto() {
		return lugarUltimaVezVisto;
	}
	public void setLugarUltimaVezVisto(String lugarUltimaVezVisto) {
		this.lugarUltimaVezVisto = lugarUltimaVezVisto;
	}
	public boolean isEncontrado() {
		return isEncontrado;
	}
	public void setEncontrado(boolean isEncontrado) {
		this.isEncontrado = isEncontrado;
	}
	public boolean isMuerto() {
		return isMuerto;
	}
	public void setMuerto(boolean isMuerto) {
		this.isMuerto = isMuerto;
	}
	public boolean isSecuestrado() {
		return isSecuestrado;
	}
	public void setSecuestrado(boolean isSecuestrado) {
		this.isSecuestrado = isSecuestrado;
	}
	
	

}
