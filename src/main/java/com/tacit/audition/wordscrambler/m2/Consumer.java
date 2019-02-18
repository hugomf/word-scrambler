package com.tacit.audition.wordscrambler.m2;

import java.util.List;

import com.google.common.collect.Lists;

public class Consumer implements Runnable {
	
	
	
	private static final String ETX = new String(new char[] {3}); // initialize to ASCII Code that represents 'End of Text' ETX

	private Collector collector;
	private List<Block> scrambledBlocks;
	private int time;
	private String topic;

	public Consumer(Collector collector, int time,  String topic) {
		this.collector = collector;
		this.scrambledBlocks = Lists.newArrayList();
		this.time = time;
		this.topic = topic;
	}

	@Override
	public void run() {

		try {
			String word = ""; 
			while (!word.equals(ETX)) { 
				Block block = collector.take(this.topic);
				System.out.println(String.format("Thread:%s - Consumed block:%s",Thread.currentThread().getId(),  block));
				scrambledBlocks.add(block);
				word = block.getWord();
				Thread.sleep(this.time);					
			}
			
			String phrase = Scrambler.unScramble(scrambledBlocks, this.topic);
			System.out.println(String.format("Thread:%s - Unscrambled phrase:%s",Thread.currentThread().getId(),  phrase));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}