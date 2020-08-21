package anagramy68;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagramy {

	public static void main(String[] args) {
		List<String> pairs = getStringList("src/anagramy68/dane_napisy.txt");
		/*
		 * System.out.println("Expexted: true Actual: " +
		 * checkIfAnagram("AAAA","AAAA")); System.out.println("Expexted: true Actual: "
		 * + checkIfAnagram("ABBA","BABA"));
		 * System.out.println("Expexted: false Actual: " +
		 * checkIfAnagram("ABA","BABA")); System.out.println("Expexted: false Actual: "
		 * + checkIfAnagram("AAAA","AAA"));
		 * System.out.println("Expexted: false Actual: " +
		 * checkIfAnagram("AABA","AACA"));
		 */

		// 68.1
		// System.out.println("Expected: ??? Actual: " + countSolidAnagrams(pairs));
		// 68.2
		// System.out.println("Expected: ???, Actual: " + countAngrams(pairs));
		// 68.3
		System.out.println("Expected: ??? Actual: " + getFrequentAnagram(pairs));

	}

	/*
	 * 68.1 private static Integer countSolidAnagrams(List<String> pairs) { Integer
	 * counter = 0; for(String pair: pairs) { String[] texts = pair.split(" ");
	 * if(checkIfAnagram(texts[0], texts[1]) && checkIfSameLetters(texts[0])) {
	 * counter++; } } return counter; }
	 * 
	 * private static boolean checkIfSameLetters(String text) { Character letter =
	 * text.charAt(0); for(int i = 0; i < text.length(); i++) {
	 * if(!letter.toString().equals(((Character)text.charAt(i)).toString())) {
	 * return false; } } return true; }
	 */

	private static Integer getFrequentAnagram(List<String> pairs) {
		List<String> texts = new ArrayList<>();
		Map<Map<Character, Integer>, Integer> anagramFrequencies = new HashMap<>();
		Integer topFrequency = 0;

		for (String pair : pairs) {
			String[] temp = pair.split(" ");
			texts.add(temp[0]);
			texts.add(temp[1]);
		}

		for (String text : texts) {
			Map<Character, Integer> currentAnagram = getLettersFrequency(text);
			
			if (anagramFrequencies.containsKey(currentAnagram)) {
				anagramFrequencies.put(currentAnagram, anagramFrequencies.get(currentAnagram) + 1);
			} else {
				anagramFrequencies.put(currentAnagram, 1);
			}
			if (anagramFrequencies.get(currentAnagram) > topFrequency) {
				topFrequency = anagramFrequencies.get(currentAnagram);
			}
		}

		return topFrequency;
	}

	/*
	 * 68.2 private static Integer countAngrams(List<String> pairs) { Integer
	 * counter = 0; for(String pair: pairs) { String[] texts = pair.split(" ");
	 * if(checkIfAnagram(texts[0], texts[1])) { counter++; } } return counter; }
	 */
	private static boolean checkIfAnagram(String first, String second) {
		Map<Character, Integer> letters = getLettersFrequency(first);

		for (int i = 0; i < second.length(); i++) {
			char letter = second.charAt(i);
			if (letters.containsKey(letter) == false) {
				return false;
			} else {
				letters.put(letter, letters.get(letter) - 1);
			}
			if (letters.get(letter) == 0) {
				letters.remove(letter);
			}
		}
		if (letters.size() == 0) {
			return true;
		}
		return false;
	}

	private static Map<Character, Integer> getLettersFrequency(String text) {
		Map<Character, Integer> letters = new HashMap<>();
		for (int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			if (letters.containsKey(letter)) {
				letters.put(letter, letters.get(letter) + 1);
			} else {
				letters.put(letter, 1);
			}
		}
		return letters;
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
