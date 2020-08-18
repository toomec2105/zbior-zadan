package fraktalFibbonacciego67;

import java.util.ArrayList;
import java.util.List;

public class fraktalFibbonacciego {
	public static void main(String[] args) {
		List<Integer> fibbonacci = getFibbonacciSequence();
		List<String> binaryFibbonacci = new ArrayList<>();
		for (Integer num : fibbonacci) {
			String binary = "";
			String mainPart = Integer.toBinaryString(num);
			for (int i = 0 + mainPart.length(); i < 27; i++) {
				binary += "0";
			}
			binary += mainPart;

			binaryFibbonacci.add(binary);
		}
		/*
		 * 67.1 System.out.println("F10 = " + fibbonacci.get(9) + " " + "F20 = " +
		 * fibbonacci.get(19) + " " + "F30 = " + fibbonacci.get(29) + " " + "F40 = " +
		 * fibbonacci.get(39) + " ");
		 */
		// 67.2
		// System.out.println("Expected: ??? Actual: " + getPrimeElements(fibbonacci));\

		/*
		 * 67.3 for(int i = 0; i< 39; i++) {
		 * System.out.println(bianryFibbonacci.get(i)); }
		 */
		for (int i = 0; i < binaryFibbonacci.size(); i++) {
			if (countOnes(binaryFibbonacci.get(i)) == 6) {
				System.out.println(binaryFibbonacci.get(i));
			}
		}

	}

	/*
	 * 67.2 private static List<Integer> getPrimeElements(List<Integer> fibbonacci)
	 * { List<Integer> primes = new ArrayList<>();
	 * 
	 * for(Integer num : fibbonacci) { if(getDividers(num) == 1) { primes.add(num);
	 * } }
	 * 
	 * 
	 * return primes; }
	 * 
	 * private static Integer getDividers(Integer num) { List<Integer> dividers =
	 * new ArrayList<>(); for (int i = 2; i <= num; i++) { if (num % i == 0) { num
	 * /= i;
	 * 
	 * dividers.add(i);
	 * 
	 * i--; } }
	 * 
	 * return dividers.size();
	 * 
	 * }
	 */
	public static int countOnes(String str) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				count++;
		}

		return count;
	}

	private static List<Integer> getFibbonacciSequence() {
		List<Integer> fibbonacci = new ArrayList<>();
		fibbonacci.add(1);
		fibbonacci.add(1);

		for (int i = 1; i < 39; i++) {
			fibbonacci.add(fibbonacci.get(i) + fibbonacci.get(i - 1));
		}
		return fibbonacci;

	}
}
