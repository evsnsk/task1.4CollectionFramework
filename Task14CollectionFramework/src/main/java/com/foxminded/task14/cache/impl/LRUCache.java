package com.foxminded.task14.cache.impl;

import java.util.HashMap;
import java.util.Map;

import com.foxminded.task14.cache.Cache;

public class LRUCache<K, T> implements Cache<K, T> {

	private final int capacity;
	private Map<K, CacheElement<K, T>> storage;
	CustomLinkedList<K, T> list;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		storage = new HashMap<K, CacheElement<K, T>>(capacity);
		list = new CustomLinkedList<>();
	}

	private void evictOldest() {
		CacheElement<K, T> oldestEtry = list.poll();
		if (oldestEtry != null) {
			storage.remove(oldestEtry.key);
		}
	}

	private void markAsUsed(K key) {
		CacheElement<K, T> entry = storage.get(key);
		if (entry == null) {
			return;
		}
		list.remove(entry);
		list.add(entry);
	}

	public int size() {
		return storage.size();
	}

	@Override
	public T get(K key) {
		markAsUsed(key);
		CacheElement<K, T> entry = storage.get(key);
		if (entry == null) {
			return null;
		}
		return entry.value;
	}

	@Override
	public void put(K key, T value) {
		if (size() >= capacity) {
			evictOldest();
		}
		storage.put(key, new CacheElement<>(key, value));
		markAsUsed(key);

	}

	@Override
	public boolean containsKey(K key) {
		return storage.containsKey(key);
	}

}
