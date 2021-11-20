package model;

public class Producto {

	private String nombre;
	private Double precio;
	private Integer cantidadCompra;
	private String categoria;
	private String urlImagen;
	
	public Producto() {
	}
	
	public Producto(String nombre, Double precio, Integer cantidadCompra,String categoria,String urlImagen) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadCompra = cantidadCompra;
		this.categoria=categoria;
		this.urlImagen=urlImagen;
	}
	
	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Integer getCantidadCompra() {
		return cantidadCompra;
	}
	
	public void setCantidadCompra(Integer cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}
}
