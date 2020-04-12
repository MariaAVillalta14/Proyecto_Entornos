package main.java.Dominio;


import java.util.*;

import main.java.Dominio.Libro.Formato;


public class BiblioMovil {
	static Scanner entrada=new Scanner(System.in);
	private ArrayList <Socio> socios;
	private ArrayList <Libro> libros;
	
	public BiblioMovil() 
	{
		this.socios =new ArrayList <Socio>();
		socios.add(new Socio("Maria","Villalta","14-08-1998","villaltamaria@gmail.com","123456"));
		socios.add(new Socio("Camila","Zapata","06-12-2001","zapatacamila@gmail.com","123456"));
		socios.add(new Socio("Kevim","Chacón","17-09-1993","chaconkevim@gmail.com","123456"));
		socios.add(new Socio("Laura", "Aguirre", "17-11-2000", "lau_aguirre@hotmail.com", "654321"));
		socios.add(new Socio("Antonella", "Gutierrez","12-12-1999", "anto123@gmail.com", "anto123"));
		socios.add(new Socio("Jonh", "Lopez", "30-02-1980", "jonh612@outlook.com", "J763746824"));
		
		
		this.libros=new ArrayList<Libro>();
		libros.add(new Libro("Cien años de soledad",1967,"Gabriel García Marquez","Planeta",true,Formato.DIGITAL," Es considerada una obra maestra de la literatura hispanoamericana y universal, así como una de las obras más traducidas y leidas en español"));
		libros.add(new Libro("El Señor de los Anillos",1954,"J. R. R. Tolkien","Acantilado",false,Formato.FISICO," El Señor de los Anillos es una novela de fantasía épica escrita por el filólogo y escritor británico J. R. R. Tolkien."));
		libros.add(new Libro("El Alquimista",1988,"Paulo Coelho","Alba",true,Formato.DIGITAL," Relata las aventuras de Santiago, un joven pastor andaluz que un día emprende un viaje por las arenas del desierto en busca de un tesoro."));
		libros.add(new Libro("La chica de nieve", 2020, "Javier Castillo","SUMA", false, Formato.FISICO, "El desfile más famoso del planeta. Una niña de tres años desaparecida. ¿Dónde está Kiera Templeton? Nueva York, 1998, cabalgata de Acción de Gracias."));
		libros.add(new Libro("La madre de Frankenstein", 2020, "Almudena Grande", "Tusquets Editores", true, Formato.DIGITAL, "En 1954, el joven psiquiatra Germán Velázquez vuelve a España para trabajar en el manicomio de mujeres de Ciempozuelos, al sur de Madrid."));
		libros.add(new Libro("Don Quijote de la Mancha", 1615, "Miguel de Cervantes", "Francisco de Robles", false, Formato.DIGITAL, "Es la primera obra genuinamente desmitificadora de la tradición caballeresca y cortés por su tratamiento burlesco."));
		libros.add(new Libro("Mientras te olvido", 2017, "Nacarid Portal", "Deja Vu", true, Formato.DIGITAL, "Cuenta la historia de una chica, que cuando cumplía ocho años con su pareja, se encontrá³ con su abandono."));
		libros.add(new Libro("Lugares asombrosos", 2019, "Luis Villar", "ALFAGUARA JUVENIL", true, Formato.FISICO, "La curiosidad es el motor de las aventuras que lo lanzan hasta los terrenos más inhospitos y misteriosos."));
		libros.add(new Libro("Sí, si es contigo", 2019, "Calle y Poché", "GRIJALBO", false, Formato.DIGITAL, "Es una novela sobre el primer amor, y todo lo doloroso y maravilloso que eso implica."));
		libros.add(new Libro("Cuentos extraños", 2016, "Nicolás Arrieta", "Ediciones", false, Formato.FISICO, "Para Nicolás los niños con problemas son gente fea y aberrante, cuyo único contacto con el mundo es el internet. "));
	

	}
	
	public void mostrarCatalago()
	{
		Iterator<Libro> it=libros.iterator();
		
		System.out.println("***********CATÁLOGO LIBROS***********");
		System.out.printf("\n%-40s%-40s", "TITULO" , "AUTOR");
		while(it.hasNext())
		{
			Libro libro=(Libro)it.next();
			System.out.printf("\n%-40s%-40s\n",libro.getTitulo(),libro.getAutor());
		}
	}
	
	public void mostrarDisponibilidad()
	{
        Iterator<Libro> it=libros.iterator();
		
		System.out.println("***********CATÁLOGO LIBROS***********");
		System.out.printf("\n%-40s%-40s%-40s", "TITULO" , "AUTOR","DISPONIBILIDAD");
		while(it.hasNext())
		{
			Libro libro=(Libro)it.next();
			System.out.printf("\n%-40s%-40s%-40s\n",libro.getTitulo(),libro.getAutor(),libro.getDisponibilidad());
		}
	
	}
	
	
    //METODO OPCIONAL PARA VISUALIZAR LOS SOCIOS EXISTENTES
	
	public void mostrarSocios()
	{
		//titulo libro, autor
		Iterator<Socio> it=socios.iterator();
		
		System.out.println("***********SOCIOS***********");
		System.out.printf("\n%-40s%-40s", "NOMBRE" , "APELLIDO");
		while(it.hasNext())
		{
			Socio socio=(Socio)it.next();
			System.out.printf("\n%-40s%-40s\n",socio.getNombre(),socio.getApellidos());
		}
	}
	
	public String descripcionLibro(String titulo)
	{
		String descripcion = null;
		for(int i=0; i<libros.size(); i++)
		{
			if(libros.get(i).getTitulo().equalsIgnoreCase(titulo))
			{
				descripcion=libros.get(i).getDescripcion();
			}
		}
		return "***DESCRIPCIÓN***\n"+descripcion;
	}
	
	public void registrarSocio(Socio misocio)
	{
		socios.add(misocio);
	}
	

	public ArrayList<Socio> getSocios() {
		return socios;
	}

	public void setSocios(ArrayList<Socio> socios) {
		this.socios = socios;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
	public String Comprobar_email(String email)
	{
		String correo= " ";
		for(int i=0; i<socios.size(); i++)
		{
			if(socios.get(i).getEmail().equalsIgnoreCase(email))
			{
				correo = email;
			}
		}
		return correo;
	}
	
	public String Comprobar_contrasenya(String contrasenya)
	{
		String contrasenya1 = " ";
		for(int i=0; i<socios.size(); i++)
		{
			if(socios.get(i).getContrasenya().equalsIgnoreCase(contrasenya))
			{
				contrasenya1 = socios.get(i).getContrasenya();
			}
		}
		return contrasenya1;
	}
	
	public String tituloLibro(String nombre)
	{
		String titulo="";
		for(int i=0; i<libros.size() ;i++)
		{
			if(libros.get(i).getTitulo().equalsIgnoreCase(nombre))
			{
				titulo=libros.get(i).getTitulo();
			}

		}
		return titulo;
	}
	
	public String getDisponibilidad(String titulo)
	{
		String disponibilidad = null;
		for(int i=0; i<libros.size() ; i++)
		{
			if(libros.get(i).getTitulo().equalsIgnoreCase(titulo))
			{
				disponibilidad=libros.get(i).getDisponibilidad();
			}
		}
		
		return disponibilidad;
	}

	public Libro Libro(String titulo)
	{
		Libro libro = null;
		for(int i=0; i<libros.size(); i++)
		{
			if(titulo.equalsIgnoreCase(libros.get(i).getTitulo()))
			{
				libro=libros.get(i);
			}
			
		}
		return libro;
	}
	
	
	
}
