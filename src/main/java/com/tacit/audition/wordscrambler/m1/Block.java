package com.tacit.audition.wordscrambler.m1;

public class Block {

	private int position;
	private String word;
	
	public Block(int position, String word) {
		
		this.position = position;
		this.word = word;
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
	
	@Override
	public String toString() {
		return String.format("{%s,'%s'}", position, word);
	}
	
}
