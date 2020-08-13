package ciekaweLiczby59;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CiekaweLiczby {
	public static void main(String[] args) {
		List<String> stringNums = getStringList("src/ciekaweLiczby59/liczby.txt");
		List<Integer> nums = getIntegerList("src/ciekaweLiczby59/liczby.txt");

		/*
		 * System.out.println("Expected: 3, 5, 11 Actual: " + getDividers(165));
		 * System.out.println("Expected: 3, 11 Actual: " + getDividers(99));
		 * System.out.println("Expected: 2, 3, 11 Actual: " + getDividers(198));
		 * 
		 * 
		 * System.out.println("Expected: 1, Actual: " +
		 * getNumbersWith3OddDividers(Arrays.asList(new Integer[] { 11, 105, 21, 1331
		 * }))); System.out.println("Expected: 2, Actual: " +
		 * getNumbersWith3OddDividers(Arrays.asList(new Integer[] { 27, 165, 99, 495
		 * }))); System.out.println("Expected: 1, Actual: " +
		 * getNumbersWith3OddDividers(Arrays.asList(new Integer[] { 429, 255255, 3465,
		 * 210 })));
		 */
		// System.out.println("Expected: ?, Actual: " +
		// getNumbersWith3OddDividers(nums));

		/*
		 * System.out.println("Expected: 1, Actual: " +
		 * checkPalindromSum(Arrays.asList(new String[] { "54", "19" })));
		 * System.out.println("Expected: ??, Actual: " + checkPalindromSum(stringNums));
		 * 
		 * 
		 * System.out.println("Expected: 554, Actual: " + getReversedStringNum("455"));
		 * System.out.println("Expected: 784532554, Actual: " +
		 * getReversedStringNum("455235487"));
		 */
		/*
		 * System.out.println("Expected: 1 Actual: " + getForce("1111"));
		 * System.out.println("Expected: 2 Actual: " + getForce("28"));
		 * System.out.println("Expected: 4 Actual: " + getForce("678"));
		 * System.out.println("Expected: 2 Actual: " + getForce("1991"));
		 */

		/*
		 * System.out.println("Expected: 1 Actual: " +
		 * getNoOfNumsWithForce(Arrays.asList("12", "56"), 1));
		 * System.out.println("Expected: 2 Actual: " +
		 * getNoOfNumsWithForce(Arrays.asList("25", "14", "56"), 2));
		 */
		System.out.println("Expected: ? Actual numbers with force 1 : " + getNoOfNumsWithForce(stringNums, 1));
		System.out.println("Expected: ? Actual numbers with force 2 : " + getNoOfNumsWithForce(stringNums, 2));
		System.out.println("Expected: ? Actual numbers with force 3 : " + getNoOfNumsWithForce(stringNums, 3));
		System.out.println("Expected: ? Actual numbers with force 4 : " + getNoOfNumsWithForce(stringNums, 4));
		System.out.println("Expected: ? Actual numbers with force 5 : " + getNoOfNumsWithForce(stringNums, 5));
		System.out.println("Expected: ? Actual numbers with force 6 : " + getNoOfNumsWithForce(stringNums, 6));
		System.out.println("Expected: ? Actual numbers with force 7 : " + getNoOfNumsWithForce(stringNums, 7));
		System.out.println("Expected: ? Actual numbers with force 8 : " + getNoOfNumsWithForce(stringNums, 8));
		/*
		 * System.out.println("Expected: 24 14 Actual: " +
		 * getMaxMinForForce1(Arrays.asList("25", "14", "56", "24"))[0] + " " +
		 * getMaxMinForForce1(Arrays.asList("25", "14", "56", "24"))[1]);
		 */
		System.out.println(
				"Expected: ? Actual: " + getMaxMinForForce1(stringNums)[0] + " " + getMaxMinForForce1(stringNums)[1]);
	}
	// -------------------------59.2-------------------------------
	/*
	 * private static Long checkPalindromSum(List<String> nums) { Long counter =
	 * (long) 0; Long sum = (long) 0; for (String stringNum : nums) { sum =
	 * getReversedStringNum(stringNum) + Long.parseLong(stringNum);
	 * 
	 * if (sum.equals(getReversedStringNum(String.valueOf(sum)))) { counter++; } }
	 * return counter; }
	 * 
	 * private static Long getReversedStringNum(String stringNum) { String reversed
	 * = ""; for (int i = 0; i < stringNum.length(); i++) { reversed +=
	 * stringNum.substring(stringNum.length() - i - 1, stringNum.length() - i); }
	 * 
	 * return Long.parseLong(reversed); }
	 */

//-------------------------59.1-------------------------------
	/*
	 * private static int getNumbersWith3OddDividers(List<Integer> nums) {
	 * List<List<Integer>> allDividers = new ArrayList<>(); int counter = 0; for
	 * (Integer num : nums) { allDividers.add(getDividers(num)); } for
	 * (List<Integer> dividers : allDividers) { if (dividers.size() == 3 &&
	 * dividers.get(0) != dividers.get(1) && dividers.get(1) != dividers.get(2) &&
	 * dividers.get(0) % 2 == 1 && dividers.get(1) % 2 == 1 && dividers.get(2) % 2
	 * == 1) { counter++; } }
	 * 
	 * return counter; }
	 * 
	 * //============================================================== private
	 * static List<Integer> getDividers(Integer num) { List<Integer> dividers = new
	 * ArrayList<>(); for (int i = 2; i <= num; i++) { if (num % i == 0) { num /= i;
	 * if(!dividers.contains(i)) { dividers.add(i); } i--; } }
	 * 
	 * return dividers; }
	 */

	private static Long[] getMaxMinForForce1(List<String> nums) {
		Long[] maxMin = { (long) 0, (long) 10000000 };
		for (String num : nums) {
			if (getForce(num) != 1) {
				continue;
			}
			if (Integer.parseInt(num) < maxMin[1]) {
				maxMin[1] = Long.parseLong(num);
			}
			if (Integer.parseInt(num) > maxMin[0]) {
				maxMin[0] = Long.parseLong(num);
			}
		}
		return maxMin;
	}

	private static Integer getNoOfNumsWithForce(List<String> nums, int force) {
		int counter = 0;

		for (String num : nums) {
			if (getForce(num) == force) {

				counter++;
			}
		}
		return counter;
	}

	private static Integer getForce(String num) {

		for (int i = 1; i < 9; i++) {
			Integer force = 1;
			for (int j = 0; j < num.length(); j++) {
				force *= Integer.parseInt(((Character) num.charAt(j)).toString());
			}
			if (force.toString().length() == 1) {
				return i;
			} else {
				num = force.toString();
			}

		}
		return null;
	}

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
