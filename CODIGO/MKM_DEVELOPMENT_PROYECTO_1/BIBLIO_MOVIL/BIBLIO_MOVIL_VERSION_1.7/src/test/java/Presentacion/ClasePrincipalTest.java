package Presentacion;

import static org.junit.Assert.*;

import org.junit.*;



public class ClasePrincipalTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Metodo beforeClass");
		
	}
	
	//Método --> formatoFechaCorrecto(String fecha)
	@Test 
	public void test1() {
		System.out.println("Estoy en método formatoFechaCorrecto(String fecha)");
		boolean esperado=true;
		boolean resultado=ClasePrincipal.formatoFechaCorrecto("14-08-1998");
		assertEquals(esperado,resultado);
	}
	
	@Test 
	public void test2() {
		System.out.println("Estoy en método formatoFechaCorrecto(String fecha)");
		boolean esperado=false;
		boolean resultado=ClasePrincipal.formatoFechaCorrecto("no-es-una-fecha");
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
