package com.foxminded.task14.counter.impl;

import java.util.Map;

import com.foxminded.task14.cache.Cache;
import com.foxminded.task14.counter.CharCounter;

public class CachingCharCounterDecorator<K, T> implements CharCounter {

	private final CharCounter charCounter;
	private final Cache<String, Map<Character, Integer>> cache;

	public CachingCharCounterDecorator(CharCounter wrapped, Cache<String, Map<Character, Integer>> cache) {
		charCounter = wrapped;
		this.cache = cache;
	}

	@Override
	public Map<Character, Integer> count(String text) {
		if (cache.containsKey(text)) {
			return cache.get(text);
		} else {
			Map<Character, Integer> result = charCounter.count(text);
			cache.put(text, result);
			return result;
		}
	}

}
