package Dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

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
	public void test2()
	{
		System.out.println("Estoy en metodo test tituloCoincide(String email,String titulo) cuando existen email y titulo");
		
		Socio esperado=new Socio("a", "a", "0", "@", "1");
		
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
	
	
	
	

}