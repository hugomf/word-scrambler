package com.tacit.audition.wordscrambler.m1;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;


public class UnScrambler implements Runnable {
	
	
	private static final java.lang.String ETX = new java.lang.String(new char[] {3}); // initialize to ASCII Code that represents 'End of Text' ETX

	private Collector collector;
	private List<String> blocks;
	private int time;

	public UnScrambler(Collector collector, int time) {
		this.collector = collector;
		this.blocks = Lists.newArrayList();
		this.time = time;
	}

	@Override
	public void run() {

		try {
			java.lang.String word = "";
			while (!word.equals(ETX)) { 
				String block = collector.take();
				System.out.println(java.lang.String.format("Thread: %s - Consumed word: %s", Thread.currentThread().getId(),  block));
				blocks.add(block);
				word = block;
				Thread.sleep(this.time);
			}
			java.lang.String phrase = blocks.stream()
					.collect(Collectors.joining(" "));
			
			System.out.println(java.lang.String.format("Thread: %s - Phrase Received: %s",Thread.currentThread().getId(),  phrase));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}