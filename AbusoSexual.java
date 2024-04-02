package dptoPolicia;

import java.util.Arrays;
import java.util.Date;

public class AbusoSexual extends Caso {
	
	//Atributos
	private Ciudadano victimaAbusoSexual;
	private boolean menorDeEdad;
	private nivelAcoso nivelDeAcoso;
	
	//Constructor
	public AbusoSexual(String codCaso, String ccCiud, String ubicacion ,String descripcion, boolean menorDeEdad,
			nivelAcoso nivelDeAcoso, Date fecha, nivelPrioridad np, DptoPolicia dptoPol) throws ECiudadanoNoHallado {
		
		super(codCaso, ubicacion, descripcion, fecha, np);
		this.menorDeEdad = menorDeEdad;
		this.nivelDeAcoso = nivelDeAcoso;
		
		int h = dptoPol.buscarCiudadano(ccCiud);	
		if(h!=-1) {
			this.victimaAbusoSexual = dptoPol.getCiudadanos()[h];
		}else {
			throw new ECiudadanoNoHallado();
		}

	}
	
	
	//Getters-Setters
	public boolean isMenorDeEdad() {
		return menorDeEdad;
	}

	public void setMenorDeEdad(boolean menorDeEdad) {
		this.menorDeEdad = menorDeEdad;
	}

	public nivelAcoso getNivelDeAcoso() {
		return nivelDeAcoso;
	}

	public void setNivelDeAcoso(nivelAcoso nivelDeAcoso) {
		this.nivelDeAcoso = nivelDeAcoso;
	}

        public Ciudadano getVictimaAbusoSexual() {
            return victimaAbusoSexual;
        }
	
	


	

}
