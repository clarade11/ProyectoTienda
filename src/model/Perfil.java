package model;

public class Perfil {
	private String nombre;
	private String Apellidos;
	private String Sexo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public Perfil() {
		super();
	}
	public Perfil(String nombre, String apellidos, String sexo) {
		super();
		this.nombre = nombre;
		Apellidos = apellidos;
		Sexo = sexo;
	}
}
