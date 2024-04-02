package dptoPolicia;

import java.util.Date;

public class Secuestro extends Caso {
	
	private String ultimaVezVisto, linkFoto;
	private Ciudadano secuestrado;
	
	//Constructor
	public Secuestro(String codCaso, String ubicacion, String descripcion,
			String ultimaVezVisto, String linkFoto,
			String CCsecuestrado,Date fecha, nivelPrioridad np, DptoPolicia dptoPol) throws ECiudadanoNoHallado {
		
		super(codCaso, ubicacion, descripcion,fecha,np);
		this.ultimaVezVisto = ultimaVezVisto;
		this.linkFoto = linkFoto;
		
		//Agregar el desaparecido
		int h = dptoPol.buscarCiudadano(CCsecuestrado);
		if(h != -1) {
			secuestrado = dptoPol.getCiudadanos()[h];
		}else {
			throw new ECiudadanoNoHallado();
		}
	}
	
	//Gtters-Setters
	public String getUltimaVezVisto() {
		return ultimaVezVisto;
	}

	public void setUltimaVezVisto(String ultimaVezVisto) {
		this.ultimaVezVisto = ultimaVezVisto;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	public Ciudadano getSecuestrado() {
		return secuestrado;
	}

	public void setSecuestrado(Ciudadano secuestrado) {
		this.secuestrado = secuestrado;
	}

}
