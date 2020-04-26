package Dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SancionTest {
 
	static Sancion sanciones;
	static ArrayList<Sancion> listaSancion;
	@BeforeClass
 	public static void beforeClass() 
	{
 		System.out.println("Estoy metodo beforeClass");
 		sanciones=new Sancion();
 		listaSancion = new ArrayList<Sancion>();
		listaSancion.add(new Sancion("zapatacamila@gmail.com","Cien años de soledad"));
		listaSancion.add(new Sancion("lau_aguirre@hotmail.com","La chica de nieve"));
	}

	@Before
	public void before() 
	{
	 	System.out.println("Estoy metodo before");
	}
	
	// Método --> Método miSancion()
	
	@Test
	public void test1()
	{
		System.out.println("Estoy metodo miSancion() cuando la sancion SI existe");
		Sancion esperado;
		Sancion resultado = null;
		System.out.println("Estoy metodo miSancion() cuando la sancion NO existe");
		esperado=new Sancion("zapatacamila@gmail.com","Cien años de soledad");
		for(int i=0; i<sanciones.getMis_sanciones().size();i++) 
		{
			if(sanciones.getMis_sanciones().get(i).getEmailSocio().equalsIgnoreCase("zapatacamila@gmail.com"))
			{
				if(sanciones.getMis_sanciones().get(i).getTitulo_libro_prestamo().equalsIgnoreCase("Cien años de soledad"))
				{
				   resultado = sanciones.miSancion();
				}
			}
		}		
		assertEquals(esperado.toString(),resultado.toString());
	}
	
	@Test
	public void test2()
	{
		Sancion esperado=null;;
		Sancion resultado = null;
		System.out.println("Estoy metodo miSancion() cuando la sancion NO existe");
		
		for(int i=0; i<sanciones.getMis_sanciones().size();i++) 
		{
			if(sanciones.getMis_sanciones().get(i).getEmailSocio().equalsIgnoreCase("villaltamaria@gmail.com"))
			{
				if(sanciones.getMis_sanciones().get(i).getTitulo_libro_prestamo().equalsIgnoreCase("Cien años de soledad"))
				{
				   resultado = sanciones.miSancion();
				}
			}
		}		
		assertEquals(esperado,resultado);
	}
	 	
	// Método --> comprobarSancion(String email)
	@Test
	public void test3()
	{
		System.out.println("Estoy metodo comprobarSancion(String email) cuando la sancion SI existe");
		boolean esperado=true;
		boolean resultado=sanciones.comprobarSancion("zapatacamila@gmail.com");
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test4()
	{
		System.out.println("Estoy metodo comprobarSancion(String email) cuando la sancion NO existe");
		boolean esperado=false;
		boolean resultado=sanciones.comprobarSancion("villaltamaria@gmail.com");
		assertEquals(esperado,resultado);
	}
	
	// Método --> anyadirSancion(Sancion misancion) y getSocio
	
	@Test
	public void test5()
	{
		System.out.println("Estoy en método getSocio y anyadirSancion");	
		ArrayList<Sancion> esperado=listaSancion;
		
		Sancion nuevaSancion=new Sancion("lau_aguirre@hotmail.com","La chica de nieve");
		sanciones.anyadirSancion(nuevaSancion);
		
		ArrayList<Sancion> resultado=sanciones.getMis_sanciones();
		
		int i=0;
		boolean encontrado=true;
		int maximo=0;
		
		if(esperado.size()>resultado.size()) 
		{
			maximo=esperado.size();
		}
		
		else 
		{
			maximo=resultado.size();
			System.out.println("Se ha añadido la sancion");
		}
		
		while(i<maximo) 
		{
			try
			{
				if(!esperado.get(i).toString().equals(resultado.get(i).toString())) 
				{
					encontrado=false;
				}
			}
			catch(IndexOutOfBoundsException e) 
			{
				System.out.println("Una de las lista tiene más elementos,no se ha añadido una la sancion");
				encontrado=false;
			}

			i++;
		}
		assertTrue(encontrado);
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
