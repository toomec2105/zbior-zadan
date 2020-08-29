package napisy72;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Napisy {
	public static void main(String[] args) {
		List<String> napisy = getStringList("src/napisy72/napisy.txt");

		// 72.1 System.out.println("Expected: ??? Actual: " +
		// count3TimesLonger(napisy));
		// 72 .2 System.out.println("Expected: ??? + Actual: " +
		// checkContainingStrings(napisy));
		System.out.println("Expected: ??? Actual: " + getLongestEnding(napisy));
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
	 * 72.2s private static List<String> checkContainingStrings(List<String> napisy)
	 * { List<String> output = new ArrayList<>(); for (String napis : napisy) {
	 * String first = napis.split(" ")[0]; String second = napis.split(" ")[1];
	 * if(second.length() > first.length() && second.substring(0,
	 * first.length()).equals(first)) { output.add(napis); } } return output; }
	 */

	private static List<String> getLongestEnding(List<String> napisy) {
		// TODO Auto-generated method stub
		return null;
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
