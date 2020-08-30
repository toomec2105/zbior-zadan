package funkcja71;

import java.util.Arrays;
import java.util.List;

public class Funkcja {

	public static void main(String[] args) {
		System.out.println(countFunction(1.5, 1.14833, -4.63636, 6.44498, -1.95694));
		System.out.println(countMax());
	}

	public static Double countFunction(Double x, Double a, Double b, Double c, Double d) {
		return x * x * x * d + x * x * c + x * b + a;

	}

	public static List<Double> countMax() {
		Double maxValue = 0.00;
		Double maxX = 0.00;
		
		for (int i = 0; i / 500 < 1; i++) {
			
			Double currentX = (double) (4 + 0.001 * i);
			Double currentValue = countFunction(currentX, -307.12440, 197.11005, -40.76555, 2.71770);
			
			if (currentValue > maxValue) {
				maxValue = currentValue;
				maxX = currentX;
			}
		}

		return (List<Double>) Arrays.asList(maxX, maxValue);
	}
}
