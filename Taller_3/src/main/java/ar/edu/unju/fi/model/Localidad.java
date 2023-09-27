package ar.edu.unju.fi.model;

import java.util.ArrayList;
import java.util.List;

public class Localidad {

	private String nombre;
	private Integer codigoPostal;
	private List<Cliente> listaClientes = new ArrayList<Cliente>();

	public Localidad(String nombre, Integer codigoPostal) {
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
	}

	public Localidad() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "Localidad [nombre=" + nombre + ", CP: " + codigoPostal;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

}