package ciagi61;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ciagi {

	public static void main(String[] args) {
		List<String> sequences = getStringList("src/ciagi61/ciagi.txt");
		List<String> bledne = getStringList("src/ciagi61/bledne.txt");
		/*
		 * System.out.println("Expected: 1,2 Actual: " +
		 * checkIfArythmeticSequence(Arrays.asList(1, 3, 5, 7, 9)));
		 * System.out.println("Expected: 1,5 Actual: " +
		 * checkIfArythmeticSequence(Arrays.asList(17, 22, 27, 32, 37)));
		 * System.out.println("Expected: 0,0 Actual: " +
		 * checkIfArythmeticSequence(Arrays.asList(1, 2, 7, 2, 37)));
		 * System.out.println("Expected: ? Actual: " +
		 * countArythmeticSequences(sequences));
		 */
		/*
		 * System.out .println("Expected: 27 Actual: " +
		 * getBiggest3square(Arrays.asList(27, 8, 4, 8, 5, 3, 6, 68, 564, 3)));
		 * System.out.println("Expected: 1 Actual: " +
		 * getBiggest3square(Arrays.asList(9, 7, 5, 3, 1)));
		 * 
		 * System.out.println("Expected: ? Actual: " + getBiggest3s(sequences));
		 */
		/*
		 * System.out.println("Expected 3 Actual: " +
		 * getDiffrence(Arrays.asList(2,4,7,10,13,16)));
		 * System.out.println("Expected 2 Actual: " +
		 * getDiffrence(Arrays.asList(1,3,5,7,9,10)));
		 */

		/*
		 * System.out.println("Expected: 2 Actual: " +
		 * getError(Arrays.asList(2,4,7,10,13,16)));
		 * System.out.println("Expected: 10 Actual: " +
		 * getError(Arrays.asList(1,3,5,7,9,10)));
		 * System.out.println("Expected: 10 Actual: " +
		 * getError(Arrays.asList(1,3,6,7,9,11)));
		 */

		System.out.println("Expected: ? Actual: " + getErrors(bledne));
	}

	private static List<Integer> getErrors(List<String> input) {
		List<Integer> output = new ArrayList<Integer>();
		for (String sequence : input) {
			List<Integer> sequences = new ArrayList<>();
			String[] temp = sequence.split(" ");

			if (temp.length < 4) {
				continue;
			}
			for (int i = 0; i < temp.length; i++) {
				sequences.add(Integer.parseInt(temp[i]));
			}

			output.add(getIncorrectNum(sequences));
		}
		return output;
	}

	private static Integer getIncorrectNum(List<Integer> sequence) {
		Integer diffrence = getDiffrence(sequence);
		for (int i = 1; i < sequence.size(); i++) {
			Integer current = sequence.get(i);
			Integer previous = sequence.get(i - 1);
			if (current - previous != diffrence) {
				if (i != 1) {
					return current;
				} else {
					return previous;
				}
			}
		}
		return null;
	}

	private static Integer getDiffrence(List<Integer> sequence) {
		if (sequence.get(1) - sequence.get(0) == sequence.get(2) - sequence.get(1)) {
			return sequence.get(1) - sequence.get(0);
		}

		return sequence.get(4) - sequence.get(3);

	}

	/*
	 * private static List<Integer> getBiggest3s(List<String> input) { List<Integer>
	 * squareNumbers = new ArrayList<>(); for (String sequence : input) {
	 * List<Integer> sequences = new ArrayList<>(); String[] temp =
	 * sequence.split(" ");
	 * 
	 * if (temp.length < 4) { continue; }
	 * 
	 * for (int i = 0; i < temp.length; i++) {
	 * sequences.add(Integer.parseInt(temp[i])); } int biggest =
	 * getBiggest3square(sequences); if(biggest != 0) { squareNumbers.add(biggest);
	 * }
	 * 
	 * }
	 * 
	 * return squareNumbers; }
	 * 
	 * private static Integer getBiggest3square(List<Integer> numbers) { Integer
	 * biggestSquare = 0; for (Integer num : numbers) { for (int i = 1; i <= num;
	 * i++) { if (i * i * i == num && num > biggestSquare) { biggestSquare = num; }
	 * } } return biggestSquare; }
	 */
	/*
	 * private static List<List<Integer>> countArythmeticSequences(List<String>
	 * input) { List<List<Integer>> numbers = new ArrayList<>(); Integer topDiff =
	 * 0;
	 * 
	 * for (String sequence : input) { List<Integer> sequences = new ArrayList<>();
	 * String[] temp = sequence.split(" ");
	 * 
	 * if (temp.length < 4) { continue; }
	 * 
	 * for (int i = 0; i < temp.length; i++) {
	 * sequences.add(Integer.parseInt(temp[i])); }
	 * 
	 * List<Integer> isSequence = checkIfArythmeticSequence(sequences);
	 * 
	 * if (isSequence.get(0) == 1) { if (isSequence.get(1) > topDiff) { topDiff =
	 * isSequence.get(1); } numbers.add(sequences); }
	 * 
	 * } numbers.add(Arrays.asList(topDiff)); return numbers; }
	 * 
	 * private static List<Integer> checkIfArythmeticSequence(List<Integer>
	 * sequence) { int diffrence = sequence.get(0) - sequence.get(1); for (int i =
	 * 1; i < sequence.size(); i++) { if (sequence.get(i - 1) - sequence.get(i) !=
	 * diffrence) { return Arrays.asList(0, 0); } } return Arrays.asList(1,
	 * diffrence * -1); }
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
		strings.remove(0);
		return strings;

	}
}
