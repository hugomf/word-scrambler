package com.tacit.audition.wordscrambler.m2;

import java.util.List;

public class Producer implements Runnable {
	
	private static final String ETX = new String(new char[] {3}); // ASCII Code that represents 'End of Text' ETX

	
	private Collector collector;
	private String word;
	private int time;
	private String topic;

	public Producer(Collector collector, String word, int time, String topic) {
		this.collector = collector;
		this.word = word;
		this.time = time;
		this.topic = topic;
	}

	@Override
	public void run() {
		try {
			List<Block> blocks = Scrambler.scramble(word, this.topic);
			blocks.add(new Block(blocks.size(), ETX, this.topic));
			for (Block block : blocks) {
				System.out.println(String.format("Thread:%s - Produced Block:%s",Thread.currentThread().getId(), block));
				this.collector.add(block, this.topic);
				Thread.sleep(this.time);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}