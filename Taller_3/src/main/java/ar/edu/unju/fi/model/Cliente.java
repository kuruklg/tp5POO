package ar.edu.unju.fi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase abstracta Cliente representa a un cliente del corralón. Los clientes
 * pueden ser de diferentes tipos, como cuentas corrientes o grandes compras, y
 * pueden realizar compras en el corralón.
 * 
 * Esta clase define propiedades comunes de un cliente, como su identificación,
 * DNI, nombre, dirección de correo electrónico, teléfono, localidad y una lista
 * de compras realizadas.
 * 
 * También implementa la interfaz Comparable para permitir la comparación de
 * clientes en función de su número de DNI.
 * 
 * Se considera abstracta porque se espera que las subclases implementen los
 * métodos abstractos addCompra() y mostrarCompras() según su tipo de cliente.
 */
public abstract class Cliente implements Comparable<Cliente> {
	private Integer id;
	private Integer dni;
	private String nombre;
	private String eMail;
	private Integer telefono;
	private static Integer nextId = 1;
	private Localidad localidad;
	protected List<Compra> listaCompras = new ArrayList<Compra>();

	/**
	 * Método abstracto para agregar una compra a la lista de compras del cliente.
	 * La implementación de este método debe ser proporcionada por las subclases.
	 * 
	 * @param compra La compra que se va a agregar.
	 */
	public abstract void addCompra(Compra compra);

	/**
	 * Método abstracto para mostrar las compras realizadas por el cliente. La
	 * implementación de este método debe ser proporcionada por las subclases.
	 */
	public abstract void mostrarCompras();

	/**
	 * Constructor que crea un nuevo cliente con la información básica.
	 * 
	 * @param dni       Número de DNI del cliente.
	 * @param nombre    Nombre del cliente.
	 * @param eMail     Dirección de correo electrónico del cliente.
	 * @param telefono  Número de teléfono del cliente.
	 * @param localidad Localidad donde reside el cliente.
	 */
	public Cliente(Integer dni, String nombre, String eMail, Integer telefono, Localidad localidad) {
		this.id = nextId;
		this.dni = dni;
		this.nombre = nombre;
		this.eMail = eMail;
		this.telefono = telefono;
		this.localidad = localidad;
		nextId++;
	}

	/**
	 * Constructor que crea un nuevo cliente con información completa, incluida una
	 * lista de compras previas.
	 * 
	 * @param dni          Número de DNI del cliente.
	 * @param nombre       Nombre del cliente.
	 * @param eMail        Dirección de correo electrónico del cliente.
	 * @param telefono     Número de teléfono del cliente.
	 * @param localidad    Localidad donde reside el cliente.
	 * @param listaCompras Lista de compras previas realizadas por el cliente.
	 */
	public Cliente(Integer dni, String nombre, String eMail, Integer telefono, Localidad localidad,
			List<Compra> listaCompras) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.eMail = eMail;
		this.telefono = telefono;
		this.localidad = localidad;
		this.listaCompras = listaCompras;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene el identificador único del cliente.
	 * 
	 * @return El identificador único del cliente.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Establece el identificador único del cliente.
	 * 
	 * @param id El nuevo identificador único del cliente.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public List<Compra> getListaCompras() {

		return listaCompras;
	}

	public void setListaCompras(List<Compra> listaCompras) {
		this.listaCompras = listaCompras;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "Cliente ID: " + id + ", dni: " + dni + ", nombre: " + nombre + ", correo:" + eMail + ", telefono:"
				+ telefono + ", localidad: " + localidad;
	}

	/**
	 * Compara dos clientes en función de su número de DNI.
	 * 
	 * @param o El otro cliente con el que se va a comparar.
	 * @return Un valor negativo si este cliente tiene un DNI menor, un valor
	 *         positivo si tiene un DNI mayor o cero si ambos tienen el mismo DNI.
	 */
	@Override
	public int compareTo(Cliente o) {
		if (dni < o.getDni())
			return -1;
		else if (dni > o.getDni())
			return 1;
		return 0;
	}

}