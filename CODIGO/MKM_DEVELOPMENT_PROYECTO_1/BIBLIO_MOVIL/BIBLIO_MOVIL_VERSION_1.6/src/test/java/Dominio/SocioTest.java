package Dominio;

import static org.junit.Assert.*;

import org.junit.*;



public class SocioTest {
	
	static Socio mi_socio; 
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Metodo beforeClass");
		mi_socio = new Socio("Antonella", "Gutierrez","12-12-1999", "anto123@gmail.com", "anto123");
	}
	
	//getNombre
	@Test 
	public void test1() {
		System.out.println("Este metodo te devuelve el nombre del socio: Antonella");
		String esperado = "Antonella";
		String resultado = mi_socio.getNombre();
		assertEquals(esperado,resultado);
	}
	
	// Método -->  getApellidos
	@Test 
	public void test2() {
		System.out.println("Este metodo te devuelve el apellido del socio: Gutierrez");
		String esperado = "Gutierrez";
		String resultado = mi_socio.getApellidos();
		assertEquals(esperado,resultado);
	}
	
	//Método -->  getFecha_nacimiento
	@Test 
	public void test3() {
		System.out.println("Este metodo te devuelve la fecha de nacimiento: 12-12-1999");
		String esperado = "12-12-1999";
		String resultado = mi_socio.getFecha_nacimiento();
		assertEquals(esperado,resultado);
	}
	
	//Método -->  getEmail
	@Test 
	public void test4() {
		System.out.println("Este metodo te devuelve el email: anto123@gmail.com");
		String esperado = "anto123@gmail.com";
		String resultado = mi_socio.getEmail();
		assertEquals(esperado,resultado);
	}
	
	//Método -->  getContrasenya
	@Test 
	public void test5() {
		System.out.println("Este metodo te devuelve la contraseña: anto123");
		String esperado = "anto123";
		String resultado = mi_socio.getContrasenya();
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