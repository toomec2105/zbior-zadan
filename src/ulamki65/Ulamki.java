package ulamki65;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ulamki {
	public static void main(String[] args) {
		List<String> pairs = getStringList("src/ulamki65/dane_ulamki.txt");
		List<Double> ulamki = new ArrayList<>();

		for (String pair : pairs) {
			String[] nums = pair.split(" ");
			ulamki.add(Double.parseDouble(nums[0]));
			ulamki.add(Double.parseDouble(nums[1]));
		}
		// 65.1
		// System.out.println("Expected: 2 4 Actual: "
		// + getSmallestFraction(Arrays.asList(3.00, 6.00, 2.00, 3.00, 5.00, 3.00, 2.00,
		// 4.00, 15.00, 5.00)));
		// System.out.println("Expected: ?? Actual: " + getSmallestFraction(ulamki));

		// 65.2

		/*
		 * System.out.println("Expected: 2 Actual: " + countDivivders(8.00, 4.00));
		 * System.out.println("Expected: 1 Actual: " + countDivivders(3.00, 9.00));
		 * System.out.println("Expected: 0 Actual: " + countDivivders(2.00, 21.00));
		 * 
		 * System.out.println("Expected: 2 Actual: " +
		 * countShortFractions(Arrays.asList(3.00, 6.00, 2.00, 3.00, 5.00, 3.00, 2.00,
		 * 4.00, 15.00, 5.00))); System.out.println("Expected: ? Actual: " +
		 * countShortFractions(ulamki));
		 */

		// 65.3
		/*
		 * System.out.println("Expected: 3,1 Actual: " + getShortestFraction(15, 5));
		 * System.out.println("Expected: 9,16 Actual: " + getShortestFraction(18, 32));
		 * System.out.println("Expected: 7,3 Actual: " + getShortestFraction(7, 3));
		 * System.out.println("Expected: 1,1 Actual: " + getShortestFraction(5, 5));
		 * 
		 * System.out.println("Expected: 10 Actual: " +
		 * sumNumerators(Arrays.asList(2.00, 4.00, 5.00, 3.00, 4.00, 7.00))); System.out
		 * .println("Expected: 17 Actual: " + sumNumerators(Arrays.asList(8.00, 4.00,
		 * 6.00, 1.00, 99.00, 11.00)));
		 * 
		 * System.out.println("Expected: ? Actual: " + sumNumerators(ulamki));
		 */

	}

	private static Double sumNumerators(List<Double> fractions) {
		Double sum = 0.00;
		for (int i = 0; i < fractions.size(); i = i + 2) {
			sum += getShortestFraction(fractions.get(i), fractions.get(i + 1)).get(0);
		}
		return sum;
	}

	private static List<Double> getShortestFraction(double i, double j) {
		for (int k = 2; k <= i; k++) {
			if (i % k == 0 && j % k == 0) {
				i /= k;
				j /= k;
				k--;
			}
		}

		return Arrays.asList(i, j);
	}

	private static Integer countDivivders(Double num1, Double num2) {
		List<Double> dividers1 = getDividers(num1);
		List<Double> dividers2 = getDividers(num2);
		Integer counter = 0;
		for (Double divider1 : dividers1) {
			for (Double divider2 : dividers2) {
				if (divider1.equals(divider2)) {
					counter++;
				}
			}
		}

		return counter - 1;

	}

	/*
	 * private static Integer countShortFractions(List<Double> fractions) { Integer
	 * counter = 0; for (int i = 0; i < fractions.size(); i = i + 2) { if
	 * (countDivivders(fractions.get(i), fractions.get(i + 1)) == 0) { counter++; }
	 * }
	 * 
	 * return counter; }
	 */

	private static List<Double> getDividers(Double num) {
		List<Double> dividers = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				dividers.add((double) i);
			}
		}
		return dividers;
	}

	// 65.1
	/*
	 * private static List<Double> getSmallestFraction(List<Double> numbers) {
	 * List<Double> smallest = new ArrayList<>(); smallest.add(1.00);
	 * smallest.add(1.00); for (int i = 0; i < numbers.size(); i = i + 2) { if
	 * (smallest.get(0) / smallest.get(1) > numbers.get(i) / numbers.get(i + 1)) {
	 * smallest.clear(); smallest.add(numbers.get(i)); smallest.add(numbers.get(i +
	 * 1)); } else if (smallest.get(0) / smallest.get(1) == numbers.get(i) /
	 * numbers.get(i + 1)) { smallest.add(numbers.get(i));
	 * smallest.add(numbers.get(i + 1)); } }
	 * 
	 * return smallest; }
	 */

	private static List<Integer> getIntegerList(String path) {
		List<String> strings = new ArrayList<String>();
		try {
			strings = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> nums = new ArrayList<>();
		for (String stringNum : strings) {
			nums.add(Integer.parseInt(stringNum));
		}
		return nums;
	}

	private static List<String> getStringList(String path) {
		List<String> strings = new ArrayList<>();
		try {
			strings = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strings;

	}
}
