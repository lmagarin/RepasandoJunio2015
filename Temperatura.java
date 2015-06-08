package temperaturaCelsisusFahrenheit;

/**
 * Realiza la conversi�n de temperaturas entre Celsius y Fahrenheit
 * 
 * @author Mar�aLourdes
 * 
 */
public class Temperatura {
	/**
	 * Convierte temperatura Fahrenheit a Celsius
	 * 
	 * @param fahrenheit
	 *            Temperatura en Fahrenheit
	 * @return Temperatura en Celsius
	 */
	static double aCelsius(double fahrenheit) {
		return (fahrenheit - 32) / 1.8;
	}

	/**
	 * Convierte temperatura Celsius a Fahrenheit
	 * 
	 * @param celsius
	 *            Temperatura en Celsius
	 * @return Temperatura en Fahrenheit
	 */
	static double aFahrenheit(double celsius) {
		return celsius * 1.8 + 32;
	}

}
