package Presentacion;


import java.text.*;
import java.util.*;

import Dominio.BiblioMovil;
import Dominio.Prestamo;
import Dominio.Sancion;
import Dominio.Usuario;

public class ClasePrincipal {
	
	static Scanner entrada=new Scanner(System.in);
	static BiblioMovil librosBiblio=new BiblioMovil();
	static BiblioMovil mi_socio = new BiblioMovil();
	static Sancion sancion=new Sancion();
	static boolean continuar=true;
	static boolean continuar2=false;
	static boolean corresponde=true;
	static String titulo;
	static Prestamo miPrestamo=new Prestamo();
	static String email;
	static boolean continuar3=true;
	
	public static void main(String[] args) {
		
		menu();
		
	}
	
	public static void menu() 
	{
		int opcion=0;
		boolean excepcion=false;
		do
		{
			excepcion=false;
			System.out.println("****MENU PRINCIPAL*****");
			System.out.println("1.Ver catalogo");
			System.out.println("2.Acceder");
			System.out.println("3.Registrarse");
			System.out.println("4.Salir");
			System.out.println("Introduzca una opción: ");
			try
			{
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

			System.out.println("*****REGISTRO******");
			System.out.println("Introduzca los siguientes datos: ");
			boolean numero=false;
			String nombre = null;
			do
			{
				try 
				{
					System.out.println("1.Nombre: ");
					nombre=entrada.nextLine();
					if(nombre.isEmpty())
					{
						nombre=entrada.nextLine();
					}
					verificarErrorNumeros(nombre);
					numero=false;
				} 
				catch (ErrorIntroducirNumeros e) {
					
					System.out.println(e.getMessage());
					numero=true;
				}
			}while(numero==true);
			
			String apellidos= null;
			do
			{
				try 
				{
					System.out.println("2. Apellido: ");
					apellidos=entrada.nextLine();
					if(apellidos.isEmpty())
					{
						apellidos=entrada.nextLine();
					}
					verificarErrorNumeros(apellidos);
					numero=false;
				} 
				catch (ErrorIntroducirNumeros e) {
					
					System.out.println(e.getMessage());
					numero=true;
				}
			}while(numero==true);
			
			System.out.println("3.Fecha de nacimiento (Escribalo de la forma: DD-MM-AAAA, incluyendo los guiones ");
			
			boolean correcto=false;
			
			String fecha;

			do
			{
				correcto=true;
				fecha=entrada.nextLine();
				if(fecha.isEmpty())
				{
					fecha=entrada.nextLine();	
				}
				if(formatoFechaCorrecto(fecha) ==true)
				{
					correcto=true;
					
				}
				else
				{
					
					System.out.println("Ha introducido datos erróneos, recuerde introducir la fecha de la forma DD-MM-AA, incluyendo los guiones, ingrese de nuevo su fecha de nacimiento: ");
					correcto=false;	
				}
			
			}while(correcto==false);
			
			
			System.out.println("4.Email");

			  int arroba=0;
			  boolean repetido=false;
			  String email;
			  
			  do
				{
					do
					{
						email=entrada.nextLine();
						if(email.isEmpty())
						{
							email=entrada.nextLine();
						}
						
						if(mi_socio.Comprobar_email(email).equalsIgnoreCase(email))
						{
							System.out.println("Este email ya está registrado, ingrese otro email: ");
							repetido=true;
						}
						else
						{
							repetido=false;
							for (int i=0; i<email.length() ; i++)
							{
								if( email.charAt(i) == '@')
								{
									arroba++;
									
				                  System.out.println("5.Comprobar email:");
									
									boolean emailCorrecto=false;
									
									do
									{
										String comprobacionEmail=entrada.nextLine();
										
										if(comprobacionEmail.isEmpty())
										{
											comprobacionEmail=entrada.nextLine();
										}
										
										if(!email.equalsIgnoreCase(comprobacionEmail))
										{
											System.out.println("El email no coincide, pruebe de nuevo");
											emailCorrecto=false;
										}
										else
										{
											emailCorrecto=true;
										}
										
									}while(emailCorrecto==false);
								}	
							}
							if (arroba == 0)
							{
								System.out.println("El email suministrado no tiene @, por favor introduzca de nuevo el email:");
							}
							
						}
					}while(repetido==true);
				}while(arroba==0);
			
			
			System.out.println("6.Establezca una contraseña: ");
			
			boolean coincide=false;
			
			String contrasenya1;
			
			do
			{
				contrasenya1=entrada.nextLine();
				if(contrasenya1.isEmpty())
				{
					contrasenya1=entrada.nextLine();
				}
				
				System.out.println("7. Confirmar contraseña: ");
				String contrasenya2=entrada.nextLine();
				if(contrasenya2.isEmpty())
				{
					contrasenya2=entrada.nextLine();
				}
				
				if(contrasenya1.equals(contrasenya2) ==false)
				{
					System.out.println("Las contraseñas no coinciden, establezca de nuevo la contraseña: ");
					coincide=false;
				}
				else
				{
					System.out.println("Se ha registrado exitosamente");
					coincide=true;
				}
			}while(coincide==false);
			    mi_socio.registrarSocio(miusuario.Registrarse(nombre,apellidos,fecha,email,contrasenya1));

			    continuar2=true;
				break;
			case(4):
				System.out.println("Ha salido del programa");
			    continuar2=false;
				break;
			default:
				System.out.println("Opción errónea, introduzca una opción válida");
			}
			}catch(InputMismatchException e) 
			{
				System.err.println("Ha introducido letras,solo se permiten números, intente de nuevo ");//Mario
				entrada.nextLine();
				excepcion=true;
			}
		}while(opcion!=4 || continuar2==true|| excepcion==true);
	
				
		
	}
	
	public static void mostrarDescripcionLibro()
	{
		boolean mostrar=false; 
		System.out.println("¿Quiere ver la descripción de algún libro? SI/NO");
		 
		 do
		 {	mostrar=false;
			 String resp=entrada.nextLine();
			    
			    if(resp.isEmpty())
			    {
			    	resp=entrada.nextLine();
			    }
	        
			    do
	         {
	         	if(resp.trim().equalsIgnoreCase("SI"))
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
		        		    	boolean corresponde1=false;
	     		    	    	do
	     		    	    	{
	     		    	    		corresponde1=false;
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
			        		        else
			        		        {
			        		        	System.out.println("Respuesta no permitida, recuerde ingresar SI o NO, intente de nuevo");
			        		        	corresponde1=true;
			        		        }
		 		    	    	}while(corresponde1==true);
		        		    		
		        		    	}
	     		    		else
		        		    	{
		        		    		System.out.println("El titulo del libro no corresponde a ninguno de nuestra lista, ingrese de nuevo el titulo: ");
		        		    		corresponde=true;
		        		    	}
		        		    	
	     		    	}while(corresponde==true);
	     		    	
	    
	 		    }
	 		    if(resp.trim().equalsIgnoreCase("NO"))
	 		    {
	 		    	continuar=false;
	 		    	continuar2=true;
	 		    }
	 		    else
	 		    {
	 		    	System.out.println("Respuesta no permitida, recuerde ingresar SI o NO, intente de nuevo");
	 		    	continuar=false;
	 		    	mostrar=true;
	 		    }
	         }while(continuar==true);
		 }while(mostrar==true);
		    
	}
	
	public static void accesoSocio()
	{
		boolean correcto=false;
		boolean correcto2=false;
		System.out.println("***ACCEDER***");
		    System.out.println("Usuario"); 
		    
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
					    System.out.println("Contraseña"); 
					    do
					    {
					    	String contrasenya = entrada.nextLine();
							if(contrasenya.isEmpty())
							{
								correcto2=true;
								contrasenya = entrada.nextLine();
							}	
							if(mi_socio.Comprobar_contrasenya(contrasenya).equalsIgnoreCase(contrasenya))
							{
								correcto2=true;
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
		boolean excepcion=false;
		do
		{
			excepcion=false;
			System.out.println("*****MENÚ SOCIO******");
		    System.out.println("1.Ver catalogo");
		    System.out.println("2.Alquileres");
		    System.out.println("3.Sanciones");
		    System.out.println("4.Cerrar sesión");
		    System.out.println("5.Salir");
		     
		    System.out.println("Introduzca una opcion:");
		    try
		    {
		    	 opcion2=entrada.nextInt();
		    		
				    
				    switch(opcion2)
				    {
				    case(1):
				    	librosBiblio.mostrarDisponibilidad();
				        mostrarDescripcionLibroSocios();
				    	break;
				    case(2):
				    	if(miPrestamo.numeroPrestamos(email) ==0)
						{
				        	System.out.println("*********** PRESTAMOS ***********\n");
				        	System.out.println("No tiene prestamos en curso\n");
						}
				    	if(miPrestamo.numeroPrestamos(email)!=0)
				    	{
				    		miPrestamo.verPrestamos(email);
					        devolverLibro();
				    	}
				    	break;
				    case(3):
				    	sancion.verSancion(email);
				    	break;
				    case(4):
				    	System.out.println("Ha finalizado su sesión");
				    	continuar3=false;  
				    	break;
				    case(5):
				    	System.out.println("Ha salido del programa");
				    //	continuar2=false; //Nunca lo hace se cierra..
				    	break;
				    default:
				    	System.out.println("Opción errónea, intente de nuevo");
				    	break;
				    }
		    }
		    catch(InputMismatchException e) 
			{
				System.err.println("Ha introducido letras,solo se permiten números, intente de nuevo ");
				entrada.nextLine();
				excepcion=true;
			}
		    
		   
		}while(opcion2 <1 && opcion2>5 ||continuar3==true|| excepcion==true );
		
	}

	public static void mostrarDescripcionLibroSocios()
	{
		boolean mostrar=false; 
		System.out.println("¿Quiere ver la descripción de algún libro? SI/NO");
		do
		{mostrar=false; 
			String resp=entrada.nextLine();
		    
		    if(resp.isEmpty())
		    {
		    	resp=entrada.nextLine();
		    }
	    
		    do
		    {
	     	if(resp.trim().equalsIgnoreCase("SI"))
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
	        		    	boolean corresponde1=false;
	 		    	    	do
	 		    	    	{corresponde1=false;
	 		    	    		String resp2=entrada.nextLine();
		        		    	if(resp2.isEmpty())
		        		    	{
		        		    		resp2=entrada.nextLine();
		        		    	}
		        		    	if(resp2.trim().equalsIgnoreCase("NO"))
		        		    	{
		        		    		continuar=false;
		        		    		continuar2=true;
		        		    	}
		        		        if(resp2.trim().equalsIgnoreCase("SI"))
		        		    	{
		        		        	continuar=true;
		        		    	}
		        		        else
		        		        {
		        		        	System.out.println("Respuesta no permitida, recuerde ingresar SI o NO, intente de nuevo");
		        		        	corresponde1=true;
		        		        }
	 		    	    	}while(corresponde1==true);
	 		    	    	
	        		    		
	        		    	}
	 		    		else
	        		    	{
	        		    		System.out.println("El titulo del libro no corresponde a ninguno de nuestra lista, ingrese de nuevo el titulo: ");
	        		    		corresponde=true;
	        		    	}
	        		    	
	 		    	}while(corresponde==true);
	 		    	

			    }
			    if(resp.trim().equalsIgnoreCase("NO"))
			    {
			    	continuar=false;
			    	continuar2=true;
			    }
			    else
	 		    {
	 		    	System.out.println("Respuesta no permitida, recuerde ingresar SI o NO, intente de nuevo");
	 		    	continuar=false;
	 		    	mostrar=true;
	 		    }
	     }while(continuar==true);
		}while(mostrar==true);
	    
	    
	}
	
	public static void alquilarLibro()
	{
		
		Calendar fecha=GregorianCalendar.getInstance();
		int anyo = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		fecha.set(Calendar.SECOND,0);
		fecha.set(Calendar.MILLISECOND, 0);
		
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
					System.out.println("Se ha realizado el prestamo con éxito");
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
		boolean mostrar = false;
		do
		{
			if(miPrestamo.numeroPrestamos(email) >0)
			{
				System.out.println("\n¿Quiere devolver alguno de los libros que tiene en prestamo? SI/NO");
				do
				{
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
								System.out.println("Se ha devuelto el prestamo con éxito");
								Calendar fecha2=Calendar.getInstance();
								fecha2.set(Calendar.SECOND,0);
								fecha2.set(Calendar.MILLISECOND, 0);
								
								if(miPrestamo.obtenerFechaPrestamo(email, tituloNombreADevolver).after(fecha2) == true)
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
					if(resp4.equalsIgnoreCase("NO"))
					{
						menuSocio();
					}
					if(!resp4.equalsIgnoreCase("SI") && !resp4.equalsIgnoreCase("NO")) 
					{
						System.out.println("Respuesta no permitida, recuerde ingresar SI o NO, intente de nuevo");
		 		    	mostrar = true;
					}
				}while(mostrar==true);
				
				
			}
		}while(miPrestamo.numeroPrestamos(email) >0);
		
		if(miPrestamo.numeroPrestamos(email) ==0)
		{
			menuSocio();
		}

	}

	
	public static void verificarErrorNumeros(String nombre) throws ErrorIntroducirNumeros
	{
		for( int i=0; i<nombre.length() ; i++)
		{
			char numero=nombre.charAt(i);
			if(Character.isDigit(numero))
			{
				ErrorIntroducirNumeros miExcepcion1=new ErrorIntroducirNumeros("Ha introducido números en el campo, por favor intente de nuevo");
				throw miExcepcion1;
			}
		}
	}
	
	public static boolean formatoFechaCorrecto(String fecha) 
	{
		String DATE_FORMAT = "dd-MM-yyyy";
	    try {
	        DateFormat fechaFormato = new SimpleDateFormat(DATE_FORMAT);
	        fechaFormato.setLenient(false);
	        fechaFormato.parse(fecha); //Lanza una excepción
	        return true;
	    } 
	    catch (ParseException e)
	    {
	        return false;
	    }
	}
	
	
}
