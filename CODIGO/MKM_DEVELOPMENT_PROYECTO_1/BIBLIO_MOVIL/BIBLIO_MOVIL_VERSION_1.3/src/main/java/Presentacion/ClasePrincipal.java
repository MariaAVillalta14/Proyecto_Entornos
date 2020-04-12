package main.java.Presentacion;

import java.util.*;

import main.java.Dominio.BiblioMovil;
import main.java.Dominio.Prestamo;
import main.java.Dominio.Sancion;
import main.java.Dominio.Usuario;

public class ClasePrincipal {
	
	static Scanner entrada=new Scanner(System.in);
	static BiblioMovil librosBiblio=new BiblioMovil();
	static BiblioMovil mi_socio = new BiblioMovil();
	static Sancion sancion=new Sancion();
	static boolean continuar=true;
	static boolean continuar2=false;
	static boolean continuar3=true;
	static boolean corresponde=true;
	static boolean correcto=false;
	static boolean correcto2=false;
	static int opcion=0;
	static String titulo;
	static Prestamo miPrestamo=new Prestamo();
	static String email;
	static Calendar fecha=GregorianCalendar.getInstance();
	static Prestamo prestamo=new Prestamo();
	static int anyo = fecha.get(Calendar.YEAR);
	static int mes = fecha.get(Calendar.MONTH);
	static int dia = fecha.get(Calendar.DAY_OF_MONTH);
	public static void main(String[] args) {
		

		menu();
		

	}
	
	public static void menu()
	{
		do
		{
			System.out.println("****MENU PRINCIPAL*****");
			System.out.println("1.Ver catalogo");
			System.out.println("2.Acceder");
			System.out.println("3.Registrarse");
			System.out.println("4.Salir");
			System.out.println("Introduzca una opción: ");
			
			opcion=entrada.nextInt();
			
			switch(opcion)
			{
			case(1):					
			    librosBiblio.mostrarCatalago();
				mostrarDescripcionLibro();    
				break;
			case(2):	
				accesoSocio();
		        continuar2=true;
				break;
			case(3):
				Usuario miusuario=new Usuario();
			    mi_socio.registrarSocio(miusuario.Registrarse(mi_socio));
			    continuar2=true;
				break;
			case(4):
				System.out.println("Ha salido del programa");
			    continuar2=false;
				break;
			default:
				System.out.println("Opción errónea, introduzca una opción válida");
			}
		}while(opcion <1 && opcion >4 || continuar2==true);
		
	}
	
	public static void mostrarDescripcionLibro()
	{
		 System.out.println("¿Quiere ver la descripción de algún libro? SI/NO");
		    String resp=entrada.nextLine();
		    
		    if(resp.isEmpty())
		    {
		    	resp=entrada.nextLine();
		    }
        
		    do
         {
         	if(resp.equalsIgnoreCase("SI"))
 		    {

         			System.out.println("Escriba el titulo del libro:");
     		    	   	
                    
     		    	do
     		    	{
     		    		String titulo=entrada.nextLine();
     		    		if(titulo.isEmpty())
	        		    	{
	        		    		titulo=entrada.nextLine();
	        		    	}
     		    	    if(librosBiblio.tituloLibro(titulo).equalsIgnoreCase(titulo))
	        		    	{
     		    	    	System.out.println(librosBiblio.descripcionLibro(titulo));
     		    	    	corresponde=false;
     		    	    	System.out.println("¿Quiere ver la descripción de otro libro? SI/NO");
	        		    		
     		    	    	String resp2=entrada.nextLine();
		        		    	if(resp2.isEmpty())
		        		    	{
		        		    		resp2=entrada.nextLine();
		        		    	}
		        		    	if(resp2.equalsIgnoreCase("NO"))
		        		    	{
		        		    		continuar=false;
		        		    		continuar2=true;
		        		    	}
		        		        if(resp2.equalsIgnoreCase("SI"))
		        		    	{
		        		        	
                                continuar=true;
		        		    	}
	        		    		
	        		    	}
     		    		else
	        		    	{
	        		    		System.out.println("El titulo del libro no corresponde a ninguno de nuestra lista, ingrese de nuevo el titulo: ");
	        		    		corresponde=true;
	        		    	}
	        		    	
     		    	}while(corresponde==true);
     		    	
    
 		    }
 		    if(resp.equalsIgnoreCase("NO"))
 		    {
 		    	continuar=false;
 		    	continuar2=true;
 		    }
         }while(continuar==true);
	}
	
	public static void accesoSocio()
	{
		
		
		System.out.println("***ACCEDER***");
		    System.out.println("1.Usuario"); 
		    
		     do
		     {
		    	 email = entrada.nextLine();
				    if(email.isEmpty())
				    {
				    	email = entrada.nextLine();
				    }
			 
				    if(mi_socio.Comprobar_email(email).equalsIgnoreCase(email))
				    {
				    	correcto=true;
					    System.out.println("2.Contraseña"); 
					    do
					    {
					    	String contrasenya = entrada.nextLine();
							if(contrasenya.isEmpty())
							{
								contrasenya = entrada.nextLine();
							}	
							if(mi_socio.Comprobar_contrasenya(contrasenya).equalsIgnoreCase(contrasenya))
							{
								correcto=true;
								menuSocio();
								
							}
							else
							{
								System.out.println("Contraseña incorrecta, intente de nuevo: ");
								correcto2=false;
							}
					    }while(correcto2==false);
						
				    }
				    else
				    {
				    	System.out.println("Email incorrecto, ingrese de nuevo su email: ");
				    	correcto=false;
				    } 
		     }while(correcto==false);
	}

	public static void menuSocio()
	{
		int opcion2=0;
		
		
		do
		{
			System.out.println("*****MENÚ SOCIO******");
		    System.out.println("1.Ver catalogo");
		    System.out.println("2.Alquileres");
		    System.out.println("3.Sanciones");
		    System.out.println("4.Salir");
		     
		    System.out.println("Introduzca una opcion:");
		    opcion2=entrada.nextInt();
	
		    
		    switch(opcion2)
		    {
		    case(1):
		    	librosBiblio.mostrarDisponibilidad();
		        mostrarDescripcionLibroSocios();
		    	break;
		    case(2):
		    	miPrestamo.verPrestamos(email);
		        devolverLibro();
		    	break;
		    case(3):
		    	sancion.verSancion(email);
		    	break;
		    case(4):
		    	menu();
		    	continuar2=true;
		    	continuar3=false;  
		    	break;
		    default:
		    	System.out.println("Opción errónea, intente de nuevo");
		    	break;
		    }
		}while(opcion2 <1 && opcion2>4 ||continuar3==true);
	     
	}

	public static void mostrarDescripcionLibroSocios()
	{
		System.out.println("¿Quiere ver la descripción de algún libro? SI/NO");
	    String resp=entrada.nextLine();
	    
	    if(resp.isEmpty())
	    {
	    	resp=entrada.nextLine();
	    }
    
	    do
	    {
     	if(resp.equalsIgnoreCase("SI"))
		    {

     			System.out.println("Escriba el titulo del libro:");
 		    	   	
                
 		    	do
 		    	{
 		    		titulo=entrada.nextLine();
 		    		if(titulo.isEmpty())
        		    	{
        		    		titulo=entrada.nextLine();
        		    	}
 		    	    if(librosBiblio.tituloLibro(titulo).equalsIgnoreCase(titulo))
        		    	{
 		    	    	System.out.println(librosBiblio.descripcionLibro(titulo));
 		    	    	 alquilarLibro();	
 		    	    	corresponde=false;
 		    	    	System.out.println("¿Quiere ver la descripción de otro libro? SI/NO");
        		    		
 		    	    	String resp2=entrada.nextLine();
	        		    	if(resp2.isEmpty())
	        		    	{
	        		    		resp2=entrada.nextLine();
	        		    	}
	        		    	if(resp2.equalsIgnoreCase("NO"))
	        		    	{
	        		    		continuar=false;
	        		    		continuar2=true;
	        		    	}
	        		        if(resp2.equalsIgnoreCase("SI"))
	        		    	{
	        		       
                            continuar=true;
	        		    	}
        		    		
        		    	}
 		    		else
        		    	{
        		    		System.out.println("El titulo del libro no corresponde a ninguno de nuestra lista, ingrese de nuevo el titulo: ");
        		    		corresponde=true;
        		    	}
        		    	
 		    	}while(corresponde==true);
 		    	

		    }
		    if(resp.equalsIgnoreCase("NO"))
		    {
		    	continuar=false;
		    	continuar2=true;
		    }
     }while(continuar==true);
	}
	
	public static void alquilarLibro()
	{
		System.out.println("¿Desea alquilar este libro? SI/NO");
		String resp3=entrada.nextLine();
		if(resp3.isEmpty())
		{
			resp3=entrada.nextLine();
		}

		if(resp3.equalsIgnoreCase("SI"))
		{
			if(sancion.comprobarSancion(email)==false)
			{
				if(librosBiblio.getDisponibilidad(titulo).equalsIgnoreCase("Disponible"))
				{
					miPrestamo.anyadirPrestamo(new Prestamo(Prestamo.fecha_inicio(anyo,mes,dia ),Prestamo.fecha_fin(anyo,mes,dia),email,librosBiblio.Libro(titulo).getTitulo()));
				}
				else
				{
					System.out.println("Este libro no se encuentra disponible, no lo puede alquilar");
				}
			}
			else
			{
				System.out.println("Usted tiene una sanción, no puedes alquilar otro libro hasta que finalice la sanción");
			}
		}
		
	}
	
	public static void devolverLibro()
	{
		boolean repetir=false;
		System.out.println("\n¿Quiere devolver alguno de los libros que tiene en prestamo? SI/NO");
		String resp4=entrada.nextLine();
		if(resp4.isEmpty())
		{
			resp4=entrada.nextLine();
		}
		if(resp4.equalsIgnoreCase("SI"))
		{
			System.out.println("Introduzca el titulo del libro que desea devolver: ");
			do
			{
				String tituloNombreADevolver=entrada.nextLine();
				if(tituloNombreADevolver.isEmpty())
				{
					tituloNombreADevolver=entrada.nextLine();
				}

				
				if(miPrestamo.tituloCoincide(email,tituloNombreADevolver)==true)
				{
					
					miPrestamo.devolverLibro(email,librosBiblio.Libro(tituloNombreADevolver).getTitulo());
					
					
					if(miPrestamo.obtenerFechaPrestamo(email, titulo).after(Calendar.getInstance()) == true)
					{
						sancion.anyadirSancion(new Sancion(email,tituloNombreADevolver));
					}
					repetir=false;
				
				}
				else
				{
					System.out.println("No tiene un prestamo de libro con el titulo:  '" +tituloNombreADevolver + "' , por favor, ingrese de nuevo el titulo del libro que desea devolver:");
					repetir=true;
				}
			}while(repetir==true);
			
			
			
			
				
			
			
			
			
			
		}
	}

	
}
