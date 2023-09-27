package ar.edu.unju.fi.model;

import java.util.Date;

import ar.edu.unju.fi.util.FormatoLegible;

/**
 * La clase Compra representa una compra realizada por un cliente en el
 * corralón. Cada compra tiene un identificador único, una fecha de compra, un
 * importe y una referencia al cliente que realizó la compra.
 */
public class Compra {

	private Integer id;
	private Date fecha;
	private Double importe;
	private Cliente cliente;
	private static Integer nextId = 1;

	/**
	 * Constructor que crea una nueva compra con un importe específico y asigna
	 * automáticamente un identificador único y la fecha actual.
	 * 
	 * @param importe El importe de la compra.
	 * @param cliente El cliente que realizó la compra.
	 */
	public Compra(Double importe, Cliente cliente) {

		this.id = nextId;
		this.fecha = new Date();
		this.importe = importe;
		this.cliente = cliente;
		nextId++;
	}

	/**
	 * Constructor que crea una nueva compra con un importe específico y asigna
	 * automáticamente un identificador único y la fecha actual. No se asigna el
	 * cliente en este constructor.
	 * 
	 * @param importe El importe de la compra.
	 */
	public Compra(Double importe) {

		this.id = nextId;
		this.fecha = new Date();
		this.importe = importe;
		nextId++;
	}

	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "ID Compra: " + id + ", Fecha: " + FormatoLegible.devolverFechaFormateada(fecha) + ", Importe: "
				+ FormatoLegible.dejarDosDecimales(importe);
	}

}
