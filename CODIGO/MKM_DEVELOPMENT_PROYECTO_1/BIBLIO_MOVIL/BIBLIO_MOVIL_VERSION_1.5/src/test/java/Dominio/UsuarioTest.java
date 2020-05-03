package Dominio;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsuarioTest {

	static Usuario miusuario;
	static BiblioMovil miBiblio;
	
	@BeforeClass
	public static void beforeClass() 
	{
	 	System.out.println("Estoy metodo beforeClass");
	 	miusuario=new Usuario(); 	
	 	miBiblio=new BiblioMovil();
	}

	@Before
	public void before() 
	{
		System.out.println("Estoy metodo before");
	}
	
	//Usuario se registra
	
	@Test
	public void test1()
	{
		System.out.println("Estoy en metodo test Registrarse()");
		
		Socio esperado=new Socio("Juan", "Gomez", "14-01-1980", "juan@gmail.com", "123");
		
		boolean verdadero=false;
		
			Socio resultado=miusuario.Registrarse("Juan", "Gomez", "14-01-1980", "juan@gmail.com", "123");
			if(esperado.toString().equals(resultado.toString()))
			{
				verdadero=true;
			}
			else
			{
				verdadero=false;
			}

		assertTrue(verdadero);
	}
	
	
	
	

}