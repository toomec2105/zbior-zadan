package geny69;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Geny {
	public static void main(String[] args) {
		List<String> genotypes = getStringList("src/geny69/dane_geny.txt");
		// 69.1
		// System.out.println("Expected: ?? Actual: " + countSpecies(genotypes));

		// 69.2
		/*
		 * System.out.println("Expected: AAECBB Actual: " + getGenes("ACAAECBBDBB"));
		 * System.out.println("Expected: AADAAECBB Actual: " + getGenes("DEAADAAECBB"));
		 * System.out.println("Expected: AADAAECBBAADEBB Actual: " +
		 * getGenes("DEAADAAECBBDECAADEBBAC"));
		 * 
		 * System.out.println("Expected: ?? Actual: " + getMutants(genotypes));
		 */

		// 69.3
		// System.out.println("Expected: 1,4 Actual: " + getGenotypeInfo("AABB"));
		//System.out.println("Expected: ??? Actual: " + getSpeciesInfo(genotypes));
	}

	/*
	 * private static Integer getMutants(List<String> genotypes) { Integer counter =
	 * 0; for (String genotype : genotypes) { if
	 * (getGenes(genotype).contains("BCDDC")) { counter++; } } return counter; }
	 */
	/*
	 * private static List<Integer> getSpeciesInfo(List<String> genotypes) { Integer
	 * mostGenes = 0; Integer longestGene = 0; List<Integer> output = new
	 * ArrayList<>(); for (String genotype : genotypes) { if
	 * (getGenotypeInfo(genotype).get(0) > mostGenes) { mostGenes =
	 * getGenotypeInfo(genotype).get(0); }
	 * 
	 * if(getGenotypeInfo(genotype).get(1) > longestGene) { longestGene =
	 * getGenotypeInfo(genotype).get(1); } } output.add(mostGenes);
	 * output.add(longestGene); return output; }
	 * 
	 * private static List<Integer> getGenotypeInfo(String genotype) { List<Integer>
	 * output = new ArrayList<>(); Integer counter = 0; Integer geneLength = 0;
	 * Integer start = -1; for (int i = 0; i < genotype.length() - 1; i++) { if
	 * (Character.toString(genotype.charAt(i)).equals("A") &&
	 * Character.toString(genotype.charAt(i + 1)).equals("A") && start == -1) {
	 * start = i; } if (Character.toString(genotype.charAt(i)).equals("B") &&
	 * Character.toString(genotype.charAt(i + 1)).equals("B") && start != -1) {
	 * counter++; if (i - start + 2 > geneLength) { geneLength = i - start + 2; }
	 * 
	 * start = -1; } } output.add(counter); output.add(geneLength); return output; }
	 */

	/*
	 * private static String getGenes(String genotype) { String output = ""; Integer
	 * start = 0; for (int i = 0; i < genotype.length() - 1; i++) { if
	 * (Character.toString(genotype.charAt(i)).equals("A") &&
	 * Character.toString(genotype.charAt(i + 1)).equals("A") && start == 0) { start
	 * = i; } if (Character.toString(genotype.charAt(i)).equals("B") &&
	 * Character.toString(genotype.charAt(i + 1)).equals("B") && start != 0) {
	 * output += genotype.substring(start, i + 2); start = 0; } } return output; }
	 */

	/*
	 * public static List<Integer> countSpecies(List<String> genotypes) {
	 * Map<Integer, Integer> species = new HashMap<Integer,Integer>(); Integer
	 * topPopulation = 0; for(String genotype:genotypes) { Integer currentSpecies =
	 * genotype.length();
	 * 
	 * if(species.get(currentSpecies) == null) { species.put(currentSpecies, 1);
	 * }else { species.put(currentSpecies, species.get(currentSpecies) + 1); }
	 * 
	 * if(species.get(currentSpecies) > topPopulation) { topPopulation =
	 * species.get(currentSpecies); } } return
	 * Arrays.asList(species.size(),topPopulation); }
	 */

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
