package com.foxminded.task14.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.foxminded.task14.utils.StringUtils;

class StringUtilsTest {

	@Test
	void separateCharsTest() {
		char[] expectedCharArr = { 'h', 'e', 'l', 'l', 'o' };
		String inputWord = "hElLo";
		assertArrayEquals(expectedCharArr, StringUtils.separateChars(inputWord));
	}

	@Test
	void separateWordsSeveralWordsTest() {
		String inputString = "hello world";
		String[] expectedStringArr = { "hello", "world" };

		assertArrayEquals(expectedStringArr, StringUtils.separateWords(inputString));
	}

	@Test
	void amountOfSpacesTest() {
		String inputString = "hello world  hi!";
		int expectedSpacesAmount = 3;

		assertEquals(expectedSpacesAmount, StringUtils.amountOfSpaces(inputString));
	}

}
