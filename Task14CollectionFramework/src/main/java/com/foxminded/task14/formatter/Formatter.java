package com.foxminded.task14.formatter;

import java.util.Map;

public class Formatter {

	public String apply(Map<Character, Integer> result) {
		StringBuilder formatted = new StringBuilder();

		for (Map.Entry<Character, Integer> entry : result.entrySet()) {
			formatted.append("\"");
			formatted.append(entry.getKey());
			formatted.append("\" - ");
			formatted.append(entry.getValue());
			formatted.append("\n");
		}
		return formatted.toString();
	}

}
