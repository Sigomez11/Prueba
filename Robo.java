package dptoPolicia;

import java.util.Arrays;
import java.util.Date;

public class Robo extends Caso{
	
	//Atributos
	private String[] objetosRobados;
	private String tipoDeRobo;
	private Ciudadano[] victimasRobo;
	
	//Constructor
	public Robo(String codCaso, String ubicacion, String descripcion, String tipoDeRobo
			,Date fecha, nivelPrioridad np) {
		super(codCaso, ubicacion, descripcion,fecha,np);
		this.objetosRobados = new String[0];
		this.tipoDeRobo = tipoDeRobo;
		this.victimasRobo = new Ciudadano[0];
	}
	
	//Añadir Objeto robado
	public void addObjetoRobado(String nuevoObjeto) {	
		String[] newObjetosRobados = new String[objetosRobados.length + 1];
		System.arraycopy(objetosRobados, 0, newObjetosRobados, 0, objetosRobados.length);
		newObjetosRobados[newObjetosRobados.length - 1]= nuevoObjeto;
		objetosRobados = newObjetosRobados;
	}
	
	//Añadir victima
	public void addVictimaRobo(String ccVictimaHomicidio, DptoPolicia dptoPol) throws ECiudadanoNoHallado {
		int k = dptoPol.buscarCiudadano(ccVictimaHomicidio);
		if(k != -1) {
			victimasRobo = Arrays.copyOf(victimasRobo, victimasRobo.length+1);
			victimasRobo[victimasRobo.length-1] = dptoPol.getCiudadanos()[k];
		}else {
			throw new ECiudadanoNoHallado();
		}		
	}
        //Buscar victima
        public int buscarVictimaHomicidio(String cc){
            int i=0;
            while(i<victimasRobo.length && !(victimasRobo[i].getId().equalsIgnoreCase(cc))){
                i++;
            }
            return (i<victimasRobo.length)? i : -1;
        }        
	
	//Eliminar objeto robado
	public void eliminarObjetoRobado(String nombreObjeto) throws EObjetoRobadoN {  
            int j = buscarObjetoRobado(nombreObjeto);
		if(j!=-1) {
		objetosRobados[j] = null;
		for(int i= j; i<objetosRobados.length-1;i++) {
			objetosRobados[i] = objetosRobados[i+1];
		}
		objetosRobados = Arrays.copyOf(objetosRobados, objetosRobados.length-1);
		}else {
			throw new EObjetoRobadoN();	
		}
	}
        //Buscar Objeto Robado
        public int buscarObjetoRobado(String nombreObjeto){
            int i = 0;
            while(i<objetosRobados.length && !(objetosRobados[i].equalsIgnoreCase(nombreObjeto))){
                i++;
            }
            return (i<objetosRobados.length)? i : -1;
        }
                
        //Eliminar victima
        
        public void eliminarVictimaRobo(String ccVictimaHomicidio) throws ECiudadanoNoHallado{
                int k = buscarVictimaHomicidio(ccVictimaHomicidio);
                if(k!=-1){
                    victimasRobo[k] = null;
                    for(int j = k; j<victimasRobo.length; j++){
                        victimasRobo[j] = victimasRobo[j+1];
                    }
                    victimasRobo = Arrays.copyOf(victimasRobo, victimasRobo.length-1);
                }else{
                    throw new ECiudadanoNoHallado();
                }
            
        }

	//Getters-Setters
	public String[] getObjetosRobados() {
		return objetosRobados;
	}

	public void setObjetosRobados(String[] objetosRobados) {
		this.objetosRobados = objetosRobados;
	}

	public String getTipoDeRobo() {
		return tipoDeRobo;
	}

	public void setTipoDeRobo(String tipoDeRobo) {
		this.tipoDeRobo = tipoDeRobo;
	}
	
	


}
