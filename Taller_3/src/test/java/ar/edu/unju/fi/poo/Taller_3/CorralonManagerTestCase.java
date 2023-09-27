package ar.edu.unju.fi.poo.Taller_3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ar.edu.unju.fi.manager.Corralon;
import ar.edu.unju.fi.model.Cliente;
import ar.edu.unju.fi.model.ClienteCuentaCorriente;
import ar.edu.unju.fi.model.ClienteGrandesCompra;
import ar.edu.unju.fi.model.Compra;
import ar.edu.unju.fi.model.Localidad;
import ar.edu.unju.fi.util.FormatoLegible;

/**
 * CorralonManagerTestCase es una clase de prueba que verifica el funcionamiento
 * de la clase Corralon y sus métodos. Se realizan pruebas relacionadas con la
 * gestión de clientes, registros de compras y cálculos de importes.
 */
@DisplayName("Manager de Corralon")
public class CorralonManagerTestCase {

	static Corralon target;
	static Cliente cliente1;
	static Cliente cliente2;
	static Cliente cliente3;
	static Cliente cliente4;
	static Cliente cliente5;
	static Compra compra1;
	static Compra compra2;
	static Compra compra3;
	static Compra compra4;
	static Compra compra5;
	static Compra compra6;
	static Localidad localidad1;
	static Localidad localidad2;
	static Localidad localidad3;

	/**
	 * Configura el entorno de pruebas antes de ejecutar todas las pruebas en la
	 * clase. Aquí se inicializan las instancias necesarias y se realizan
	 * configuraciones previas.
	 * 
	 * @throws Exception Si ocurre algún error durante la configuración.
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	/**
	 * Realiza tareas de limpieza después de ejecutar todas las pruebas en la clase.
	 * 
	 * @throws Exception Si ocurre algún error durante la limpieza.
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	/**
	 * Configura el entorno de pruebas antes de ejecutar cada prueba individual.
	 * Aquí se inicializan las instancias necesarias para cada prueba.
	 * 
	 * @throws Exception Si ocurre algún error durante la configuración.
	 */
	@BeforeEach
	void setUp() throws Exception {
		target = new Corralon();

		localidad1 = new Localidad("San Salvador", 4600);
		localidad2 = new Localidad("Palpala", 4612);
		localidad3 = new Localidad("Santa Barbara", 4513);

		compra1 = new Compra(9000.0);
		compra2 = new Compra(70000.0);
		compra3 = new Compra(3000.0);
		compra4 = new Compra(4000.0);
		compra5 = new Compra(20000.0);
		compra6 = new Compra(2000.0);

		cliente1 = new ClienteCuentaCorriente(36197055, "Martiarena, Alba", "malba@gmail.com",
				FormatoLegible.generarTelefono(), localidad2);
		cliente2 = new ClienteCuentaCorriente(7021642, "Ibaniez, Yanina", "yaniez@gmail.com",
				FormatoLegible.generarTelefono(), localidad2);
		cliente3 = new ClienteCuentaCorriente(1264192, "Jerez, Jose", "jose1456@gmail.com",
				FormatoLegible.generarTelefono(), localidad1);
		cliente4 = new ClienteCuentaCorriente(32132, "Flores, Carlos", "Carlin5@gmail.com",
				FormatoLegible.generarTelefono(), localidad1);
		cliente5 = new ClienteGrandesCompra(36197158, "Apaza, Eduardo", "AEd546@gmail.com",
				FormatoLegible.generarTelefono(), localidad3);
	}

	/**
	 * Realiza tareas de limpieza después de ejecutar cada prueba individual.
	 * 
	 * @throws Exception Si ocurre algún error durante la limpieza.
	 */
	@AfterEach
	void tearDown() throws Exception {
		// System.out.println("Limpiando variables....");
	}

	/**
	 * Prueba la funcionalidad de agregar un cliente al Corralon. Se verifica que el
	 * cliente se registre correctamente y que la lista de clientes aumente en
	 * tamaño.
	 */
	@Test
	@DisplayName("Agregar cliente")
	void addCliente() {
		cliente1.addCompra(compra1);
		cliente1.addCompra(compra2);
		cliente1.addCompra(compra3);
		cliente2.addCompra(compra4);
		cliente5.addCompra(compra5);
		cliente2.addCompra(compra6);

		target.registrarCliente(cliente1);
		assertTrue(target.getListaClientes().size() == 1);
		target.registrarCliente(cliente2);
		assertTrue(target.getListaClientes().size() == 2);
		target.registrarCliente(cliente3);
		assertTrue(target.getListaClientes().size() == 3);
		target.registrarCliente(cliente4);
		assertTrue(target.getListaClientes().size() == 4);
		target.registrarCliente(cliente5);
		assertTrue(target.getListaClientes().size() == 5);
	}
}