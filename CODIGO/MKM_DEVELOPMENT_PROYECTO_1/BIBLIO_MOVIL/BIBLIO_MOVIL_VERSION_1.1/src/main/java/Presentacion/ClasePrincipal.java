package Presentacion;

import java.util.*;

import Dominio.BiblioMovil;
import Dominio.Usuario;

public class ClasePrincipal {
	
	static Scanner entrada=new Scanner(System.in);
	static BiblioMovil librosBiblio=new BiblioMovil();
	static BiblioMovil mi_socio = new BiblioMovil();
	static boolean continuar=true;
	

	static boolean continuar2=false;
	static boolean continuar3=true;
	static boolean corresponde=true;
	static boolean correcto=false;
	static boolean correcto2=false;
	static int opcion=0;
	
	public static void main(String[] args) {
		
		do
		{
			System.out.println("****MENU PRINCIPAL*****");
			System.out.println("1.Ver catalogo");
			System.out.println("2.Acceder");
			System.out.println("3.Registrarse");
			System.out.println("4.Salir");
			System.out.println("Introduzca una opci�n: ");
			
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
				System.out.println("Opci�n err�nea, introduzca una opci�n v�lida");
			}
		}while(opcion <1 && opcion >4 || continuar2==true);
		
		
		

	}
	
	
	public static void mostrarDescripcionLibro()
	{
		 System.out.println("�Quiere ver la descripci�n de alg�n libro? SI/NO");
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
     		    	    	System.out.println("�Quiere ver la descripci�n de otro libro? SI/NO");
	        		    		
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
		String email;
		
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
					    System.out.println("2.Contrase�a"); 
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
								System.out.println("Contrase�a incorrecta, intente de nuevo: ");
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
			System.out.println("*****MEN� SOCIO******");
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
		    	break;
		    case(2):
		    	System.out.println("Disponible para la pr�xima entrega");
		    	break;
		    case(3):
		    	System.out.println("Disponible para la pr�xima entrega");
		    	break;
		    case(4):
		    	continuar2=true;
		    	continuar3=false;  
		    	break;
		    default:
		    	System.out.println("Opci�n err�nea, intente de nuevo");
		    	break;
		    }
		}while(opcion2 <1 && opcion2>4 ||continuar3==true);
	     
	    
	  
	}
}
