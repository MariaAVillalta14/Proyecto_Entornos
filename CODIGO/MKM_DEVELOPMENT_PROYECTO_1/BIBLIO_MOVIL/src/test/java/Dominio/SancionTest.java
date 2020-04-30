package Dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dominio.Libro.Formato;

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
	 	
	// Metodo --> comprobarSancion(String email)
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
	
	//Método anyadirSancion(Sancion misancion) y getSocio
	
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
	
	//Métodos--> getNumero_dias_sancion()
	
	@Test
	public void test6()
	{
		System.out.println("Estoy en método getNumero_dias_sancion()");	
		Sancion nuevaSancion=new Sancion("lau_aguirre@hotmail.com","La chica de nieve");
		int esperado=10;
		int resultado=nuevaSancion.getNumero_dias_sancion();
		assertEquals(esperado,resultado);
	}
	
	//Métodos--> getEmailSocio() 
	
	@Test
	public void test7()
	{
		System.out.println("Estoy en método getEmailSocio() ");	
		Sancion nuevaSancion=new Sancion("lau_aguirre@hotmail.com","La chica de nieve");
		String esperado="lau_aguirre@hotmail.com";
		String resultado=nuevaSancion.getEmailSocio();
		assertEquals(esperado,resultado);
	}
	//Métodos--> getTitulo_libro_prestamo() 
	@Test
	public void test8()
	{
		System.out.println("Estoy en método getTitulo_libro_prestamo() ");	
		Sancion nuevaSancion=new Sancion("lau_aguirre@hotmail.com","La chica de nieve");
		String esperado="La chica de nieve";
		String resultado=nuevaSancion.getTitulo_libro_prestamo();
		assertEquals(esperado,resultado);
	}
	
	//Métodos--> getMis_sanciones()
	@Test
	public void test9()
	{
		System.out.println("Estoy en método getMis_sanciones()");	
		ArrayList<Sancion> esperado=listaSancion;
		Sancion resultado=new Sancion();
		resultado.anyadirSancion(new Sancion("lau_aguirre@hotmail.com","La chica de nieve"));
		ArrayList<Sancion> resultado1=resultado.getMis_sanciones();
		assertEquals(esperado.toString(),resultado1.toString());
		
	
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
