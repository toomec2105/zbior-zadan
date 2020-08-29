package napisy72;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Napisy {
	public static void main(String[] args) {
		List<String> napisy = getStringList("src/napisy72/napisy.txt");

		// 72.1 System.out.println("Expected: ??? Actual: " +
		// count3TimesLonger(napisy));

		// 72 .2 System.out.println("Expected: ??? + Actual: " +
		// checkContainingStrings(napisy));

		/*
		 * 72.3 System.out.println("Expected: ??? Actual: " +
		 * getLongestEndingSize(napisy)); System.out.println("Expected: 2 Actual: " +
		 * getLongestEndingSize(Arrays.asList("zac czernac")));
		 */

	}

	/*
	 * 72.1 private static List<String> count3TimesLonger(List<String> napisy) {
	 * List<String> output = new ArrayList<>(); Integer counter = 0; String
	 * firstPair = ""; for(String napis:napisy) { String first =
	 * napis.split(" ")[0]; String second = napis.split(" ")[1];
	 * 
	 * if(first.length() <= second.length()/3 || second.length() <=
	 * first.length()/3) {
	 * 
	 * counter ++; if(firstPair.equals("")) { firstPair = napis; } }
	 * 
	 * } output.add(firstPair); output.add(counter.toString()); return output; }
	 */

	/*
	 * 72.2 private static List<String> checkContainingStrings(List<String> napisy)
	 * { List<String> output = new ArrayList<>(); for (String napis : napisy) {
	 * String first = napis.split(" ")[0]; String second = napis.split(" ")[1];
	 * if(second.length() > first.length() && second.substring(0,
	 * first.length()).equals(first)) { output.add(napis); } } return output; }
	 */

	/*
	 * 72.3 private static Integer getLongestEndingSize(List<String> napisy) {
	 * Integer endingLength = 0; for (String napis : napisy) { String first =
	 * napis.split(" ")[0]; String second = napis.split(" ")[1]; Integer length = 0;
	 * 
	 * if (first.length() > second.length()) { length = second.length(); } else {
	 * length = first.length(); } Integer currLength = 0; for (int i = 0; i <
	 * length; i++) {
	 * 
	 * String firstEnding = first.substring(first.length() - i - 1); String
	 * secondEnding = second.substring(second.length() - i - 1); if
	 * (firstEnding.equals(secondEnding)) { currLength++; } if (currLength >
	 * endingLength) { endingLength = currLength; } } } return endingLength; }
	 */

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
