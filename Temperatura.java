package temperaturaCelsisusFahrenheit;

public class Temperatura {
	static double aCelsius(double fahrenheit){
		return (fahrenheit -32)/1.8;
	}
	static double aFahrenheit(double celsius){
		return celsius * 1.8 + 32;
	}

}
