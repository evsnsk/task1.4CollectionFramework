package com.foxminded.task14.counter.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.foxminded.task14.cache.Cache;
import com.foxminded.task14.counter.CharCounter;
import com.foxminded.task14.counter.impl.CachingCharCounterDecorator;

@ExtendWith(MockitoExtension.class)
class CachingCharConterDecoratorTest {
	@Mock
	CharCounter counter;

	@Mock
	Cache<String, Map<Character, Integer>> cache;

	@InjectMocks
	CachingCharCounterDecorator<String, Map<Character, Integer>> cachingCharCounter;
	
	@Test
    void CountShouldGetFromCache() {
        Map<Character, Integer> mockResponse = Map.of('t', 2, 'e', 1, 's', 1);
        String testInput = "test";

        when(cache.containsKey(testInput)).thenReturn(true);
        when(cache.get(testInput)).thenReturn(mockResponse);

        assertEquals(mockResponse, cachingCharCounter.count(testInput));

        verify(counter, never()).count(anyString());
    }

	
	@Test
	void CountshouldGetFromCounterAndPutInCache() {
		Map<Character, Integer> mockResponse = Map.of('t', 2, 'e', 1, 's', 1);
        String testInput = "test";

        when(counter.count(testInput)).thenReturn(mockResponse);
        when(cache.containsKey(testInput)).thenReturn(false);

        assertEquals(mockResponse, cachingCharCounter.count(testInput));

        verify(counter).count(anyString());
        verify(cache).put(testInput, mockResponse);
	}

}
