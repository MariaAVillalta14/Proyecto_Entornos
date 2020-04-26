package Dominio;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import Dominio.BiblioMovil;
import Dominio.Socio;
import Dominio.Libro.Formato;

public class BiblioMovilTest {
	
	static BiblioMovil miBiblio;
	static ArrayList<Socio> listaSocios;
	
	@BeforeClass
 	public static void beforeClass() 
	{
 		System.out.println("Estoy metodo beforeClass");
 		miBiblio=new BiblioMovil();
 		listaSocios=new ArrayList<Socio>();
 		listaSocios.add(new Socio("Maria","Villalta","14-08-1998","villaltamaria@gmail.com","123456"));
 		listaSocios.add(new Socio("Camila","Zapata","06-12-2001","zapatacamila@gmail.com","123456"));
		listaSocios.add(new Socio("Kevim","Chacón","17-09-1993","chaconkevim@gmail.com","123456"));
		listaSocios.add(new Socio("Laura", "Aguirre", "17-11-2000", "lau_aguirre@hotmail.com", "654321"));
		listaSocios.add(new Socio("Antonella", "Gutierrez","12-12-1999", "anto123@gmail.com", "anto123"));
		listaSocios.add(new Socio("Jonh", "Lopez", "30-02-1980", "jonh612@outlook.com", "J763746824"));
 		listaSocios.add(new Socio("Juan","González","14-07-1996","juang@gmail.com","123456"));
	}

	@Before
	public void before() 
	{
	 	System.out.println("Estoy metodo before");
	}
		
	
	// Método --> descripcionLibro(String titulo)
	
	@Test
	public void test1() 
	{
		System.out.println("Estoy en metodo test descripcionLibros() cuando existe libro Cien años de soledad  ");
		String esperado="***DESCRIPCIÓN***\n"+ " Es considerada una obra maestra de la literatura hispanoamericana y universal, así como una de las obras más traducidas y leidas en español";
		String resultado=miBiblio.descripcionLibro("Cien años de soledad");	
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test2() 
	{
		System.out.println("Estoy en metodo test descripcionLibros() cuando no existe el libro introducido");
		String esperado="***DESCRIPCIÓN***\n"+null;
		String resultado=miBiblio.descripcionLibro("Mi Libro Inventado");	
		assertEquals(esperado,resultado);
	}
	
	//Método --> registrarSocio(Socio misocio)
	
	@Test
	public void test3()
	{
		System.out.println("Estoy en método getSocio");	
		ArrayList<Socio> esperado=listaSocios;
		
		Socio nuevoSocio=new Socio("Juan","González","14-07-1996","juang@gmail.com","123456");
		miBiblio.registrarSocio(nuevoSocio);
		
		ArrayList<Socio> resultado=miBiblio.getSocios();
		
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
			System.out.println("Se ha añadido usuario");
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
				System.out.println("Una de las lista tiene más elementos,no se ha añadido el nuevo socio");
				encontrado=false;
			}

			i++;
		}
		assertTrue(encontrado);
		
	}
	
	
	//Método --> Comprobar_email(String email)
	
	@Test
	public void test4()
	{
		System.out.println("Estoy en el método Comprobar_email(String email) email coincide");
		String esperado="villaltamaria@gmail.com";
		String resultado=miBiblio.Comprobar_email("villaltamaria@gmail.com");
		assertEquals(esperado,resultado);
	}
	@Test
	public void test5()
	{
		System.out.println("Estoy en el método Comprobar_email(String email) email  NO coincide");
		String esperado=" ";
		String resultado=miBiblio.Comprobar_email("noexiste@gmail.com");
		assertEquals(esperado,resultado);
	}
	
	//Método --> Comprobar_contrasenya(String contrasenya)
	
	@Test
	public void test6()
	{
		System.out.println("Estoy en el método Comprobar_contrasenya(Strin contraneya) contraseña SI coincide");
		String esperado="123456";
		String resultado = null;
		if(miBiblio.Comprobar_email("villaltamaria@gmail.com").equalsIgnoreCase("villaltamaria@gmail.com"))
		{
			resultado=miBiblio.Comprobar_contrasenya("123456");
		}	
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test7()
	{
		System.out.println("Estoy en el método Comprobar_contrasenya(Strin contraneya) contraseña NO coincide");
		String esperado=" ";
		String resultado = null;
		if(miBiblio.Comprobar_email("villaltamaria@gmail.com").equalsIgnoreCase("villaltamaria@gmail.com"))
		{
			resultado=miBiblio.Comprobar_contrasenya("incorrecto");
		}	
		assertEquals(esperado,resultado);
	}
	
	//Método --> tituloLibro(String nombre)
	
	@Test
	public void test8()
	{
		System.out.println("Estoy en el método tituloLibro(String nombre) libro SI existe en la biblioteca");
		String esperado="Cien años de soledad";
		String resultado=miBiblio.tituloLibro("Cien años de soledad");
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test9()
	{
		System.out.println("Estoy en el método tituloLibro(String nombre) libro NO existe en la biblioteca");
		String esperado="";
		String resultado=miBiblio.tituloLibro("Este Libro No Existe");
		assertEquals(esperado,resultado);
	}
	
	//Método --> getDisponibilidad(String titulo)
	
	@Test
	public void test10()
	{
		System.out.println("Estoy en el método getDisponibilidad(String titulo) disponible");
		String esperado="Disponible";
		String resultado=miBiblio.getDisponibilidad("Cien años de soledad");
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test11()
	{
		System.out.println("Estoy en el método getDisponibilidad(String titulo) NO disponible");
		String esperado="No disponible";
		String resultado=miBiblio.getDisponibilidad("La chica de nieve");
		assertEquals(esperado,resultado);
	}
	
	//Método --> Libro(String titulo)
	
	@Test
	public void test12()
	{
		System.out.println("Estoy en el método Libro(String titulo) objeto Libro SI existe");
		Libro esperado=new Libro("Don Quijote de la Mancha", 1615, "Miguel de Cervantes", "Francisco de Robles", false, Formato.DIGITAL, "Es la primera obra genuinamente desmitificadora de la tradición caballeresca y cortés por su tratamiento burlesco.");
		Libro resultado=miBiblio.Libro("Don Quijote de la Mancha");
		boolean verdadero=false;
		if(esperado.toString().equals(resultado.toString()))
		{
			verdadero=true;
		}
		assertTrue(verdadero);
		
	}
	
	@Test
	public void test13()
	{
		System.out.println("Estoy en el método Libro(String titulo) objeto Libro NO existe");
		Libro esperado=null;
		Libro resultado=miBiblio.Libro("Matemáticas 4");
		assertSame(esperado,resultado);
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