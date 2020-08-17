package trojkiLiczb66;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class trojkiLiczb {

	public static void main(String[] args) {
		List<Integer> nums = getIntegerList("src/trojkiLiczb66/trojki.txt");
		List<List<Integer>> triples = new ArrayList<>();

		for (int i = 0; i < nums.size(); i = i + 3) {
			triples.add(Arrays.asList(nums.get(i), nums.get(i + 1), nums.get(i + 2)));
		}

		/*
		 * 66.1 System.out.println("Expected: true Actual: " +
		 * checkDigitSum(Arrays.asList(12,54,12)));
		 * System.out.println("Expected: ??? Actual: " + checkDigitSums(triples));
		 */

		/*
		 * 66.2 System.out.println("Expected: true, Actual: " +
		 * checkPrimeSum(Arrays.asList(11, 13, 143)));
		 * System.out.println("Expected: ???, Actual: " + checkPrimeSums(triples));
		 */
		
		/* 66.3
		 * System.out.println("Expected: ture, Actual: " +
		 * checkIfSquareTriangle(Arrays.asList(3, 4, 5)));
		 * System.out.println("Expected: ture, Actual: " +
		 * checkIfSquareTriangle(Arrays.asList(12, 13, 5)));
		 * System.out.println("Expected: ???, Actual: " + gettringleTriples(triples));
		 */
		System.out.println("Expected: ??? Actual: " + getTriangleSequenceLength(triples));
	}

	private static List<Integer> getTriangleSequenceLength(List<List<Integer>> triples) {
		List<Integer> output = new ArrayList<>();
		Integer triangleCounter = 0;
		Integer biggestLength = 0;
		Integer currentLength = 0;
		for (int i = 0; i < triples.size(); i++) {
			if(checkIfTriangle(triples.get(i))) {
				currentLength++;
				triangleCounter++;
			}else {
				if(currentLength > biggestLength) {
					biggestLength = currentLength;
				}
				currentLength = 0;
			}
		}
		output.add(triangleCounter);
		output.add(biggestLength);
		return output;
	}

	private static boolean checkIfTriangle(List<Integer> triple) {
		Integer num1 = triple.get(0);
		Integer num2 = triple.get(1);
		Integer num3 = triple.get(2);
		if (num1 + num2 > num3 && num1 + num3 > num2 && num3 + num2 > num1) {
			return true;
		}
		return false;
	}

	/*
	 * 66.3 private static List<List<Integer>> gettringleTriples(List<List<Integer>>
	 * triples) { List<List<Integer>> output = new ArrayList<>(); for(int i = 0; i <
	 * triples.size(); i ++) { if(checkIfSquareTriangle(triples.get(i)) &&
	 * checkIfSquareTriangle(triples.get(i+1))) { output.add(triples.get(i));
	 * output.add(triples.get(i+1)); } } return output; }
	 * 
	 * private static boolean checkIfSquareTriangle(List<Integer> triple) { Integer
	 * num1 = triple.get(0); Integer num2 = triple.get(1); Integer num3 =
	 * triple.get(2); if(num1*num1+num2*num2==num3*num3 || num3*num3+num1*num1 ==
	 * num2*num2 || num3*num3+num2*num2 == num1*num1) { return true; } return false;
	 * }
	 */

	/*
	 * 66.2 private static List<List<Integer>> checkPrimeSums(List<List<Integer>>
	 * triples) { List<List<Integer>> output = new ArrayList<>(); for (List<Integer>
	 * triple : triples) { if (checkPrimeSum(triple)) { output.add(triple); } }
	 * return output; }
	 * 
	 * private static boolean checkPrimeSum(List<Integer> triple) { Integer num1 =
	 * triple.get(0); Integer num2 = triple.get(1); Integer num3 = triple.get(2); if
	 * (num1 * num2 == num3 && getDividers(num1) == 1 && getDividers(num2) == 1) {
	 * return true; }
	 * 
	 * return false; }
	 * 
	 * private static Integer getDividers(Integer num) { List<Integer> dividers =
	 * new ArrayList<>(); for (int i = 2; i <= num; i++) { if (num % i == 0) { num
	 * /= i;
	 * 
	 * dividers.add(i);
	 * 
	 * i--; } }
	 * 
	 * return dividers.size(); }
	 */

	/*
	 * 66.1 private static List<List<Integer>> checkDigitSums(List<List<Integer>>
	 * triples) { List<List<Integer>> output = new ArrayList<>(); for(List<Integer>
	 * triple: triples) { if(checkDigitSum(triple)) { output.add(triple); }
	 * 
	 * } return output; }
	 * 
	 * private static boolean checkDigitSum(List<Integer> triple) { String num1 =
	 * triple.get(0).toString(); String num2 = triple.get(1).toString(); Integer
	 * num3 = triple.get(2); List<String> num1Digits =
	 * Arrays.asList(num1.split("")); List<String> num2Digits =
	 * Arrays.asList(num2.split("")); Integer sum = 0;
	 * 
	 * for(String digit1: num1Digits) { sum += Integer.parseInt(digit1); }
	 * for(String digit2: num2Digits) { sum += Integer.parseInt(digit2); }
	 * 
	 * if(sum == num3) { return true; } return false; }
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
			List<String> stringNums = Arrays.asList(stringNum.split(" "));
			for (String num : stringNums) {
				nums.add(Integer.parseInt(num));
			}
		}
		return nums;
	}
}
