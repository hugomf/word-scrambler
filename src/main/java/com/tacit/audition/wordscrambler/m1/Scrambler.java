package com.tacit.audition.wordscrambler.m1;

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
			this.phrase = String.format("%s %s", this.phrase, ETX);
			String[] words = phrase.split(" ");
			for (String word : words) {
				collector.add(word);
				System.out.println(String.format("Thread: %s - Produced word: %s", Thread.currentThread().getId(), word));
				Thread.sleep(this.time);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}