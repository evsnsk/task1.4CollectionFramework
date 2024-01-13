package com.foxminded.task14.formatter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.foxminded.task14.formatter.Formatter;

class FormatterTest {
	Formatter formatter = new Formatter();

	@Test
	void applyTest() {
		String expected = """
				" " - 2
				"1" - 1
				"e" - 1
				"h" - 1
				"l" - 2
				"o" - 1
								""";

		Map<Character, Integer> cache = new HashMap<>();
		cache.put('h', 1);
		cache.put('e', 1);
		cache.put('l', 2);
		cache.put('o', 1);
		cache.put(' ', 2);
		cache.put('1', 1);

		assertEquals(expected, formatter.apply(cache));

	}

}
