package dptoPolicia;

public class ECiudadanoNoHallado extends Exception {

	public ECiudadanoNoHallado() {
		super("No se encontró el ciudadano buscado");
	}
	
}
