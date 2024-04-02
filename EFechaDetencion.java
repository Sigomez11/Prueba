package dptoPolicia;

public class EFechaDetencion extends Exception{
	public EFechaDetencion () {
		super("El sospechosos debe estar detenido para poder añadir fecha de detencion");
	}

}
