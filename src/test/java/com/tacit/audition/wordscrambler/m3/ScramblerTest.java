package com.tacit.audition.wordscrambler.m3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ScramblerTest {

	private String topic = "MSG";
	private List<Block> producedBlocks = new ArrayList<>();
	private Collector collector = new Collector(5) {
		@Override
		public void add(Block block, String topic) throws InterruptedException {
			super.add(block, topic);
			producedBlocks.add(block);
		}
	};

	@Test
	public void shouldInitializePhraseAndSendBlocksToCollector() throws InterruptedException {
		//given
		String phraseToTest = "This phrase will be scrambled";
		Scrambler scrambler = new Scrambler(collector, phraseToTest, 50, topic);

		//when
		new Thread(scrambler).start();
		Thread.sleep(1000);

		//then
		assertThat(producedBlocks.size(), is(5));
		producedBlocks.forEach(block -> assertThat(phraseToTest.contains(block.getWord()), is(true)));
	}

}

