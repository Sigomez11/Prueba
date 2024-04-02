package dptoPolicia;

import java.util.Arrays;
import java.util.Date;

public class Homicidio extends Caso {
	
	//Atributos
	private String tipoHomicidio, armaCausante;
	private Ciudadano[] victimasHomicidio;
	
	//Constructor
	public Homicidio(String codCaso, String ubicacion, String descripcion,String tipoHomicidio,
			String armaCausante, Date fecha, nivelPrioridad np) {
		
		super(codCaso, ubicacion, descripcion,fecha,np);
		this.tipoHomicidio = tipoHomicidio;
		this.armaCausante = armaCausante;
		this.victimasHomicidio= new Ciudadano[0];
	}
	
	//Agregar  victima: solo este, ya que se espera que al agregarlas es porque está confirmado
	public void addVictimaHomicidio(String ccVictimaHomicidio, DptoPolicia dptoPol) throws ECiudadanoNoHallado {
		int k = dptoPol.buscarCiudadano(ccVictimaHomicidio);
		if(k != -1) {
			victimasHomicidio = Arrays.copyOf(victimasHomicidio, victimasHomicidio.length+1);
			victimasHomicidio[victimasHomicidio.length-1] = dptoPol.getCiudadanos()[k];
		}else {
			throw new ECiudadanoNoHallado();
		}		
	}
        
        //Buscar victima
        public int buscarVictimaHomicidio(String cc){
            int i=0;
            while(i<victimasHomicidio.length && !(victimasHomicidio[i].getId().equalsIgnoreCase(cc))){
                i++;
            }
            return (i<victimasHomicidio.length)? i : -1;
        }
        
        //Eliminar victima
        public void eliminarVictimaHomicidio(String ccVictimaHomicidio) throws ECiudadanoNoHallado{
                int k = buscarVictimaHomicidio(ccVictimaHomicidio);
                if(k!=-1){
                    victimasHomicidio[k] = null;
                    for(int j = k; j<victimasHomicidio.length; j++){
                        victimasHomicidio[j] = victimasHomicidio[j+1];
                    }
                    victimasHomicidio = Arrays.copyOf(victimasHomicidio, victimasHomicidio.length-1);
                }else{
                    throw new ECiudadanoNoHallado();
                }
            
        }
	
	//Getters-Setters
	public String getTipoHomicidio() {
		return tipoHomicidio;
	}

	public void setTipoHomicidio(String tipoHomicidio) {
		this.tipoHomicidio = tipoHomicidio;
	}

	public String getArmaCausante() {
		return armaCausante;
	}

	public void setArmaCausante(String armaCausante) {
		this.armaCausante = armaCausante;
	}


	public Ciudadano[] getVictimasHomicidio() {
		return victimasHomicidio;
	}

	public void setVictimasHomicidio(Ciudadano[] victimasHomicidio) {
		this.victimasHomicidio = victimasHomicidio;
	}
	

}
