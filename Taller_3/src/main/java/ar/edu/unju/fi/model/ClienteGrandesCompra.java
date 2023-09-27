package ar.edu.unju.fi.model;

/**
 * La clase ClienteGrandesCompra representa a un cliente del corralón que
 * realiza grandes compras y recibe un descuento del 10% en cada compra.
 * 
 * Hereda de la clase abstracta Cliente y, por lo tanto, tiene propiedades y
 * comportamientos comunes a todos los clientes, como su número de DNI, nombre,
 * dirección de correo electrónico, teléfono, localidad y una lista de compras
 * realizadas.
 * 
 * Además, esta clase implementa un descuento del 10% en cada compra realizada
 * por los clientes de grandes compras.
 */
public class ClienteGrandesCompra extends Cliente {

	// Descuento del 10% por cada compra del cliente
	private static final Double DESCUENTO = 0.1;

	public ClienteGrandesCompra() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que crea un nuevo cliente de grandes compras con la información
	 * básica.
	 * 
	 * @param dni       Número de DNI del cliente.
	 * @param nombre    Nombre del cliente.
	 * @param eMail     Dirección de correo electrónico del cliente.
	 * @param telefono  Número de teléfono del cliente.
	 * @param localidad Localidad donde reside el cliente.
	 */
	public ClienteGrandesCompra(Integer dni, String nombre, String eMail, Integer telefono, Localidad localidad) {
		super(dni, nombre, eMail, telefono, localidad);
	}

	/**
	 * Modifica el importe de la compra para aplicar un descuento del 10% y luego
	 * agrega la compra a la lista de compras del cliente de grandes compras.
	 * 
	 * @param compra La compra que se va a agregar.
	 */
	@Override
	public void addCompra(Compra compra) {
		compra.setImporte(compra.getImporte() - (compra.getImporte() * DESCUENTO));
		getListaCompras().add(compra);
	}

	/**
	 * Muestra las compras realizadas por el cliente de grandes compras con el
	 * descuento aplicado.
	 */
	@Override
	public void mostrarCompras() {
		System.out.println("Compras de Clientes con Grandes Compras. Descuento %10. ID " + getId());
		for (Compra o : listaCompras) {
			System.out.println(o);
		}
	}
}