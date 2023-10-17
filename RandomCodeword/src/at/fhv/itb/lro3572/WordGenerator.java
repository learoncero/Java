package at.fhv.itb.lro3572;

import java.util.Random;
import java.util.HashMap;

public class WordGenerator {
	private static HashMap<String, Integer> _codewords = new HashMap<>();
	private static int _hashID = 0;

	
//	Start Methods
	public HashMap<String, Integer> generateCodeword(int n, int len) {
		Random randomNumber = new Random();
		StringBuilder word = new StringBuilder();
		int charCounter;
		boolean unique;
		int i = 0;
		
		while (i < n) {
			unique = false;
			while (unique == false) {
				for (charCounter = 0; charCounter < len; charCounter += 1) {
					word.append((char)randomNumber.nextInt('a', 'z' + 1));
				}
				unique = checkUniqueness(word.toString());
				if (unique == false) {
					word.delete(0, word.length());
				}
				else {
					_codewords.put(word.toString(), _hashID);
					_hashID += 1;
					i += 1;
					word.delete(0, word.length());
				}
			}
		}	
		return _codewords;
	}
	
	private boolean checkUniqueness(String word) {
		boolean unique = true;
		if (_codewords.containsKey(word)) {
			unique = false;
		}
		return unique;
	}
//	End Methods

	public static void main(String[] args) {
		WordGenerator wordGenerator = new WordGenerator();
		
		System.out.println("Codewoerter: " + wordGenerator.generateCodeword(100, 5));
	}


}
