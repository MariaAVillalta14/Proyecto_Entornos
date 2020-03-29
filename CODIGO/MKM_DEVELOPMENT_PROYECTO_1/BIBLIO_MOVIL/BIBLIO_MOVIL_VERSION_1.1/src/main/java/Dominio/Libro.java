package main.java.Dominio;



public class Libro {

	public enum Formato
	{
		FISICO, DIGITAL;
	}
	
	private String titulo;
	private int anyo_publicacion;
	private String autor;
	private String editorial;
	private boolean disponibilidad;
	private Formato formato;
	private String descripcion;
	
	public Libro(String titulo, int anyo_publicacion, String autor, String editorial, boolean disponibilidad, Formato formato, String descripcion) 
	{
		
		this.titulo = titulo;
		this.anyo_publicacion = anyo_publicacion;
		this.autor = autor;
		this.editorial = editorial;
		this.disponibilidad = disponibilidad;
		this.formato = formato;
		this.descripcion=descripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnyo_publicacion() {
		return anyo_publicacion;
	}

	public void setAnyo_publicacion(int anyo_publicacion) {
		this.anyo_publicacion = anyo_publicacion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getDisponibilidad() {
		if(disponibilidad == true)
		{
			return "Disponible";
		}
		else
			return "No disponible";
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

