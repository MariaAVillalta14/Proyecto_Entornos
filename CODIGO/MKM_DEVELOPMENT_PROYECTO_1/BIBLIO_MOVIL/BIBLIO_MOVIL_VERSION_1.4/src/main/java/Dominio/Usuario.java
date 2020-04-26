package Dominio;

import java.util.*;

public class Usuario {
	static Scanner entrada=new Scanner(System.in);

	
public Socio Registrarse(BiblioMovil socio)
{
		Socio misocio;
        
	
		System.out.println("*****REGISTRO******");
		System.out.println("Introduzca los siguientes datos: ");
		System.out.println("1.Nombre: ");
		String nombre=entrada.nextLine();
		if(nombre.isEmpty())
		{
			nombre=entrada.nextLine();
		}
		
		System.out.println("2. Apellido: ");
		String apellidos=entrada.nextLine();
		if(apellidos.isEmpty())
		{
			apellidos=entrada.nextLine();
		}
		
		System.out.println("3.Fecha de nacimiento (Escribalo de la forma: DD-MM-AA, incluyendo los guiones ");
		String fecha=entrada.nextLine();
		if(fecha.isEmpty())
		{
			fecha=entrada.nextLine();
		}
		
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
					
					if(socio.Comprobar_email(email).equalsIgnoreCase(email))
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
		
		 misocio=new Socio(nombre, apellidos, fecha, email, contrasenya1);
		 
		 return misocio;
		
	}
	

}
