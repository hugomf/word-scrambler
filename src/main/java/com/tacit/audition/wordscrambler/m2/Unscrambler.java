package com.tacit.audition.wordscrambler.m2;

import com.google.common.collect.Lists;

import java.util.List;


public class Unscrambler implements Runnable {
	private static final String ETX = new String(new char[] {3}); // initialize to ASCII Code that represents 'End of Text' ETX

	private Collector collector;
	private List<Block> scrambledBlocks;
	private int time;

	public Unscrambler(Collector collector, int time) {
		this.collector = collector;
		this.scrambledBlocks = Lists.newArrayList();
		this.time = time;
	}

	@Override
	public void run() {
		try {
			String word = ""; 
			while (!word.equals(ETX)) { 
				Block block = collector.take();
				System.out.println(String.format("Thread: %s - Consumed block: %s", Thread.currentThread().getId(),  block));
				scrambledBlocks.add(block);
				word = block.getWord();
				Thread.sleep(this.time);
			}
			String phrase = ScrambleHelper.unScramble(this.scrambledBlocks);

			System.out.println(String.format("Thread: %s - Unscrambled phrase: %s",Thread.currentThread().getId(),  phrase));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}