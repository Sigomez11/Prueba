package dptoPolicia;

import java.util.Date;

public class Policia extends Ciudadano{
	//Declaracion Variables
	private Rango rango;
	private String placa;
	private int tiempoServicio;
	private String sedeActual;
	private int casosResueltos;
	
	//Metodo constructor
	public Policia(String nombre, String id, String direccion, Date fechaNacimiento, String celular, Rango rango,
			String placa, String sedeActual) {
		super(nombre, id, direccion, fechaNacimiento, celular);
		this.rango = rango;
		this.placa = placa;
		this.sedeActual = sedeActual;
	}
	//Getters y setters
	public Rango getRango() {
		return rango;
	}
	public void setRango(Rango rango) {
		this.rango = rango;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getTiempoServicio() {
		return tiempoServicio;
	}
	public void setTiempoServicio(int tiempoServicio) {
		this.tiempoServicio = tiempoServicio;
	}
	public String getSedeActual() {
		return sedeActual;
	}
	public void setSedeActual(String sedeActual) {
		this.sedeActual = sedeActual;
	}
	public int getCasosResueltos() {
		return casosResueltos;
	}
	public void setCasosResueltos(int casosResueltos) {
		this.casosResueltos = casosResueltos;
	}
	
}
