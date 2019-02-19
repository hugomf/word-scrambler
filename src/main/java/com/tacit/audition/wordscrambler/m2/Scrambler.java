package com.tacit.audition.wordscrambler.m2;


import java.util.List;

public class Scrambler implements Runnable {
	
	private static final String ETX = new String(new char[] {3}); // ASCII Code that represents 'End of Text' ETX
	private Collector collector;
	private String phrase;
	private int time;

	public Scrambler(Collector collector, String phrase, int time) {
		this.collector = collector;
		this.phrase = phrase;
		this.time = time;
	}

	@Override
	public void run() {
		try {
			List<Block> blocks = ScrambleHelper.scramble(phrase);
			blocks.add(new Block(blocks.size(), ETX));
			for(Block block : blocks) {
				System.out.println(String.format("Thread: %s - Produced Block: %s",Thread.currentThread().getId(), block.getWord()));
				collector.add(block);
				Thread.sleep(this.time);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}