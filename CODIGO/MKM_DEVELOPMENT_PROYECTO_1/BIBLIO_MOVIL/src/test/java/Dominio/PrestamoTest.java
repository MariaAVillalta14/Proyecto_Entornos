package Dominio;

import static org.junit.Assert.*;


import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dominio.Prestamo;

public class PrestamoTest {
	
	static Prestamo librosPrestados;
	static Prestamo librosPrestados2;
	static ArrayList<Prestamo> librosEnPrestamo;
	
	@BeforeClass
	public static void beforeClass() 
	{
	 	System.out.println("Estoy metodo beforeClass");
	 	librosPrestados=new Prestamo();
	 	librosEnPrestamo=new ArrayList<Prestamo>();
	 	librosEnPrestamo.add(new Prestamo(Prestamo.fecha_inicio(2020, Calendar.APRIL, 1),Prestamo.fecha_fin(2020,Calendar.APRIL,1),"villaltamaria@gmail.com","El Alquimista"));
		librosEnPrestamo.add(new Prestamo(Prestamo.fecha_inicio(2020, Calendar.APRIL, 2),Prestamo.fecha_fin(2020,Calendar.APRIL,2),"villaltamaria@gmail.com","Cien años de soledad"));
		librosEnPrestamo.add(new Prestamo(Prestamo.fecha_inicio(2020, Calendar.APRIL, 3),Prestamo.fecha_fin(2020,Calendar.APRIL,3),"zapatacamila@gmail.com","Cien años de soledad"));
		librosEnPrestamo.add(new Prestamo(Prestamo.fecha_inicio(2020, Calendar.JANUARY, 4),Prestamo.fecha_fin(2020,Calendar.JANUARY,4),"chaconkevim@gmail.com","La chica de nieve"));	
	 	librosEnPrestamo.add(new Prestamo(Prestamo.fecha_inicio(2020, Calendar.JANUARY, 4),Prestamo.fecha_fin(2020,Calendar.JANUARY,4),"anto123@gmail.com","El Alquimista"));
	 	librosPrestados2=new Prestamo();
	 	
	}

	@Before
	public void before() 
	{
		System.out.println("Estoy metodo before");
	}
			

	//Método --> anyadirPrestamo()
	
	@Test
	public void test1()
	{
		System.out.println("Estoy en método getSocio");	
		ArrayList<Prestamo> esperado=librosEnPrestamo;
			
		Prestamo nuevoPrestamo=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.JANUARY, 4),Prestamo.fecha_fin(2020,Calendar.JANUARY,4),"anto123@gmail.com","El Alquimista");
		librosPrestados.anyadirPrestamo(nuevoPrestamo);
		
		ArrayList<Prestamo> resultado=librosPrestados.getLibrosPrestados();
		
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
			System.out.println("Se ha añadido un prestamo");
		}
			
		while(i<maximo) 
		{
			try
			{
				if(!esperado.get(i).toString().equals(resultado.get(i).toString())) 
				{
					encontrado=false;
					System.out.println(esperado.get(i).toString());
					System.out.println(resultado.get(i).toString());
				}
				}
				catch(IndexOutOfBoundsException e) 
				{
					System.out.println("Una de las listas tiene más elementos, no ha añadido el Prestamo");
					encontrado=false;
				}

				i++;
			}
			assertTrue(encontrado);
			
		}	 	

	//Método --> tituloCoincide(String email,String titulo)
	@Test
	public void test2()
	{
		System.out.println("Estoy en metodo test tituloCoincide(String email,String titulo) cuando existen email y titulo");
		boolean esperado=true;
		boolean resultado=librosPrestados.tituloCoincide("villaltamaria@gmail.com", "Cien años de soledad");
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test3()
	{
		System.out.println("Estoy en metodo test tituloCoincide(String email,String titulo) cuando existen email pero NO titulo");
		boolean esperado=false;
		boolean resultado=librosPrestados.tituloCoincide("villaltamaria@gmail.com", "La chica de nieve");
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test4()
	{
		System.out.println("Estoy en metodo test tituloCoincide(String email,String titulo) cuando NO existe email y SI titulo");
		boolean esperado=false;
		boolean resultado=librosPrestados.tituloCoincide("estemailnoexiste@gmail.com", "La chica de nieve");
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test5()
	{
		System.out.println("Estoy en metodo test tituloCoincide(String email,String titulo) cuando existe email y NO titulo");
		boolean esperado=false;
		boolean resultado=librosPrestados.tituloCoincide("villaltamaria14@gmail.com", "Este libro no esta en prestamo");
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test6()
	{
		System.out.println("Estoy en metodo test tituloCoincide(String email,String titulo) cuando NO existen email ni titulo");
		boolean esperado=false;
		boolean resultado=librosPrestados.tituloCoincide("estemailnoexiste@gmail.com", "Este libro no esta en prestamo");
		assertEquals(esperado,resultado);
	}
	
	//Método --> obtenerFechaPrestamo(String emailSocio,String titulo)
	
	@Test
	public void test7()
	{
		System.out.println("Estoy en metodo test obtenerFechaPrestamo(String emailSocio,String titulo) cuando existe email y titulo");
		
		Calendar esperado=(Prestamo.fecha_fin(2020,Calendar.APRIL,2));
		Calendar resultado=librosPrestados.obtenerFechaPrestamo("villaltamaria@gmail.com", "Cien años de soledad");
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test8()
	{
		System.out.println("Estoy en metodo test obtenerFechaPrestamo(String emailSocio,String titulo) cuando NO coincide email y ni titulo");
		
		Calendar esperado=Calendar.getInstance();
		Calendar resultado=librosPrestados.obtenerFechaPrestamo("estemailnoexiste@gmail.com.", "Cien años de soledad");
		
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test9()
	{
		System.out.println("Estoy en metodo test obtenerFechaPrestamo(String emailSocio,String titulo) cuando SI coincide email y NO titulo");
		
		Calendar esperado=Calendar.getInstance();
		Calendar resultado=librosPrestados.obtenerFechaPrestamo("villaltamaria@gmail.com", "La chica de nieve");
		
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void test10()
	{
		System.out.println("Estoy en metodo test obtenerFechaPrestamo(String emailSocio,String titulo) cuando NO coincide email NI titulo");
		
		Calendar esperado=Calendar.getInstance();
		Calendar resultado=librosPrestados.obtenerFechaPrestamo("villaltamaria@gmail.com", "La chica de nieve");
		
		assertEquals(esperado,resultado);
	}
	
	//Método --> devolverLibro(String emailSocio,String titulo)
	@Test
	public void test11()
	{
		System.out.println("Estoy en método devolverLibro(String emailSocio,String titulo) cuando el email y el titulo existen");	
		ArrayList<Prestamo> esperado=librosEnPrestamo;
			
		Prestamo nuevoPrestamo=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.JANUARY, 4),Prestamo.fecha_fin(2020,Calendar.JANUARY,4),"anto123@gmail.com","El Alquimista");
		Prestamo nuevoPrestamoParaDevolver=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.JANUARY, 4),Prestamo.fecha_fin(2020,Calendar.JANUARY,4),"jonh612@outlook.com","El Alquimista");
		librosPrestados2.anyadirPrestamo(nuevoPrestamo);
		librosPrestados2.anyadirPrestamo(nuevoPrestamoParaDevolver);
		librosPrestados2.devolverLibro("jonh612@outlook.com","El Alquimista");
		
		ArrayList<Prestamo> resultado=librosPrestados2.getLibrosPrestados();
		
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
			System.out.println("Se ha añadido un prestamo");
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
					System.out.println("Una de las listas tiene más elementos, no ha añadido el Prestamo");
					encontrado=false;
				}

				i++;
			}
			assertTrue(encontrado);
	}
	
	@Test
	public void test12()
	{
		System.out.println("Estoy en método devolverLibro(String emailSocio,String titulo) cuando el email no existe y el titulo si");	
		ArrayList<Prestamo> esperado=librosEnPrestamo;
			
		Prestamo nuevoPrestamo=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.JANUARY, 4),Prestamo.fecha_fin(2020,Calendar.JANUARY,4),"anto123@gmail.com","El Alquimista");
		Prestamo nuevoPrestamoParaDevolver=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.JANUARY, 4),Prestamo.fecha_fin(2020,Calendar.JANUARY,4),"jonh612@outlook.com","El Alquimista");
		librosPrestados2.anyadirPrestamo(nuevoPrestamo);
		librosPrestados2.anyadirPrestamo(nuevoPrestamoParaDevolver);
		librosPrestados2.devolverLibro("estemailnoexiste@gmail.com","El Alquimista");
		
		ArrayList<Prestamo> resultado=librosPrestados2.getLibrosPrestados();
		
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
			System.out.println("Se ha añadido un prestamo");
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
					System.out.println("Una de las listas tiene más elementos, no ha añadido el Prestamo");
					encontrado=false;
				}

				i++;
			}
			assertFalse(encontrado);
	}
	
	@Test
	public void test13()
	{
		System.out.println("Estoy en método devolverLibro(String emailSocio,String titulo) cuando ni el email ni el titulo existen");	
		ArrayList<Prestamo> esperado=librosEnPrestamo;
			
		Prestamo nuevoPrestamo=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.JANUARY, 4),Prestamo.fecha_fin(2020,Calendar.JANUARY,4),"anto123@gmail.com","El Alquimista");
		Prestamo nuevoPrestamoParaDevolver=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.JANUARY, 4),Prestamo.fecha_fin(2020,Calendar.JANUARY,4),"jonh612@outlook.com","El Alquimista");
		librosPrestados2.anyadirPrestamo(nuevoPrestamo);
		librosPrestados2.anyadirPrestamo(nuevoPrestamoParaDevolver);
		librosPrestados2.devolverLibro("estemailnoexiste@gmail.com","La chica de nieve");
		
		ArrayList<Prestamo> resultado=librosPrestados2.getLibrosPrestados();
		
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
			System.out.println("Se ha añadido un prestamo");
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
					System.out.println("Una de las listas tiene más elementos, no ha añadido el Prestamo");
					encontrado=false;
				}

				i++;
			}
			assertFalse(encontrado);
	}
	
	@Test
	public void test14()
	{
		System.out.println("Estoy en método devolverLibro(String emailSocio,String titulo) cuando el email existe y el titulo no existe");	
		ArrayList<Prestamo> esperado=librosEnPrestamo;
			
		Prestamo nuevoPrestamo=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.JANUARY, 4),Prestamo.fecha_fin(2020,Calendar.JANUARY,4),"anto123@gmail.com","El Alquimista");
		Prestamo nuevoPrestamoParaDevolver=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.JANUARY, 4),Prestamo.fecha_fin(2020,Calendar.JANUARY,4),"jonh612@outlook.com","El Alquimista");
		librosPrestados2.anyadirPrestamo(nuevoPrestamo);
		librosPrestados2.anyadirPrestamo(nuevoPrestamoParaDevolver);
		librosPrestados2.devolverLibro("jonh612@outlook.com","La chica de nieve");
		
		ArrayList<Prestamo> resultado=librosPrestados2.getLibrosPrestados();
		
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
			System.out.println("Se ha añadido un prestamo");
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
					System.out.println("Una de las listas tiene más elementos, no ha añadido el Prestamo");
					encontrado=false;
				}

				i++;
			}
			assertFalse(encontrado);
	}
	
	// Método --> setTituloLibroPrestamo() y getTituloLibroPrestamo()
	@Test
	public void test15()
	{
		System.out.println("Estoy en metodo test setTituloLibroPrestamo() y  getTituloLibroPrestamo() ");
		Prestamo prestamo=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.APRIL, 1),Prestamo.fecha_fin(2020,Calendar.APRIL,1),"villaltamaria@gmail.com","Lugares asombrosos");
		prestamo.setTituloLibroPrestamo("El Señor de los Anillos");
		String esperado="El Señor de los Anillos";
		String resultado=prestamo.getTituloLibroPrestamo();
		assertEquals(esperado,resultado);
	}
	
	// Método -->setEmailSocio(String emailSocio) y getEmailSocio()
	@Test
	public void test16()
		{
			System.out.println("Estoy en metodo test setEmailSocio(String emailSocio) y getEmailSocio()");
			Prestamo prestamo=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.APRIL, 1),Prestamo.fecha_fin(2020,Calendar.APRIL,1),"villaltamaria@gmail.com","Lugares asombrosos");
			prestamo.setEmailSocio("maria@gmail.com");
			String esperado="maria@gmail.com";
			String resultado=prestamo.getEmailSocio();
			assertEquals(esperado,resultado);
		}
	
		
	// Método --> setLibrosPrestados() y getLibrosPrestados() 
	@Test
	public void test17()
	{
		System.out.println("Estoy en metodo test setLibrosPrestados() y getLibrosPrestados()");
		ArrayList<Prestamo> esperado=librosEnPrestamo;
		librosPrestados.setLibrosPrestados(librosEnPrestamo);
		ArrayList<Prestamo> resultado=librosPrestados.getLibrosPrestados();
		assertEquals(esperado,resultado);
	}
	
	// Método --> getFecha_inicio1() 
	@Test
	public void test18()
	{
		System.out.println("Estoy en metodo test getFecha_inicio1()");
		Prestamo prestamo=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.APRIL, 1),Prestamo.fecha_fin(2020,Calendar.APRIL,1),"villaltamaria@gmail.com","Lugares asombrosos");
		String resultado=prestamo.getFecha_inicio1();
		String esperado="1/4/2020";
		assertEquals(esperado,resultado);
	}
	
	// Método --> getFecha_fin1()
	@Test
	public void test19()
	{
		System.out.println("Estoy en metodo test getFecha_fin1()");
		Prestamo prestamo=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.APRIL, 1),Prestamo.fecha_fin(2020,Calendar.APRIL,1),"villaltamaria@gmail.com","Lugares asombrosos");
		String resultado=prestamo.getFecha_fin1();
		String esperado="1/5/2020";
		assertEquals(esperado,resultado);
	}
	
	
	// Método -->setFecha_inicio() y getFecha_inicio()
	@Test
	public void test20()
	{
		System.out.println("Estoy en metodo test getFecha_inicio()");
		Prestamo prestamo=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.APRIL, 1),Prestamo.fecha_fin(2020,Calendar.APRIL,1),"villaltamaria@gmail.com","Lugares asombrosos");
		prestamo.setFecha_inicio(2020, Calendar.AUGUST, 14);
		Calendar resultado=prestamo.getFecha_inicio();
		Calendar esperado=Calendar.getInstance();
		esperado.set(2020, Calendar.AUGUST, 14);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);
		assertEquals(esperado,resultado);
	}
	
	// Método --> getFecha_fin()
	
	@Test
	public void test21()
	{
		System.out.println("Estoy en metodo test getFecha_fin()");
		Prestamo prestamo=new Prestamo(Prestamo.fecha_inicio(2020, Calendar.APRIL, 1),Prestamo.fecha_fin(2020,Calendar.APRIL,1),"villaltamaria@gmail.com","Lugares asombrosos");
		prestamo.setFecha_fin(2020, Calendar.AUGUST, 14);
		Calendar resultado=prestamo.getFecha_fin();
		Calendar esperado=Calendar.getInstance();
		esperado.set(2020, Calendar.SEPTEMBER, 13);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);
		assertEquals(esperado,resultado);
	}
	
	//Método--> fecha inicio
	
	@Test
	public void test22()
	{
		System.out.println("Estoy en metodo test fecha_inicio ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2020, Calendar.JANUARY, 1);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);

		Calendar resultado=Prestamo.fecha_inicio(2020, Calendar.JANUARY, 1);
		System.out.println(esperado1);
		System.out.println(resultado);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test23()
	{
		System.out.println("Estoy en metodo test fecha_inicio ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2021, Calendar.JANUARY, 1);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);

		Calendar resultado=Prestamo.fecha_inicio(2021, Calendar.JANUARY, 1);
		System.out.println(esperado1);
		System.out.println(resultado);
		assertEquals(esperado1,resultado);
	}

	
	@Test
	public void test24()
	{
		System.out.println("Estoy en metodo test fecha_inicio 28 de febrero año bisiesto");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2020, Calendar.FEBRUARY, 28);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2020, Calendar.FEBRUARY, 28);
		System.out.println(esperado1);
		System.out.println(resultado);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test25()
	{
		System.out.println("Estoy en metodo test fecha_inicio 28 de febrero año NO bisiesto");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2021, Calendar.FEBRUARY, 28);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2021, Calendar.FEBRUARY, 28);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test26()
	{
		System.out.println("Estoy en metodo test fecha_inicio, 29 de febrero año  bisiesto ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2021, Calendar.MARCH, 1);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2021, Calendar.FEBRUARY, 29);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test27()
	{
		System.out.println("Estoy en metodo test fecha_inicio, 29 de febrero año NO bisiesto ");
		Calendar esperado=Calendar.getInstance();
		// En año bisiesto, se salta al dia proximo, es decir 1ero de marzo
		esperado.set(2021, Calendar.MARCH, 1);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2021, Calendar.FEBRUARY, 29);		
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test28()
	{
		System.out.println("Estoy en metodo test fecha_inicio, 31 de abril, dia  no existente año  bisiesto ");
		Calendar esperado=Calendar.getInstance();
		// En año bisiesto, se salta al dia proximo, es decir 1ero de marzo
		esperado.set(2020, Calendar.MAY, 1);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2020, Calendar.APRIL, 31);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test29()
	{
		System.out.println("Estoy en metodo test fecha_inicio, 31 de abril, dia  no existente año NO  bisiesto ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2021, Calendar.MAY, 1);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2021, Calendar.APRIL, 31);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test30()
	{
		System.out.println("Estoy en metodo test fecha_inicio, 30 de abril, año NO bisiesto ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2021, Calendar.APRIL, 30);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2021, Calendar.APRIL, 30);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test31()
	{
		System.out.println("Estoy en metodo test fecha_inicio, 30 de abril, año  bisiesto ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2020, Calendar.APRIL, 30);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2020, Calendar.APRIL, 30);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test32()
	{
		System.out.println("Estoy en metodo test fecha_inicio, 31 de febrero, dia  no existente año bisiesto ");
		Calendar esperado=Calendar.getInstance();
		//Febrero en este año tiene 29 dias, por lo que al tener 2 dias más, los lleva al mes siguientes
		//Es decir, marzo 2.
		esperado.set(2020, Calendar.MARCH, 2);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2020, Calendar.FEBRUARY, 31);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test33()
	{
		System.out.println("Estoy en metodo test fecha_inicio, 31 de febrero, dia  no existente año NO bisiesto ");
		Calendar esperado=Calendar.getInstance();
		//Febrero en este año tiene 28 dias, por lo que al tener 3 dias más, los lleva al mes siguientes
	   //Es decir, marzo 3.
		esperado.set(2021, Calendar.MARCH, 3);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2021, Calendar.FEBRUARY, 31);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test34()
	{
		System.out.println("Estoy en metodo test fecha_inicio, 31 de diciembre, año  bisiesto ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2020, Calendar.DECEMBER, 31);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2020, Calendar.DECEMBER, 31);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test35()
	{
		System.out.println("Estoy en metodo test fecha_inicio,30 de febrero, dia no existente año NO bisiesto ");
		Calendar esperado=Calendar.getInstance();
		// En año bisiesto, se salta al dia proximo, es decir 1ero de marzo
		esperado.set(2020, Calendar.MARCH, 1);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2020, Calendar.FEBRUARY, 30);
		System.out.println(esperado1.toString());
		System.out.println(resultado.toString());
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test36()
	{
		System.out.println("Estoy en metodo test fecha_inicio,año NO bisiesto ");
		Calendar esperado=Calendar.getInstance();
		// En año no bisiesto, febrero tiene 28 dias, los dos dias sobrantes, se pasan al mes de marzo, siendo 2 de marzo
		esperado.set(2021,  Calendar.MARCH, 2);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_inicio(2021,  Calendar.FEBRUARY, 30);
		System.out.println(esperado1.toString());
		System.out.println(resultado.toString());
		assertEquals(esperado1,resultado);
	}
	
	//Método--> fecha_fin
	@Test
	public void test37()
	{
		System.out.println("Estoy en metodo test fecha_fin ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2020, Calendar.JANUARY, 31);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);

		Calendar resultado=Prestamo.fecha_fin(2020, Calendar.JANUARY, 1);
		System.out.println(esperado1);
		System.out.println(resultado);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test38()
	{
		System.out.println("Estoy en metodo test fecha_fin ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2021, Calendar.JANUARY, 31);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);

		Calendar resultado=Prestamo.fecha_fin(2021, Calendar.JANUARY, 1);
		System.out.println(esperado1);
		System.out.println(resultado);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test39()
	{
		System.out.println("Estoy en metodo test fecha_fin 28 de febrero año bisiesto");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2020, Calendar.MARCH, 29);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);

		Calendar resultado=Prestamo.fecha_fin(2020, Calendar.FEBRUARY, 28);
		System.out.println(esperado1);
		System.out.println(resultado);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test40()
	{
		System.out.println("Estoy en metodo test fecha_fin 28 de febrero año NO bisiesto");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2021, Calendar.MARCH, 30);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2021, Calendar.FEBRUARY, 28);
		assertEquals(esperado1,resultado);
	}
	

	@Test
	public void test41()
	{
		System.out.println("Estoy en metodo test fecha_fin, 29 de febrero año  bisiesto ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2021, Calendar.MARCH, 31);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2021, Calendar.FEBRUARY, 29);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test42()
	{
		System.out.println("Estoy en metodo test fecha_fin, 29 de febrero año NO bisiesto ");
		Calendar esperado=Calendar.getInstance();
		// En año bisiesto, se salta al dia proximo más los 30 dias, es decir 31 de marzo
		esperado.set(2021, Calendar.MARCH, 31);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2021, Calendar.FEBRUARY, 29);		
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test43()
	{
		System.out.println("Estoy en metodo test fecha_fin, 31 de abril, dia  no existente año  bisiesto ");
		Calendar esperado=Calendar.getInstance();
		// En año bisiesto, se salta al dia proximo, es decir 1ero de marzo
		esperado.set(2020, Calendar.MAY, 31);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2020, Calendar.APRIL, 31);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test44()
	{
		System.out.println("Estoy en metodo test fecha_fin, 31 de abril, dia  no existente año NO  bisiesto ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2021, Calendar.MAY, 31);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2021, Calendar.APRIL, 31);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test45()
	{
		System.out.println("Estoy en metodo test fecha_fin, 30 de abril, año NO bisiesto ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2021, Calendar.MAY, 30);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2021, Calendar.APRIL, 30);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test46()
	{
		System.out.println("Estoy en metodo test fecha_fin, 30 de abril, año  bisiesto ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2020, Calendar.MAY, 30);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2020, Calendar.APRIL, 30);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test47()
	{
		System.out.println("Estoy en metodo test fecha_fin, 31 de febrero, dia  no existente año bisiesto ");
		Calendar esperado=Calendar.getInstance();
		//Febrero en este año tiene 29 dias, por lo que al tener 2 dias más, los lleva al mes siguientes
		//Es decir, marzo 2, mas los 30 dias.
		esperado.set(2020, Calendar.APRIL, 1);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2020, Calendar.FEBRUARY, 31);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test48()
	{
		System.out.println("Estoy en metodo test fecha_fin, 31 de febrero, dia  no existente año NO bisiesto ");
		Calendar esperado=Calendar.getInstance();
		//Febrero en este año tiene 28 dias, por lo que al tener 3 dias más, los lleva al mes siguientes
	   //Es decir, marzo 3, mas los 30
		esperado.set(2021, Calendar.APRIL, 2);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2021, Calendar.FEBRUARY, 31);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test49()
	{
		System.out.println("Estoy en metodo test fecha_fin, 31 de diciembre, año  bisiesto ");
		Calendar esperado=Calendar.getInstance();
		esperado.set(2021, Calendar.JANUARY, 30);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2020, Calendar.DECEMBER, 31);
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test50()
	{
		System.out.println("Estoy en metodo test fecha_fin,30 de febrero, dia no existente año NO bisiesto ");
		Calendar esperado=Calendar.getInstance();
		// En año bisiesto, se salta al dia proximo, es decir 1ero de marzo, mas los 30
		esperado.set(2020, Calendar.MARCH, 31);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2020, Calendar.FEBRUARY, 30);
		System.out.println(esperado1.toString());
		System.out.println(resultado.toString());
		assertEquals(esperado1,resultado);
	}
	
	@Test
	public void test51()
	{
		System.out.println("Estoy en metodo test fecha_fin,30 de febrero,dia no existente año NO bisiesto ");
		Calendar esperado=Calendar.getInstance();
		// En año no bisiesto, febrero tiene 28 dias, los dos dias sobrantes, se pasan al mes de marzo, siendo 2 de marzo, mas los 30
		esperado.set(2021,  Calendar.APRIL, 1);
		esperado.set(Calendar.MILLISECOND,0);
		esperado.set(Calendar.SECOND, 0);	
 		Date fecha=esperado.getTime();
 		Calendar esperado1=Calendar.getInstance();
 		esperado1.setTime(fecha);
		Calendar resultado=Prestamo.fecha_fin(2021,  Calendar.FEBRUARY, 30);
		System.out.println(esperado1.toString());
		System.out.println(resultado.toString());
		assertEquals(esperado1,resultado);
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


