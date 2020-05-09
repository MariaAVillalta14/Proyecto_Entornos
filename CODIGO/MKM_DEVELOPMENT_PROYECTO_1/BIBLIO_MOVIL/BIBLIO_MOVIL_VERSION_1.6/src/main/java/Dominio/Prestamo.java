package Dominio;

import java.util.*;

public class Prestamo {


	private Calendar fecha_inicio;
	private Calendar fecha_fin;
	private ArrayList<Prestamo> librosPrestados;
	private String emailSocio;
	private String tituloLibroPrestamo;

	
	public Prestamo(Calendar fecha_inicio, Calendar fecha_fin, String emailSocio,String tituloLibroPrestamo) {
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.emailSocio=emailSocio;
		this.tituloLibroPrestamo=tituloLibroPrestamo;
	}
	
	public Prestamo(){
		this.librosPrestados=new ArrayList<Prestamo>();
		librosPrestados.add(new Prestamo(fecha_inicio(2020, Calendar.APRIL, 1),fecha_fin(2020,Calendar.APRIL,1),"villaltamaria@gmail.com","El Alquimista"));
		librosPrestados.add(new Prestamo(fecha_inicio(2020, Calendar.APRIL, 2),fecha_fin(2020,Calendar.APRIL,2),"villaltamaria@gmail.com","Cien años de soledad"));
		librosPrestados.add(new Prestamo(fecha_inicio(2020, Calendar.APRIL, 3),fecha_fin(2020,Calendar.APRIL,3),"zapatacamila@gmail.com","Cien años de soledad"));
		librosPrestados.add(new Prestamo(fecha_inicio(2020, Calendar.JANUARY, 4),fecha_fin(2020,Calendar.JANUARY,4),"chaconkevim@gmail.com","La chica de nieve"));	
	}

	public Prestamo(String emailSocio)
	{
		this.emailSocio=emailSocio;	
	}
	
	
	public static Calendar fecha_inicio(int anyo, int mes,int dia)
 	{
 		Calendar fecha_inicio = Calendar.getInstance();
 		fecha_inicio.set(Calendar.SECOND,0);
 		fecha_inicio.set(Calendar.MILLISECOND,0);
 		fecha_inicio.set(anyo,mes, dia);	
 		Date fecha=fecha_inicio.getTime();
 		Calendar fecha_inicio1=Calendar.getInstance();
 		
 		fecha_inicio1.setTime(fecha);
 		return fecha_inicio1;
 	}
	
	public Calendar getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(int anyo, int mes,int dia)
	{
		Calendar fecha_inicio;
		fecha_inicio=fecha_inicio(anyo,mes,dia);
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_inicio1() 
	{
        int año = fecha_inicio.get(Calendar.YEAR);
        int mes = fecha_inicio.get(Calendar.MONTH)+1 ;
        int dia = fecha_inicio.get(Calendar.DAY_OF_MONTH);
		return dia + "/" + (mes) + "/" + año ;
	}
	
	public String getFecha_fin1()
	{
		int año = fecha_fin.get(Calendar.YEAR);
        int mes = fecha_fin.get(Calendar.MONTH)+1 ;
        int dia = fecha_fin.get(Calendar.DAY_OF_MONTH);
		return dia + "/" + (mes) + "/" + año ;
	}
	
	public static Calendar fecha_fin(int anyo,int mes, int dia)
	{		
		Calendar fecha_inicio=Calendar.getInstance();
		fecha_inicio.set(Calendar.MINUTE,0);
 		fecha_inicio.set(Calendar.MILLISECOND,0);
		fecha_inicio=fecha_inicio(anyo,mes,dia);
		fecha_inicio.add(Calendar.DAY_OF_MONTH, 30);
		Date fecha=fecha_inicio.getTime();
 		Calendar fecha_fin1=Calendar.getInstance();
 		fecha_fin1.setTime(fecha);

 		return fecha_fin1;	
	}

	public Calendar getFecha_fin() {

 		
		return fecha_fin;
	}

	public void setFecha_fin(int anyo,int mes, int dia)
	{
		Calendar fecha_fin;
		fecha_fin=fecha_fin(anyo,mes,dia);
		
		this.fecha_fin = fecha_fin;
		
	}
	
	public void anyadirPrestamo(Prestamo miPrestamo)
	{	
		librosPrestados.add(miPrestamo);
	}

	public void devolverLibro(String emailSocio,String titulo)
	{
		for(int i=0; i<librosPrestados.size();i++)
		{
			if(librosPrestados.get(i).getEmailSocio().equalsIgnoreCase(emailSocio))
			{
				if(librosPrestados.get(i).getTituloLibroPrestamo().equalsIgnoreCase(titulo))
				{
					librosPrestados.remove(librosPrestados.get(i));
				}
			}
			
		}
		
	}
	
	public ArrayList<Prestamo> getLibrosPrestados() 
	{
		return librosPrestados;
	}
	public void setLibrosPrestados(ArrayList<Prestamo> librosPrestados) 
	{
		this.librosPrestados = librosPrestados;
	}
	
	
	public String getEmailSocio() {
		return emailSocio;
	}

	public void setEmailSocio(String emailSocio) {
		this.emailSocio = emailSocio;
	}

	public String getTituloLibroPrestamo() {
		return tituloLibroPrestamo;
	}

	public void setTituloLibroPrestamo(String tituloLibroPrestamo) {
		this.tituloLibroPrestamo = tituloLibroPrestamo;
	}
	
	public void verPrestamos(String email)
	{	
		
		System.out.println("*********************** PRESTAMOS ************************");
		System.out.printf("\n%-40s%-40s%-40s\n", "TITULO" , "FECHA INICIO","FECHA FIN" );
		
			for(int i=0; i<librosPrestados.size();i++) 
			{
				if(librosPrestados.get(i).getEmailSocio().equalsIgnoreCase(email))
				{
			
					System.out.printf("\n%-40s%-40s%-40s\n",librosPrestados.get(i).getTituloLibroPrestamo(), librosPrestados.get(i).getFecha_inicio1(),librosPrestados.get(i).getFecha_fin1());	
						
				}
				
			}
					
	}
	
	public int numeroPrestamos(String email)
	{	
		int contador=0;
			for(int i=0; i<librosPrestados.size();i++) 
			{
				if(librosPrestados.get(i).getEmailSocio().equalsIgnoreCase(email))
				{
					contador++;
				}
				
			}
		return contador;		
	}

	public Calendar obtenerFechaPrestamo(String emailSocio,String titulo)
	{
		Calendar fecha=Calendar.getInstance();
		
		for(int i=0; i<librosPrestados.size();i++)
		{
			if(librosPrestados.get(i).getEmailSocio().equalsIgnoreCase(emailSocio))
			{
				if(librosPrestados.get(i).getTituloLibroPrestamo().equalsIgnoreCase(titulo))
				{
					fecha=librosPrestados.get(i).getFecha_fin();
					fecha.set(Calendar.SECOND,0);
			 		fecha.set(Calendar.MILLISECOND,0);
				}
			}
			
			
		}
		return fecha;
	}

	public boolean tituloCoincide(String email,String titulo)
	{
		boolean tituloCoincide=false;
		for(int i=0; i<librosPrestados.size();i++)
		{
			if(librosPrestados.get(i).getEmailSocio().equalsIgnoreCase(email))
			{
				if(librosPrestados.get(i).getTituloLibroPrestamo().equalsIgnoreCase(titulo))
				{
					tituloCoincide=true;
				}
				
			}
			
		}
		return tituloCoincide;
	}

	@Override
	public String toString() {
		return "Prestamo [fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", librosPrestados="
				+ librosPrestados + ", emailSocio=" + emailSocio + ", tituloLibroPrestamo=" + tituloLibroPrestamo + "]";
	}
	

	
}