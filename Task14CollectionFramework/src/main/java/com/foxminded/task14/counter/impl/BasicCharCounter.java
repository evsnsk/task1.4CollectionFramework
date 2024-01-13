package com.foxminded.task14.counter.impl;

import java.util.HashMap;
import java.util.Map;

import com.foxminded.task14.counter.CharCounter;
import com.foxminded.task14.utils.StringUtils;

public class BasicCharCounter implements CharCounter {

	@Override
	public Map<Character, Integer> count(String text) {

		int newAmountOfChars = 0;
		Map<Character, Integer> uniqueCharacters = new HashMap<>();
		char[] separatedChars = StringUtils.separateChars(text);

		for (char ch : separatedChars) {
			int currentCount = uniqueCharacters.getOrDefault(ch, 0);
			uniqueCharacters.put(ch, currentCount + 1);

		}
		if (StringUtils.amountOfSpaces(text) > 0) {
			uniqueCharacters.put(' ', StringUtils.amountOfSpaces(text));
		}
		return uniqueCharacters;
	}
}
