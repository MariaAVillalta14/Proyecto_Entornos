package Dominio;

import java.util.*;

public class Sancion {

	private int Numero_dias_sancion;
	private String emailSocio;
	private String titulo_libro_prestamo;
	ArrayList <Sancion> mis_sanciones;

	public Sancion(String emailSocio,String titulo_libro_prestamo) 
	{
		this.Numero_dias_sancion = 10;
		this.emailSocio = emailSocio;
		this.titulo_libro_prestamo = titulo_libro_prestamo;
	}
	
	public Sancion()
	{
		this.mis_sanciones = new ArrayList<Sancion>();
		mis_sanciones.add(new Sancion("zapatacamila@gmail.com","Cien años de soledad"));
	}
	
	

	public int getNumero_dias_sancion() {
		return Numero_dias_sancion;
	}

	public void setNumero_dias_sancion(int numero_dias_sancion) {
		Numero_dias_sancion = numero_dias_sancion;
	}
	
	public int setFecha(Calendar fechaFinPrestamo, int dia)
	{
		Calendar fechaActual = Calendar.getInstance();
		fechaActual.add(Calendar.DAY_OF_MONTH, dia);
		return Numero_dias_sancion;
	}
		
	public String getEmailSocio() {
		return emailSocio;
	}

	public void setEmailSocio(String emailSocio) {
		this.emailSocio = emailSocio;
	}

	public String getTitulo_libro_prestamo() {
		return titulo_libro_prestamo;
	}

	public void setTitulo_libro_prestamo(String titulo_libro_prestamo) {
		this.titulo_libro_prestamo = titulo_libro_prestamo;
	}

	public void anyadirSancion(Sancion misancion)
	{	
		mis_sanciones.add(misancion);
	}

	public Sancion miSancion()
	{ 
		Sancion sancion = null;
		for(int i=0; i<mis_sanciones.size();i++) 
		{
			sancion=mis_sanciones.get(i);
		}
		return sancion;
	}
	
	

	public ArrayList<Sancion> getMis_sanciones() {
		return mis_sanciones;
	}

	public void setMis_sanciones(ArrayList<Sancion> mis_sanciones) {
		this.mis_sanciones = mis_sanciones;
	}

	//prueba
	public void verSancion1(String email)
	{		
		System.out.println("*********** SANCIONES ***********");
			for(int i=0; i<mis_sanciones.size();i++) 
			{
				if(mis_sanciones.get(i).getEmailSocio().equalsIgnoreCase(email))
				{
					
					System.out.println("Tienes una sanción de 10 dias por el libro " + mis_sanciones.get(i).getTitulo_libro_prestamo());
					System.out.println("No puedes alquilar otro libro hasta que finalice la sanción");
				}
				else
				{
					System.out.println("No tiene penalizaciones");
				}
			}
					
	}
	
	public boolean comprobarSancion(String email)
	{		boolean sancion=false;
			for(int i=0; i<mis_sanciones.size();i++) 
			{
				if(mis_sanciones.get(i).getEmailSocio().equalsIgnoreCase(email))
				{
					sancion=true;
				}
			}
			
			return sancion; 
	}				
	
	
	
	public void verSancion(String email)
	{System.out.println("*********** SANCIONES ***********");
		if(this.comprobarSancion(email) ==true)
		{
			System.out.println("Tienes una sanción de 10 dias por el libro " + this.miSancion().getTitulo_libro_prestamo());
			System.out.println("No puedes alquilar otro libro hasta que finalice la sanción");
		}
		else
		{
			System.out.println("No tiene penalizaciones");
		}
	}

	@Override
	public String toString() {
		return "Sancion [Numero_dias_sancion=" + Numero_dias_sancion + ", emailSocio=" + emailSocio
				+ ", titulo_libro_prestamo=" + titulo_libro_prestamo + ", mis_sanciones=" + mis_sanciones + "]";
	}

	
}
