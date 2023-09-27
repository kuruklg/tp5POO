package ar.edu.unju.fi.model;

/**
 * La clase ClienteCuentaCorriente representa a un cliente del corralón que
 * posee una cuenta corriente. Estos clientes pueden realizar compras hasta un
 * límite de dinero definido.
 * 
 * Hereda de la clase abstracta Cliente y, por lo tanto, tiene propiedades y
 * comportamientos comunes a todos los clientes, como su número de DNI, nombre,
 * dirección de correo electrónico, teléfono, localidad y una lista de compras
 * realizadas.
 * 
 * Además, esta clase define un límite de dinero para las compras que los
 * clientes de cuenta corriente pueden realizar.
 */
public class ClienteCuentaCorriente extends Cliente {

	// Límite de dinero para las compras de clientes de cuenta corriente
	private static final Double LIMITE_DINERO = 10000.0;

	/**
	 * Constructor que crea un nuevo cliente de cuenta corriente con la información
	 * básica.
	 * 
	 * @param dni       Número de DNI del cliente.
	 * @param nombre    Nombre del cliente.
	 * @param eMail     Dirección de correo electrónico del cliente.
	 * @param telefono  Número de teléfono del cliente.
	 * @param localidad Localidad donde reside el cliente.
	 */
	public ClienteCuentaCorriente(Integer dni, String nombre, String eMail, Integer telefono, Localidad localidad) {
		super(dni, nombre, eMail, telefono, localidad);
		// TODO Auto-generated constructor stub
	}

	public ClienteCuentaCorriente() {
		// TODO Auto-generated constructor stub
	}

	public static Double getLimiteDinero() {
		return LIMITE_DINERO;
	}

	/**
	 * Agrega una compra a la lista de compras del cliente de cuenta corriente si la
	 * compra no supera el límite de dinero.
	 * 
	 * @param compra La compra que se va a agregar.
	 */
	@Override
	public void addCompra(Compra compra) {
		if (validarLimiteDeCompra(compra)) {
			getListaCompras().add(compra);
		}

	}

	/**
	 * Valida si una compra no supera el límite de dinero permitido.
	 * 
	 * @param compra La compra que se va a validar.
	 * @return true si la compra no supera el límite, false en caso contrario.
	 */
	public boolean validarLimiteDeCompra(Compra compra) {

		return (compra.getImporte() < LIMITE_DINERO);
	}

	/**
	 * Muestra las compras realizadas por el cliente de cuenta corriente.
	 */
	@Override
	public void mostrarCompras() {
		System.out.println("Compras de Clientes con Cuenta Corriente ID: " + getId());
		for (Compra o : listaCompras) {
			System.out.println(o);
		}
	}
}