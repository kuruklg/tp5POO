package ar.edu.unju.fi.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ar.edu.unju.fi.exceptions.ManagerException;
import ar.edu.unju.fi.model.Cliente;
import ar.edu.unju.fi.model.Compra;
import ar.edu.unju.fi.model.Localidad;

/**
 * La clase Corralon representa la gestión de clientes y compras en un corralón
 * de materiales de construcción. Permite registrar clientes, validar duplicados
 * por DNI o correo electrónico, calcular el total de compras realizadas en una
 * localidad y listar los clientes registrados.
 */
public class Corralon {

	public static Logger logger = Logger.getLogger(Corralon.class);
	private static List<Cliente> listaClientes = new ArrayList<Cliente>();

	/**
	 * Registra un nuevo cliente en el corralón, verificando que no exista un
	 * cliente con el mismo DNI o correo electrónico.
	 * 
	 * @param cliente El cliente a registrar.
	 * @throws ManagerException Si ya existe un cliente con el mismo DNI o correo
	 *                          electrónico.
	 */
	public void registrarCliente(Cliente cliente) throws ManagerException {
		if (!validarCliente(cliente)) {
			listaClientes.add(cliente);
		} else {
			throw new ManagerException("Cliente con el mismo DNI o correo electronico ya existe.");
		}
	}

	/**
	 * Valida si un cliente ya existe en la lista de clientes del corralón,
	 * comprobando su DNI o correo electrónico.
	 * 
	 * @param cliente El cliente a validar.
	 * @return `true` si el cliente ya existe, `false` si no existe.
	 */
	public boolean validarCliente(Cliente cliente) {
		for (Cliente listado : listaClientes) {
			if (listado.getDni().equals(cliente.getDni()) || listado.geteMail().equals(cliente.geteMail())) {
				return true; // El cliente ya existe
			}
		}
		return false; // El cliente no existe
	}

	/**
	 * Calcula el importe total de las compras realizadas por los clientes en una
	 * localidad específica.
	 * 
	 * @param localidad La localidad de la cual se desea calcular el total de
	 *                  compras.
	 * @return El importe total de las compras realizadas en la localidad.
	 */
	public double mostrarTotalComprasLocalidad(Localidad localidad) {
		Double importeTotal = 0.0;
		for (Cliente listado : listaClientes) {
			if (listado.getLocalidad().getNombre().equals(localidad.getNombre())) {
				importeTotal = importeTotal + obtenerTotal(listado);
			}
		}
		return importeTotal;
	}

	/**
	 * Calcula el importe total de las compras realizadas por un cliente.
	 * 
	 * @param cliente El cliente del cual se desea calcular el importe total de
	 *                compras.
	 * @return El importe total de las compras realizadas por el cliente.
	 */
	public Double obtenerTotal(Cliente cliente) {
		Double total = 0.0;
		for (Compra listado : cliente.getListaCompras()) {
			total = total + listado.getImporte();
		}
		return total;
	}

	/**
	 * Lista todos los clientes registrados en el corralón.
	 */
	public void listarClientes() {
		for (Cliente cliente : listaClientes) {
			System.out.println(cliente);
		}
	}

	/**
	 * Obtiene la lista de clientes registrados en el corralón.
	 * 
	 * @return La lista de clientes registrados.
	 */
	public List<Cliente> getListaClientes() {
		logger.info("Devolviendo lista de clientes");
		return listaClientes;
	}
}