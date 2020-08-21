package geny69;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Geny {
	public static void main(String[] args) {
		List<String> genotypes = getStringList("src/geny69/dane_geny.txt");
		
		
		System.out.println("Expected: ?? Actual: " + countSpecies(genotypes));
	}
	
	public static int countSpecies(List<String> genotypes) {
		Set<Integer> species = new HashSet<Integer>();
		for(String genotype:genotypes) {
			species.add(genotype.length());
		}
		return species.size();
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
