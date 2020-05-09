package Presentacion;

public class ErrorIntroducirNumeros extends Exception
{

	public ErrorIntroducirNumeros()
	{
		
	}
	
	public ErrorIntroducirNumeros(String mensaje_error)
	{
		super(mensaje_error);
	}
}
