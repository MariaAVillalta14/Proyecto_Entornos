package main.java.Dominio;
import java.util.*;

public class Socio extends Usuario {
	
	static BiblioMovil mi_socio = new BiblioMovil();
	static Scanner entrada = new Scanner(System.in);
	
	private String nombre;
	private String apellidos;
	private String fecha_nacimiento;
	private String email;
	private String contrasenya;
	
	
	public Socio(String nombre, String apellidos, String fecha_nacimiento, String email,String contrasenya) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.email = email;
		this.contrasenya=contrasenya;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	
	
	
}
