package Dominio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
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
	
	//Método --> Registrarse(BiblioMovil miBiblio)
	
	@Test
	public void test1()
	{
		System.out.println("Estoy en metodo test Registrarse(BiblioMovil miBiblio)");
		
		Socio esperado=new Socio("Carlos", "Quintero", "02-02-1993", "carlos@gmail.com", "12345");
		
		boolean verdadero=false;
		do
		{
			Socio resultado=miusuario.Registrarse(miBiblio);
			if(esperado.toString().equals(resultado.toString()))
			{
				verdadero=true;
			}
			else
			{
				verdadero=false;
			}
		}
		while(verdadero==false);
		assertTrue(verdadero);
	}
	
	
	@After
	public void after() 
	{
		System.out.println("Estoy metodo after"); 
		
	}
		 			
	@AfterClass 
	public static void afterClass() 
	{
		System.out.println("Estoy metodo afterClass"); 	
	}	
	
	

}
