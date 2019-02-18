package com.tacit.audition.wordscrambler.m1;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.tacit.audition.wordscrambler.m1.Block;


public class Consumer implements Runnable {
	
	
	private static final String ETX = new String(new char[] {3}); // initialize to ASCII Code that represents 'End of Text' ETX

	private Collector collector;
	private List<Block> blocks;
	private int time;

	public Consumer(Collector collector, int time) {
		this.collector = collector;
		this.blocks = Lists.newArrayList();
		this.time = time;
	}

	@Override
	public void run() {

		try {
			String word = ""; 
			while (!word.equals(ETX)) { 
				Block block = collector.take();
				System.out.println(String.format("Thread:%s - Consumed block:%s",Thread.currentThread().getId(),  block));
				blocks.add(block);
				word = block.getWord();
				Thread.sleep(this.time);
			}
			String phrase = blocks.stream().map(Block::getWord).collect(Collectors.joining(" "));
			
			
			System.out.println(String.format("Thread:%s - Unscrambled phrase:%s",Thread.currentThread().getId(),  phrase));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}