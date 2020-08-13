package dzielniki60;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dzielniki {
	public static void main(String[] args) {
		List<Integer> nums = getIntegerList("src/dzielniki60/dzielniki.txt");
		List<String> stringNums = getStringList("src/dzielniki60/dzielniki.txt");

		/*
		 * System.out.println( "Expected: 2,4,764 Actual:" +
		 * numbersSmallerThan1000(Arrays.asList(764, 7777, 43423, 67876, 4, 2445)));
		 * System.out.println( "Expected: 4,1,35 Actual:" +
		 * numbersSmallerThan1000(Arrays.asList(1, 3567, 456, 97542, 35, 999)));
		 * System.out.println("Expected: ? Actual:" + numbersSmallerThan1000(nums));
		 */
		/*
		 * System.out.println("Expected: 1,2,3,6 Actual:" + getDividers(6));
		 * System.out.println("Expected: ? Actual:" + get18Dividers(nums) );
		 */
		/*
		 * System.out.println("Expected 13 Actual: " +
		 * getPrimeNumber(Arrays.asList(3,15,7,13)));
		 * System.out.println("Expected 13 Actual: " + getPrimeNumber(nums));
		 */
	}

	/*
	 * private static int getPrimeNumber(List<Integer> numbers) { List<Integer>
	 * notPrimeNumbers = new ArrayList<Integer>(); List<Integer> dividers = new
	 * ArrayList<Integer>(); int biggestPrime = 0; for(Integer num : numbers) {
	 * for(int i = 2; i <= num; i++) { if(num % i == 0) { if(dividers.contains(i)) {
	 * notPrimeNumbers.add(num); }else { dividers.add(i); } } }
	 * 
	 * } for(int i = 0; i < numbers.size(); i++) { int num = numbers.get(i);
	 * if(!notPrimeNumbers.contains(num) && num > biggestPrime) { biggestPrime =
	 * num; } }
	 * 
	 * 
	 * 
	 * return biggestPrime; }
	 */
	/*
	 * private static List<List<Integer>> get18Dividers(List<Integer> nums) {
	 * List<List<Integer>> numbers = new ArrayList<List<Integer>>(); for(Integer num
	 * : nums) { List<Integer> dividers = getDividers(num); if(dividers.size() ==
	 * 18) { dividers.add(num); numbers.add(dividers); } } return numbers; }
	 */
	/*
	 * private static List<Integer> getDividers(int num) { List<Integer> dividers =
	 * new ArrayList<Integer>(); for (int i = 1; i <= num; i++) { if (num % i == 0)
	 * { dividers.add(i); } } return dividers; }
	 * 
	 * private static List<Integer> numbersSmallerThan1000(List<Integer> nums) {
	 * List<Integer> numberMinSecondMin = new ArrayList<>(); int counter = 0; int
	 * last = 0; int secondlast = 0; for (Integer num : nums) { if (num < 1000) {
	 * counter++; secondlast = last; last = num; }
	 * 
	 * } numberMinSecondMin.add(counter); numberMinSecondMin.add(last);
	 * numberMinSecondMin.add(secondlast);
	 * 
	 * return numberMinSecondMin; }
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
