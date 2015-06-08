package temperaturaCelsisusFahrenheit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fichero {
	private static final String TEMPERATURA_OBJ = "temperatura.obj";

	static void guardar(double celsius) throws IOException {
		try (DataOutputStream salida = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(TEMPERATURA_OBJ)))) {
			salida.writeDouble(celsius);
		}
	}

	static double recuperar() throws IOException {
		try (DataInputStream entrada = new DataInputStream(
				new BufferedInputStream(new FileInputStream(TEMPERATURA_OBJ)))) {
			return entrada.readDouble();
		}
	}
}
