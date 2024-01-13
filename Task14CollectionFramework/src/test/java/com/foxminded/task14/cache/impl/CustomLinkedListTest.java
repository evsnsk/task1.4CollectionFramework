package com.foxminded.task14.cache.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CustomLinkedListTest {

	CustomLinkedList<Character, Integer> entry = new CustomLinkedList<Character, Integer>();
	CacheElement<Character, Integer> cacheElementTest1 = new CacheElement<Character, Integer>('a', 1);
	CacheElement<Character, Integer> cacheElementTest2 = new CacheElement<Character, Integer>('b', 2);
	CacheElement<Character, Integer> cacheElementTest3 = new CacheElement<Character, Integer>('c', 3);

	@Test
	void testAddElementToEmptyList() {
		entry.add(cacheElementTest1);
		assertEquals(entry.head, cacheElementTest1);
		assertEquals(entry.head.previous, null);
		assertEquals(entry.tail, cacheElementTest1);
		assertEquals(entry.tail.next, null);
	}

	@Test
	void testAddSecondElementToNotEmptyList() {
		entry.add(cacheElementTest1);
		entry.add(cacheElementTest2);
		assertEquals(entry.head, cacheElementTest1);
		assertEquals(entry.head.previous, null);
		assertEquals(entry.tail, cacheElementTest2);
		assertEquals(entry.tail.next, null);
	}

	@Test
	void testAddThirdElementToNotEmptyList() {
		entry.add(cacheElementTest1);
		entry.add(cacheElementTest2);
		entry.add(cacheElementTest3);
		assertEquals(entry.head, cacheElementTest1);
		assertEquals(entry.tail, cacheElementTest3);
		assertEquals(entry.head.next, cacheElementTest2);
		assertEquals(entry.tail.previous, cacheElementTest2);
	}

	@Test
	void testRemoveHeadElement() {
		entry.add(cacheElementTest1);
		entry.add(cacheElementTest2);
		entry.add(cacheElementTest3);
		entry.remove(cacheElementTest1);
		assertEquals(entry.head, cacheElementTest2);
		assertEquals(entry.head.next, cacheElementTest3);
		assertEquals(entry.tail.previous, cacheElementTest2);
	}

	@Test
	void testRemoveTailElement() {
		entry.add(cacheElementTest1);
		entry.add(cacheElementTest2);
		entry.add(cacheElementTest3);
		entry.remove(cacheElementTest2);
		assertEquals(entry.head, cacheElementTest1);
		assertEquals(entry.tail, cacheElementTest3);
		assertEquals(entry.head.next, cacheElementTest3);
		assertEquals(entry.tail.previous, cacheElementTest1);
	}
	
	@Test
	void testRemoveMiddleElement() {
		entry.add(cacheElementTest1);
		entry.add(cacheElementTest2);
		entry.add(cacheElementTest3);
		entry.remove(cacheElementTest3);
		assertEquals(entry.head, cacheElementTest1);
		assertEquals(entry.tail, cacheElementTest2);
		assertEquals(entry.head.next, cacheElementTest2);
		assertEquals(entry.tail.previous, cacheElementTest1);
	}

	@Test
	void testPollNotEmptyHead() {
		entry.add(cacheElementTest1);
		entry.add(cacheElementTest2);
		entry.add(cacheElementTest3);
		CustomLinkedList<Character, Integer> testEntry = entry;
		testEntry.poll();
		entry.remove(cacheElementTest1);
		assertEquals(testEntry, entry);
	}

}
