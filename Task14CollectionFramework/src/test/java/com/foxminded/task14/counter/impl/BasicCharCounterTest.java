package com.foxminded.task14.counter.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.foxminded.task14.counter.CharCounter;
import com.foxminded.task14.counter.impl.BasicCharCounter;

class BasicCharCounterTest {

	CharCounter basicCharCounter = new BasicCharCounter();

	@Test
	void countTest() {

		String inputWord = "Hello1";
		Map<Character, Integer> expectedResult = new HashMap<Character, Integer>();
		expectedResult.put('h', 1);
		expectedResult.put('e', 1);
		expectedResult.put('l', 2);
		expectedResult.put('o', 1);
		expectedResult.put('1', 1);

		assertEquals(expectedResult, basicCharCounter.count(inputWord));
	}

}
