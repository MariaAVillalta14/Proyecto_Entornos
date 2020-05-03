package Dominio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import Dominio.Libro.Formato;

public class LibroTest {
	
	static Libro mi_libro1;
	static Libro mi_libro2;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Metodo beforeClass");
		mi_libro1 = new Libro("Lugares asombrosos", 2019, "Luis Villar", "ALFAGUARA JUVENIL", true, Formato.FISICO, "La curiosidad es el motor de las aventuras que lo lanzan hasta los terrenos más inhospitos y misteriosos.");
		mi_libro2 = new Libro("Don Quijote de la Mancha", 1615, "Miguel de Cervantes", "Francisco de Robles", false, Formato.DIGITAL, "Es la primera obra genuinamente desmitificadora de la tradición caballeresca y cortés por su tratamiento burlesco.");
	}
	
	//Método -->  getTitulo
	@Test 
	public void test1() {
		System.out.println("Este metodo te devuelve el titulo del libro: Lugares asombrosos");
		String esperado = "Lugares asombrosos";
		String resultado = mi_libro1.getTitulo();
		assertEquals(esperado,resultado);
	}
	
	// Método -->  getAnyo_publicacion
	@Test 
	public void test2() {
		System.out.println("Este metodo te devuelve el año de publicación: 2019");
		int esperado = 2019;
		int resultado = mi_libro1.getAnyo_publicacion();
		assertEquals(esperado,resultado);
	}
	
	// Método -->  getAutor
	@Test 
	public void test3() {
		System.out.println("Este metodo te devuelve el nombre del autor: Luis Villar");
		String esperado = "Luis Villar";
		String resultado = mi_libro1.getAutor();
		assertEquals(esperado,resultado);
	}
	
	// Método -->  getEditorial
	@Test 
	public void test4() {
		System.out.println("Este metodo te devuelve el nombre de la editorial: ALFAGUARA JUVENIL");
		String esperado = "ALFAGUARA JUVENIL";
		String resultado = mi_libro1.getEditorial();
		assertEquals(esperado,resultado);
	}
	
	//Método -->  getDisponibilidad
	@Test 
	public void test5() {
		System.out.println("Este metodo te devuelve la disponibilidad del libro: Disponible");
		String esperado = "Disponible";
		String resultado = mi_libro1.getDisponibilidad();
		assertEquals(esperado,resultado);
	}
	
	@Test 
	public void test6() {
		System.out.println("Este metodo te devuelve la disponibilidad del libro: No disponible");
		String esperado = "No disponible";
		String resultado = mi_libro2.getDisponibilidad();
		assertEquals(esperado,resultado);
	}
	
	//Método -->  getFormato
	@Test 
	public void test7() {
		System.out.println("Este metodo te devuelve el Formato en que se encuentra el libro: Formato.FISICO");
		Formato esperado = Formato.FISICO;
		Formato resultado = mi_libro1.getFormato();
		assertEquals(esperado,resultado);
	}
	
	@Test 
	public void test8() {
		System.out.println("Este metodo te devuelve el Formato en que se encuentra el libro: Formato.DIGITAL");
		Formato esperado = Formato.DIGITAL;
		Formato resultado = mi_libro2.getFormato();
		assertEquals(esperado,resultado);
	}
	
	// Método -->  getDescripcion
	@Test 
	public void test9() {
		System.out.println("Este metodo te devuelve el nombre del autor: La curiosidad es el motor de las aventuras que lo lanzan hasta los terrenos más inhospitos y misteriosos.");
		String esperado = "La curiosidad es el motor de las aventuras que lo lanzan hasta los terrenos más inhospitos y misteriosos.";
		String resultado = mi_libro1.getDescripcion();
		assertEquals(esperado,resultado);
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