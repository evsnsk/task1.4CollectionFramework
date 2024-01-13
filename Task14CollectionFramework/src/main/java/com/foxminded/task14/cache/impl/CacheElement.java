package com.foxminded.task14.cache.impl;

public class CacheElement<K,V> {
	K key;
	V value;
	CacheElement<K,V> previous;
	CacheElement<K,V> next;

	public CacheElement(K key, V value) {
		this.key = key;
		this.value = value;
	}

}
