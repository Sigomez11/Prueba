package dptoPolicia;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class Caso implements Serializable{
	
	//Excepcion por no poder añadir víctimas
	
	//Atributos
	private Date fecha;
	private String codCaso;
	private Policia[] policiasCaso;
	private Sospechoso[] sospechososCaso;
	private String ubicacion;
	private String descripcionCaso;
	private nivelPrioridad nivelDePrioridad;
	private boolean casoResuelto;
	
	//Constructor
	public Caso(String codCaso, String ubicacion, String descripcion, Date fecha, nivelPrioridad np) {
	      //Iniciales
	      this.codCaso=codCaso;
	      this.ubicacion=ubicacion;
	      this.descripcionCaso=descripcion;
	      this.casoResuelto=false;
	      this.policiasCaso= new Policia[0];
	      this.sospechososCaso = new Sospechoso[0];
	//      this.testigoCaso = new Ciudadano[0];
	      this.fecha=fecha;
	      this.nivelDePrioridad = np;
	    
	}
	//Asignar policia NUEVO-Mirar la Excepción
	public void asignarPolicia(String CC, DptoPolicia dptoPol) throws EPoliciaNoHallado {
		//DptoPolicia dptoPol = new DptoPolicia();
		int h=dptoPol.buscarPolicia(CC);
		if(h!= -1) {
			policiasCaso = Arrays.copyOf(policiasCaso, policiasCaso.length+1);
			policiasCaso[policiasCaso.length-1] = dptoPol.getPolicias()[h];
		}else {
			throw new EPoliciaNoHallado();
		}	
	}
	//Asignar Sospechoso
	public void asignarSospechoso(String CC, DptoPolicia dptoPol) throws ECiudadanoNoHallado {
		int h=dptoPol.buscarCiudadano(CC);
		if(h!= -1) {
			sospechososCaso = Arrays.copyOf(sospechososCaso, sospechososCaso.length+1);
			sospechososCaso[sospechososCaso.length-1] = dptoPol.getSospechosos()[h];
		}else {
			throw new ECiudadanoNoHallado();
		}	
	}
        
        
	//Getters-Setters

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Sospechoso[] getSospechososCaso() {
		return sospechososCaso;
	}

	public void setSospechososCaso(Sospechoso[] sospechososCaso) {
		this.sospechososCaso = sospechososCaso;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcionCaso() {
		return descripcionCaso;
	}

	public void setDescripcionCaso(String descripcionCaso) {
		this.descripcionCaso = descripcionCaso;
	}

	/*public Ciudadano[] getTestigoCaso() {
		return testigoCaso;
	}

	public void setTestigoCaso(Ciudadano[] testigoCaso) {
		this.testigoCaso = testigoCaso;
	}*/

	public nivelPrioridad getNivelDePrioridad() {
		return nivelDePrioridad;
	}

	public void setNivelDePrioridad(nivelPrioridad nivelDePrioridad) {
		this.nivelDePrioridad = nivelDePrioridad;
	}

	public boolean isCasoResuelto() {
		return casoResuelto;
	}

	public void setCasoResuelto(boolean casoResuelto) {
		this.casoResuelto = casoResuelto;
	}

	public String getCodCaso() {
		return codCaso;
	}

	public Policia[] getPoliciasCaso() {
		return policiasCaso;
	}
	

}
