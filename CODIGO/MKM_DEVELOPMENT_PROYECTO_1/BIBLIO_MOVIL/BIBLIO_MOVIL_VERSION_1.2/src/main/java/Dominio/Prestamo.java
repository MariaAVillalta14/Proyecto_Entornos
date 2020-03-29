package main.java.Dominio;

import java.util.*;

public class Prestamo {

	private int fecha_inicio;
	private int fecha_fin;
	private ArrayList<Libro> librosPrestados;

	
	public Prestamo(int fecha_inicio, int fecha_fin, ArrayList<Libro> librosPrestados) {
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.librosPrestados = librosPrestados;
	}
	public int getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(int fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public int getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(int fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public ArrayList<Libro> getLibrosPrestados() {
		return librosPrestados;
	}
	public void setLibrosPrestados(ArrayList<Libro> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}
	
	
	
}
