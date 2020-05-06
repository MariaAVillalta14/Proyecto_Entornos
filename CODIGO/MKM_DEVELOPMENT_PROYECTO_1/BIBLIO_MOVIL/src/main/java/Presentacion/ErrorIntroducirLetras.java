package Presentacion;

public class ErrorIntroducirLetras extends Exception {

	public ErrorIntroducirLetras()
	{
		
	}
	
	public ErrorIntroducirLetras(String mensaje)
	{
		super(mensaje);
	}
}
