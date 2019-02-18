package com.tacit.audition.wordscrambler.m1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordScramblerTest {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		Collector collector = new Collector(5);
		
		Producer producer1 = new Producer(collector, "You know you’re in love when you can’t fall asleep because reality is finally better than your dreams", 50);
		Consumer consumer1 = new Consumer(collector, 100);
		
		executor.execute(producer1);
		executor.execute(consumer1);

		executor.shutdown();
	}
}






