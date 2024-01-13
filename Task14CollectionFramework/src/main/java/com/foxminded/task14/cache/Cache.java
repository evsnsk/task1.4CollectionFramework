package com.foxminded.task14.cache;

public interface Cache<K, T> {
	T get(K key);

	void put(K key, T value);

	boolean containsKey(K key);
}
