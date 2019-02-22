package com.tacit.audition.wordscrambler.m3;

public class Block {

	private int position;
	private String word;
	private String topic;
	
	public Block(int position, String word, String topic) {
		this.position = position;
		this.word = word;
		this.topic = topic;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return String.format("{%s, %s,'%s'}", topic, position, word);
	}
	
}
