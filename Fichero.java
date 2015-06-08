package temperaturaCelsisusFahrenheit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Se encarga de guardar/recuperar la temperatura a/de un fichero
 * 
 * @author MaríaLourdes
 * 
 */
public class Fichero {
	/**
	 * Nombre del fichero
	 */
	private static final String TEMPERATURA_OBJ = "temperatura.obj";

	/**
	 * Guarda en un fichero la temperatura en Celsius
	 * 
	 * @param celsius
	 *            Temperatura en Celsius a guardar
	 * @throws IOException
	 *             Cuando hay un error de Salida
	 */
	static void guardar(double celsius) throws IOException {
		try (DataOutputStream salida = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(TEMPERATURA_OBJ)))) {
			salida.writeDouble(celsius);
		}
	}

	/**
	 * Recupera de un fichero la temperatura en Celsius
	 * 
	 * @return La temperatura en Celsius
	 * @throws IOException
	 *             Cuando hay un error de Entrada
	 */
	static double recuperar() throws IOException {
		try (DataInputStream entrada = new DataInputStream(
				new BufferedInputStream(new FileInputStream(TEMPERATURA_OBJ)))) {
			return entrada.readDouble();
		}
	}
}
