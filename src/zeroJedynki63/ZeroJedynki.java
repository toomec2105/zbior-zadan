package zeroJedynki63;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroJedynki {

	public static void main(String[] args) {
		List<String> ciagiStr = getStringList("src/zeroJedynki63/ciagi.txt");
		List<Long> ciagiLong = getLongList("src/zeroJedynki63/ciagi.txt");

		// 63.1
		/*
		 * System.out.println("Expected: 11 Actual: " +
		 * getDoubleSequences(Arrays.asList("11", "101010", "110010")));
		 * System.out.println("Expected: 01010101 Actual: " +
		 * getDoubleSequences(Arrays.asList("101", "01010101", "111110")));
		 * System.out.println("Expected: ??? Actual: " + getDoubleSequences(ciagiStr));
		 */

		/*
		 * System.out.println("Expected true Actual: " +
		 * checkIfDoubleSequence("101101"));
		 * System.out.println("Expected false Actual: " +
		 * checkIfDoubleSequence("10101")); System.out.println("Expected true Actual: "
		 * + checkIfDoubleSequence("11"));
		 */
		// 63.2
		/*
		 * System.out.println("Expected: true Actual: " + checkNeighbours("10101011"));
		 * System.out.println("Expected: false Actual: " + checkNeighbours("101"));
		 */
		/*
		 * System.out.println("Expected: 2 Actual: " +
		 * getSequenceWithoutNeighbours(Arrays.asList("1011","10010001","110101",
		 * "101010101010"))); System.out.println("Expected: ?? Actual: " +
		 * getSequenceWithoutNeighbours(ciagiStr));
		 */
		// 63.3
		/*
		 * System.out.println("Expected: 2 Actual: " + getDividers(34));
		 * System.out.println("Expected: 2 Actual: " + getDividers(841));
		 * System.out.println("Expected: 2 Actual: " + getDividers(614546));
		 * System.out.println("Expected: 1 Actual: " + getDividers(101));
		 */

		System.out.println("Expected: 34 Actual : " + convertToDecimal(100010L));
		System.out.println("Expected: 1023 Actual : " + convertToDecimal(1111111111L));
		
		System.out.println("Expected: ? Actual: " + getHalfPrimeNumbers(ciagiLong));
	}

	private static Integer convertToDecimal(Long num) {
		Long decimal = 0L;
		int length = num.toString().length();

		for (int i = 0; i < length; i++) {

			decimal += (long) ((Math.pow(2, i) * (num % (Math.pow(10, (i + 1))))) / Math.pow(10, i));
			num -= (long) (num % Math.pow(10, (i + 1)));
		}
		return Integer.parseInt(decimal.toString());
	}

	private static List<Long> getHalfPrimeNumbers(List<Long> ciagiLong) {
		Long biggest = ciagiLong.get(0);
		Long smallest = ciagiLong.get(0);
		Long counter = 0L;
		List<Long> output = new ArrayList<>();

		for (Long num : ciagiLong) {
			if (getDividers(convertToDecimal(num)) == 2) {
				counter++;
				if (num > biggest) {
					biggest = num;
				}
				if (num < smallest) {
					smallest = num;
				}
			}
		}
		
		output.add(counter);
		output.add((long)convertToDecimal(biggest));
		output.add((long)convertToDecimal(smallest));
		return output;
	}

	// ============================================================== private
	private static Integer getDividers(Integer num) {
		List<Integer> dividers = new ArrayList<>();
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				num /= i;

				dividers.add(i);

				i--;
			}
		}

		return dividers.size();
	}

	private static Integer getSequenceWithoutNeighbours(List<String> numbers) {
		Integer counter = 0;
		for (String num : numbers) {
			if (!checkNeighbours(num)) {
				counter++;
			}
		}
		return counter;
	}

	private static boolean checkNeighbours(String num) {
		if (num.contains("11")) {
			return true;
		}
		return false;
	}
	/*
	 * // 63.1 private static boolean checkIfDoubleSequence(String num) { if
	 * (num.length() % 2 == 1) { return false; } String part1 = ""; String part2 =
	 * ""; part1 = num.substring(0, (num.length() / 2)); part2 =
	 * num.substring((num.length() / 2)); if(part1.equals(part2)) { return true; }
	 * return false; }
	 * 
	 * 
	 * private static List<String> getDoubleSequences(List<String> numbers) {
	 * List<String> output = new ArrayList<>(); for(String num : numbers) {
	 * if(checkIfDoubleSequence(num)) { output.add(num); } } return output; }
	 */

	private static List<Long> getLongList(String path) {
		List<String> strings = new ArrayList<String>();
		try {
			strings = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Long> nums = new ArrayList<>();
		for (String stringNum : strings) {
			nums.add(Long.parseLong(stringNum));
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
		strings.remove(0); // be aware of this line !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return strings;

	}
}
