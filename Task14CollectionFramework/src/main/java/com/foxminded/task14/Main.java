package com.foxminded.task14;

import java.util.Scanner;

import com.foxminded.task14.cache.impl.LRUCache;
import com.foxminded.task14.counter.CharCounter;
import com.foxminded.task14.counter.impl.BasicCharCounter;
import com.foxminded.task14.counter.impl.CachingCharCounterDecorator;
import com.foxminded.task14.formatter.Formatter;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		CharCounter cachingCharCounter = new CachingCharCounterDecorator<>(new BasicCharCounter(), new LRUCache<>(10));
		Formatter formatter = new Formatter();

		while (true) {
			System.out.println(formatter.apply(cachingCharCounter.count(in.nextLine())));
		}

	}
}
