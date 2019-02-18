package com.tacit.audition.wordscrambler.m2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.tacit.audition.wordscrambler.m2.Block;
import com.tacit.audition.wordscrambler.m2.Scrambler;

public class ScramblerTest {

	private String topic = "MSG";

	@Test
	public void  shouldScramble() throws Exception {
		
		String phrase = "This is a text";
		List<Block> scrambledList = Scrambler.scramble(phrase, this.topic);
		
		StringBuilder scrambledString = new StringBuilder();
		for (Block block : scrambledList) {
			scrambledString.append(block.getWord());
			assertThat(block.getTopic(), is(topic));
		}
		
		assertThat(StringUtils.containsAny(scrambledString.toString(), phrase), is(true));
		
		
	}
	
	
	@Test
	public void shouldScrambleWhenOneWord() throws Exception {
		
		String phrase = "hola";
		List<Block> scrambledList = Scrambler.scramble(phrase, this.topic);
		
		StringBuilder scrambledString = new StringBuilder();
		for (Block block : scrambledList) {
			scrambledString.append(block.getWord());
			assertThat(block.getTopic(), is(topic));
		}
		
		assertThat(StringUtils.containsAny(scrambledString, phrase), is(true));
		
	}
	
	@Test
	public void shouldScrambleWhenEmpty() throws Exception {
		
		String phrase = "";
		
		List<Block> scrambledList = Scrambler.scramble(phrase, this.topic);
		StringBuilder scrambledString = new StringBuilder();
		for (Block block : scrambledList) {
			scrambledString.append(block.getWord());
		}
		
		assertThat(StringUtils.isBlank(scrambledString), is(true));
		
	}
	
	
}

