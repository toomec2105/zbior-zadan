package liczbyOsemkowe62;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiczbyOsemkowe {
	public static void main(String[] args) {
		List<Integer> osemkowe = getIntegerList("src/liczbyOsemkowe62/liczby1.txt");
		List<Integer> dziesientne = getIntegerList("src/liczbyOsemkowe62/liczby2.txt");

		/*
		 * // test reformat from oktal to decimal
		 * System.out.println("Expected: 9654, Actual: " + reformatToDecimal((double)
		 * 22666)); System.out.println("Expected: 73, Actual: " +
		 * reformatToDecimal((double) 111)); // test reformat from decimal to oktal
		 * System.out.println("Expected: 22666, Actual: " + reformatToOctal((double)
		 * 9654)); System.out.println("Expected: 111, Actual: " +
		 * reformatToOctal((double) 73));
		 */

		/*
		 * 62.1 
		 * System.out.println("Expected 2,56 Actual: " +
		 * getMinMax(Arrays.asList(4,2,11,25,56,37)));
		 * System.out.println("Expected ??? Actual: " + getMinMax(osemkowe));
		 */

		/*
		 * 62.2 
		 * System.out.println("Expected 1,6 Actual: " +
		 * getRisingSequence(Arrays.asList(1,2,3,4,1,5,6,7,8,9)));
		 * System.out.println("Expected 43,4 Actual: " +
		 * getRisingSequence(Arrays.asList(23,65,43,56,65,87,21,7,3)));
		 * System.out.println("Expected 43,4 Actual: " +
		 * getRisingSequence(dziesientne));
		 */

		// 62.3
		// System.out.println("Expected: ?? Actual: " +
		// compareOctalDecimal(osemkowe,dziesientne));

		/*
		 * test checkNumberOf6 
		 * System.out.println("Expected: 3 Actual: " +
		 * checkNumberOf6((double) 612636)); System.out.println("Expected: 4 Actual: " +
		 * checkNumberOf6((double) 66247626));
		 */

		/*
		 * 62.4 
		 * System.out.println("Expected: ?? Actual: " +
		 * countAll6Octal(dziesientne)); System.out.println("Expected: ?? Actual: " +
		 * countAll6Decimal(dziesientne));
		 */
	}

	/*
	 * 62.4 
	 * private static Integer countAll6Decimal(List<Integer> dziesientne) {
	 * Integer sixCounter = 0; for(Integer num : dziesientne) { Double singleNum =
	 * Double.parseDouble(num.toString());
	 * 
	 * sixCounter += checkNumberOf6(singleNum); }
	 * 
	 * return sixCounter; }
	 * 
	 * private static Integer countAll6Octal(List<Integer> dziesientne) { Integer
	 * sixCounter = 0; for(Integer num : dziesientne) { Double singleNum =
	 * Double.parseDouble(num.toString()); singleNum = (double)
	 * reformatToOctal(singleNum); sixCounter += checkNumberOf6(singleNum); }
	 * 
	 * return sixCounter; }
	 */

	/*
	 * 62.3 
	 * private static List<Integer> compareOctalDecimal(List<Integer> osemkowe,
	 * List<Integer> dziesientne) { Integer sameValues = 0; Integer biggerOctals =
	 * 0;
	 * 
	 * for(int i=0; i < dziesientne.size(); i ++) { if(dziesientne.get(i) ==
	 * reformatToDecimal(Double.valueOf(osemkowe.get(i)))) { sameValues++; }
	 * 
	 * if(dziesientne.get(i) < reformatToDecimal(Double.valueOf(osemkowe.get(i)))) {
	 * biggerOctals++; } } return Arrays.asList(sameValues,biggerOctals); }
	 */

	/*
	 * 62.2 
	 * private static List<Integer> getRisingSequence(List<Integer> numbers) {
	 * List<Integer> output = new ArrayList<>(); Integer topLength = 0; Integer
	 * beggining = numbers.get(0); Integer length = 0; for(int i = numbers.size() -
	 * 2; i >= 0; i--) {
	 * 
	 * if(numbers.get(i) <= numbers.get(i + 1)) { length ++; }else { if(length >
	 * topLength) { topLength = length; beggining = numbers.get(i+1); }
	 * if(numbers.get(i) > numbers.get(i + 1)) { length = 0; } } } if(topLength ==
	 * 0) { topLength = numbers.size(); } output.add(beggining);
	 * output.add(topLength + 1); return output; }
	 */

	/*
	 * 62.1 
	 * private static List<Integer> getMinMax(List<Integer> numbers) {
	 * List<Integer> minMax = new ArrayList<>(); Integer max = numbers.get(0);
	 * Integer min = numbers.get(0);
	 * 
	 * for (Integer num : numbers) { if(num > max) { max = num; } if(num < min) {
	 * min = num; } } minMax.add(min); minMax.add(max); return minMax; }
	 */

	public static int checkNumberOf6(Double number) {
		int counter = 0;
		int length = number.toString().length();

		for (Double i = (double) 0; i < length; i++) {
			if (number % Math.pow(10, i + 1) == Math.pow(10, i) * 6) {
				counter++;
			}
			number -= number % Math.pow(10, i + 1);
		}
		return counter;
	}

	public static int reformatToDecimal(Double oktal) {
		int decimal = 0;
		int length = oktal.toString().length() - 2;

		for (int i = 0; i < length; i++) {

			decimal += (Math.pow(8, i) * (oktal % (Math.pow(10, (i + 1))))) / Math.pow(10, i);

			oktal -= oktal % Math.pow(10, (i + 1));
		}
		return decimal;
	}

	public static int reformatToOctal(Double decimal) {
		int oktal = 0;
		int length = decimal.toString().length() - 1;

		for (int i = 0; i < length; i++) {

			oktal += Math.pow(10, i) * (decimal % (Math.pow(8, (i + 1)))) / Math.pow(8, i);
			decimal -= decimal % (Math.pow(8, (i + 1)));
		}
		return oktal;
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
