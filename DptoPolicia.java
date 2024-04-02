package dptoPolicia;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class DptoPolicia implements Serializable{
	//Declaracion de variables
	private Ciudadano[] ciudadanos;
	private Policia[] policias;
	private Caso[] casos;
        private Sospechoso[] sospechosos;
	
	//Constructor
	public DptoPolicia() {
		ciudadanos = new Ciudadano[0];
		this.casos = new Caso[0];
		this.policias = new Policia[0];
                this.sospechosos = new Sospechoso[0];
	}
	
	
	//Metodo para añadir ciudadanos a la lista de ciudadanos
	public void addCiudadano (String nombre, String id, String direccion, Date fechaNacimiento, String celular) {
		ciudadanos= Arrays.copyOf(ciudadanos, ciudadanos.length+1);
		ciudadanos[ciudadanos.length-1] = new Ciudadano(nombre, id, direccion, fechaNacimiento, celular);
	}
	
	//Metodo buscar Ciudadano
	public int buscarCiudadano(String cc) {
		int i=0;
		while(i<ciudadanos.length && !(cc.equalsIgnoreCase(ciudadanos[i].getId()))) {
			i++;
		}
		return (i<ciudadanos.length)?i:-1;
                
	}
	
	//Metodo para eliminar un ciudadano de la lista por la cc
	public void eliminarCiudadano(String cc) throws ECiudadanoNoHallado {
		int j = buscarCiudadano(cc);
		if(j!=-1) {
		ciudadanos[j] = null;
		for(int i=j; i<ciudadanos.length-1; i++) {
			ciudadanos[i]=ciudadanos[i+1];
		}
		ciudadanos = Arrays.copyOf(ciudadanos,ciudadanos.length-1);
		}else {
			throw new ECiudadanoNoHallado();
		}
	}
	
	//Metodo para añadir policias a la lista de policias
	public void addPolicia (String nombre, String id, String direccion, Date fechaNacimiento, String celular, Rango rango,
			String placa, String sedeActual) {
		policias= Arrays.copyOf(policias, policias.length+1);
		policias[policias.length-1] = new Policia(nombre,id,direccion,fechaNacimiento,celular, rango,
				 placa, sedeActual);
	}
        
	//Metodo para añadir Sospechosos a la lista de policias
	public void addSospechoso (String nombre, String id, String direccion, Date fechaNacimiento, String celular, String descripSospecha) {
		sospechosos= Arrays.copyOf(sospechosos, sospechosos.length+1);
		sospechosos[sospechosos.length-1] = new Sospechoso(nombre,id,direccion,fechaNacimiento,celular, descripSospecha);
	}
        //Metodo buscar Policia
	public int buscarSospechoso(String cc) {
		int i=0;
		while(i<sospechosos.length && !cc.equals(sospechosos[i].getId())) {
			i++;
		}
		return (i<sospechosos.length)? i : -1;
	}
        
	
	//Metodo buscar Policia
	public int buscarPolicia(String cc) {
		int i=0;
		while(i<policias.length && !cc.equals(policias[i].getId())) {
			i++;
		}
		return (i<policias.length)? i : -1;
	}
	
	//Metodo para eliminar policia de la lista por la cc
	public void eliminarPolicia(String cc) throws ECiudadanoNoHallado {
		int j= buscarPolicia(cc);
		if(j!=-1) {
		policias[j] = null;
		for(int i=j; i<policias.length-1; i++) {
			policias[i]=policias[i+1];
		}
		policias = Arrays.copyOf(policias, policias.length-1);
		}else {
			throw new ECiudadanoNoHallado();
		}
	}
	
	//Metodo añadir caso
	public void addCaso(String codCaso, String ubicacion, String descripcion, Date fecha, nivelPrioridad np) {
		casos = Arrays.copyOf(casos, casos.length+1);
		casos[casos.length-1] = new Caso(codCaso, ubicacion, descripcion, fecha, np);
	}
	//Buscar caso
	public int buscarCaso(String codCaso) {
		int k=0;
		while(k<casos.length && !(casos[k].getCodCaso().equalsIgnoreCase(codCaso))) {
			k++;
		}
		return (k<casos.length)? k : -1;
	}
        
        //Eliminar Caso
        public void eliminarCaso(String codCaso) throws ECasoNoHallado{
            int k = buscarCaso(codCaso);
            if(k!=-1){
                casos[k] = null;
                for(int i=k; i<casos.length-1; i++){
                    casos[i] = casos[i+1];
                }
                casos = Arrays.copyOf(casos, casos.length-1);
            }else{
                throw new ECasoNoHallado();
            }
        }
	
	//Metodo añadir homicidio
	public void addHomicidio(String codCaso, String ubicacion, String descripcion,String tipoHomicidio,
			String armaCausante,Date fecha, nivelPrioridad np) {
		casos = Arrays.copyOf(casos, casos.length+1);
		casos[casos.length-1] = new Homicidio(codCaso, ubicacion, descripcion,tipoHomicidio,
				armaCausante, fecha ,np);
	}
        //Metodo añadir Robo
        public void addRobo(String codCaso, String ubicacion, String descripcion, String tipoRobo,
                Date fecha, nivelPrioridad np){
            casos = Arrays.copyOf(casos, casos.length+1);
            casos[casos.length-1] = new Robo(codCaso,ubicacion,descripcion,tipoRobo,
                 fecha, np);
        }
	
	//Metodo añadir abusoSexual
	public void addAbusoSexual(String codCaso, String ubicacion,String ccCiud, String descripcion,
			boolean menorDeEdad, nivelAcoso nivelDeAcoso,
			Date fecha, nivelPrioridad np, DptoPolicia dpto) throws ECiudadanoNoHallado {
            
                    casos = Arrays.copyOf(casos, casos.length+1);
                    casos[casos.length-1] = new AbusoSexual(codCaso, ccCiud, ubicacion, descripcion,
		    menorDeEdad,nivelDeAcoso, fecha, np, dpto);

	}
	
	//Metodo añadir Secuestro
	public void addSecuestro(String codCaso, String ubicacion, String descripcion,
			String ultimaVezVisto, String linkFoto,
			String CCsecuestrado, Date fecha, nivelPrioridad np, DptoPolicia dpto) throws ECiudadanoNoHallado {	
		casos = Arrays.copyOf(casos, casos.length+1);
		casos[casos.length-1] = new Secuestro(codCaso, ubicacion, descripcion,ultimaVezVisto,
				linkFoto, CCsecuestrado, fecha, np, dpto);
	}
	
	//Metodo añadir victimas
	
	//Homicidio
	public void addVictimaHomicidio(String ccVictimaHomicidio, String codCaso, DptoPolicia dpto) throws ECiudadanoNoHallado, ECasoNoHallado {
		//Buscar que caso es
		int k =buscarCaso(codCaso); 
		//Revisar si el caso es un homicidio y que se halla encontrado
		if(k != -1 && casos[k] instanceof Homicidio) {
			((Homicidio)casos[k]).addVictimaHomicidio(ccVictimaHomicidio, dpto);
		}else {                    
                        throw new ECasoNoHallado();         
		}
		
	}
        //Eliminar victima Homicidio
        public void eliminarVictimaHomicidio(String cc, String codCaso) throws ECiudadanoNoHallado, ECasoNoHallado{
            	int y = buscarCaso(codCaso);
		if(casos[y] instanceof Homicidio && y!=-1) {
			((Homicidio) casos[y]).eliminarVictimaHomicidio(cc);
		}else {
			throw new ECasoNoHallado();
		}
        }
	
	//Robo
	public void addVictimaRobo(String ccVictimaRobo, String codCaso, DptoPolicia dpto) throws ECiudadanoNoHallado, ECasoNoHallado  {
		//Buscar que caso es
		int k =buscarCaso(codCaso);
		//Revisar si el caso es un homicidio y que se halla encontrado
		if(k != -1 && casos[k] instanceof Robo) {
			((Robo)casos[k]).addVictimaRobo(ccVictimaRobo, dpto);
		}else {
			throw new ECasoNoHallado();                        
                    
		}
	}
                //Eliminar victima Robo
        public void eliminarVictimaRobo(String cc, String codCaso) throws ECiudadanoNoHallado, ECasoNoHallado{
            	int y = buscarCaso(codCaso);
		if(casos[y] instanceof Robo && y!=-1) {
			((Robo) casos[y]).eliminarVictimaRobo(cc);
		}else {
			throw new ECasoNoHallado();
		}
        }
	
	//Añadir objeto robado
	public void addObjetoRobado(String nomObjeto, String codCaso) throws ECasoNoHallado {
		int k =buscarCaso(codCaso); //Buscar el Caso
		if(k!=-1 && casos[k] instanceof Robo) {
			((Robo)casos[k]).addObjetoRobado(nomObjeto);
		}else {
			throw new ECasoNoHallado();
		}
	}
	
	//Eliminar objeto robado
	public void eliminarObjetoRobado(String codCaso,String nombreObjeto) throws ECasoNoHallado, EObjetoRobadoN {
		int y = buscarCaso(codCaso);
		if(casos[y] instanceof Robo && y!=-1) {
			((Robo) casos[y]).eliminarObjetoRobado(nombreObjeto);
		}else {
			throw new ECasoNoHallado();
		}
	}
	
	//Asignaciones a los casos
	//Policia
	public void asignarPolicia(String CC, DptoPolicia dptoPol, String codCaso) throws ECasoNoHallado, EPoliciaNoHallado {
		//En que caso se va a colocar?
		int k = buscarCaso(codCaso);
		if(k !=-1) {	//Caso si se encuentra
			casos[k].asignarPolicia(CC, dptoPol);	//Asignarlo
		}else {
			throw new ECasoNoHallado();
		}
	}
	//Sospechoso
	public void asignarSospechoso(String CC, DptoPolicia dpto, String codCaso) throws ECasoNoHallado, ECiudadanoNoHallado {
		//En que caso se va a colocar?
		int k = buscarCaso(codCaso);
		if(k !=-1) {	//Caso si se encuentra
			casos[k].asignarSospechoso(CC,dpto);	//Asignarlo
		}else {
			throw new ECasoNoHallado();
		}
	}
	
	

	//Getters-Setters
	public Policia[] getPolicias() {
		return policias;
	}


	public void setPolicias(Policia[] policias) {
		this.policias = policias;
	}


	public Caso[] getCasos() {
		return casos;
	}


	public void setCasos(Caso[] casos) {
		this.casos = casos;
	}


	public Ciudadano[] getCiudadanos() {
		return ciudadanos;
	}


	public void setCiudadanos(Ciudadano[] ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

        public Sospechoso[] getSospechosos() {
            return sospechosos;
        }

    public void setSospechosos(Sospechoso[] sospechosos) {
        this.sospechosos = sospechosos;
    }
        
	

}
