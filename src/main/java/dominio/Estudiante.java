package dominio;

import java.sql.SQLException;

public class Estudiante extends Entidad {

	private String nombre;
	private String apellido;
	private String carrera;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setPadron(String carrera) {
		this.carrera = carrera;
	}
		
	public Estudiante() {		
	}
	
	public Estudiante(String nombre, String apellido, String carrera) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.carrera = carrera;
	}
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", padron=" + carrera + "]\n";
	}	
}
