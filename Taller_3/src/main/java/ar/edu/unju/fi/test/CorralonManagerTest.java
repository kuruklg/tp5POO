package ar.edu.unju.fi.test;

import ar.edu.unju.fi.exceptions.ManagerException;
import ar.edu.unju.fi.manager.Corralon;
import ar.edu.unju.fi.model.Cliente;
import ar.edu.unju.fi.model.ClienteCuentaCorriente;
import ar.edu.unju.fi.model.ClienteGrandesCompra;
import ar.edu.unju.fi.model.Compra;
import ar.edu.unju.fi.model.Localidad;
import ar.edu.unju.fi.util.FormatoLegible;

/**
 * CorralonManagerTest es una clase que realiza pruebas del funcionamiento del
 * sistema de gestión de un corralón. Se crean instancias de clientes, compras y
 * se registran clientes en el corralón. Además, se realizan operaciones como
 * mostrar la lista de clientes, listar las compras de un cliente y calcular el
 * importe total recaudado por localidad.
 */
public class CorralonManagerTest {

	// private static Corralon corralon = new Corralon();
	public static void main(String[] args) {

		Corralon corralon = new Corralon();

		// localidades
		Localidad localidad1 = new Localidad("San Salvador", 4600);
		Localidad localidad2 = new Localidad("Palpala", 4612);
		Localidad localidad3 = new Localidad("Santa Barbara", 4513);

		// compras
		Compra compra1 = new Compra(9000.0);
		Compra compra2 = new Compra(70000.0);
		Compra compra3 = new Compra(3000.0);
		Compra compra4 = new Compra(4000.0);
		Compra compra5 = new Compra(20000.0);
		Compra compra6 = new Compra(2000.0);

		// clientes
		Cliente cliente1 = new ClienteCuentaCorriente(36197055, "Martiarena, Alba", "malba@gmail.com",
				FormatoLegible.generarTelefono(), localidad2);
		Cliente cliente2 = new ClienteCuentaCorriente(7021642, "Ibaniez, Yanina", "yaniez@gmail.com",
				FormatoLegible.generarTelefono(), localidad2);
		Cliente cliente3 = new ClienteCuentaCorriente(1264192, "Jerez, Jose", "jose1456@gmail.com",
				FormatoLegible.generarTelefono(), localidad1);
		Cliente cliente4 = new ClienteCuentaCorriente(32132, "Flores, Carlos", "Carlin5@gmail.com",
				FormatoLegible.generarTelefono(), localidad1);
		Cliente cliente5 = new ClienteGrandesCompra(36197055, "Apaza, Eduardo", "AEd546@gmail.com",
				FormatoLegible.generarTelefono(), localidad3);

		System.out.println("Registro de Clientes validando DNI y EMAIL:");
		try {
			cliente1.addCompra(compra1);
			cliente1.addCompra(compra2);
			cliente1.addCompra(compra3);
			cliente2.addCompra(compra4);
			cliente5.addCompra(compra5);
			cliente2.addCompra(compra6);

			corralon.registrarCliente(cliente1);
			corralon.registrarCliente(cliente2);
			corralon.registrarCliente(cliente3);
			corralon.registrarCliente(cliente4);
			corralon.registrarCliente(cliente5);
		} catch (ManagerException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Clientes");
		corralon.listarClientes();

		System.out.println("Compras por Cliente:");
		cliente2.mostrarCompras();

		System.out.println("Importe recaudado por localidad");
		System.out.println("Total recaudado de " + localidad1.getNombre() + " es: "
				+ corralon.mostrarTotalComprasLocalidad(localidad2));
	}
}