package com.foxminded.task14.cache.impl;

import java.util.HashMap;
import java.util.Map;

import com.foxminded.task14.cache.Cache;

public class BasicCache<K,T> implements Cache<K,T> {
	private  Map<K, T> storage = new HashMap<K,T>();
	

	@Override
	public T get(K key) {
		return storage.get(key);
	}

	@Override
	public void put(K key, T value) {
		storage.put(key, value);
		
	}

	@Override
	public boolean containsKey(K key) {
		return storage.containsKey(key);
	}

}
