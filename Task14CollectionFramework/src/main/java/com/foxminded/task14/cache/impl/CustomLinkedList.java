package com.foxminded.task14.cache.impl;

public class CustomLinkedList<K,V> {
	CacheElement<K,V> head;
	CacheElement<K,V> tail;

	public void add(CacheElement<K,V> entry) {
		if (head == null) {
			head = tail = entry;
			head.previous = null;
			tail.next = null;
		} else {
			tail.next = entry;
			entry.previous = tail;
			tail = entry;
			tail.next = null;
		}
	}
	
	public void remove(CacheElement<K,V> entry) {
		if(head == entry ) {
			head = entry.next;
			return;
		}
		else if(tail == entry) {
			tail = entry.previous;
			tail.next  = null;
			return;
		}
		if(entry.previous != null) {
			entry.previous.next = entry.next;
		}
		if(entry.next != null) {
			entry.next.previous = entry.previous;
		}
	}
	
	public CacheElement<K,V> poll() {
		if (head == null) {
			return null;
		}
		CacheElement<K,V> item = head;
		remove(item);
		return item;
	}

}
