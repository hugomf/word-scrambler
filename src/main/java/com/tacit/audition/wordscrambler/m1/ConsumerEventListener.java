package com.tacit.audition.wordscrambler.m1;

public interface ConsumerEventListener {
	
	public void onConsumedBlock(Block block);
	
	public void onPhraseCompleted(String word);

}
