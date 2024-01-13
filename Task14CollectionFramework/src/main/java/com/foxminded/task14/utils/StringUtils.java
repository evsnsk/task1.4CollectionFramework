package com.foxminded.task14.utils;

public class StringUtils {

	private final static char SPACE = ' ';

	public static char[] separateChars(String inputWord) {
		return inputWord.toLowerCase().toCharArray();
	}

	public static String[] separateWords(String input) {
		String[] separatedWords = input.split(String.valueOf(SPACE));
		for (String separatedWord : separatedWords) {
			separatedWord = separatedWord.toLowerCase();
		}
		return separatedWords;
	}

	public static int amountOfSpaces(String input) {
		int amountOfSpaces = 0;
		for (char c : input.toCharArray()) {
			if (c == SPACE) {
				amountOfSpaces++;
			}
		}
		return amountOfSpaces;
	}

}
