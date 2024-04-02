package dptoPolicia;

import java.io.Serializable;
import java.util.Date;

public class Ciudadano implements Serializable{
	//Declaracion variables
	protected String nombre;
	protected String id;
	protected String direccion;
	protected Date fechaNacimiento;
	protected String celular;
	//Metodo constructor
	public Ciudadano(String nombre, String id, String direccion, Date fechaNacimiento, String celular) {
		this.nombre = nombre;
		this.id = id;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
	}
	//Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	

}
