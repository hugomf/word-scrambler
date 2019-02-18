package com.tacit.audition.wordscrambler.m1;

public class Producer implements Runnable {
	
	private static final String ETX = new String(new char[] {3}); // ASCII Code that represents 'End of Text' ETX
	private Collector collector;
	private String phrase;
	private int time;

	public Producer(Collector collector, String phrase, int time) {
		this.collector = collector;
		this.phrase = phrase;
		this.time = time;
	}

	@Override
	public void run() {
		try {
			this.phrase = String.format("%s %s", this.phrase, ETX);
			String[] words = phrase.split(" ");
			for (int i = 0; i < words.length; i++) {
				Block block = new Block(i,words[i]);
				collector.add(block);
				System.out.println(String.format("Thread:%s - Produced Block:%s",Thread.currentThread().getId(), block.getWord()));
				Thread.sleep(this.time);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}