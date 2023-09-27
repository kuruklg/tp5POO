package ar.edu.unju.fi.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatoLegible {

	public static Integer generarTelefono() {

		return (int) (Math.random() * 10000000 + 4000000);
	}

	public static Double generarImporteAleatorio() {

		return (Math.random() * 500000);
	}

	/**
	 * Deja s�lo los dos primeros decimales de un n�mero
	 * 
	 * @param algo
	 * @return
	 */
	public static String dejarDosDecimales(double algo) {
		String formateado = "";
		DecimalFormat df = new DecimalFormat("#.00");
		formateado = "$" + df.format(algo);
		return formateado;
	}

	/**
	 * Devuelve una fecha con formato dd/MM/yyyy
	 * 
	 * @param fecha
	 * @return
	 */
	public static String devolverFechaFormateada(Date fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		if (fecha != null) {
			return formato.format(fecha);
		} else {
			return null;
		}
	}

}
