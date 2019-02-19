package com.tacit.audition.wordscrambler.m3;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;

public class UnScramblerTest {
	
	private String topic = "MSG";
	
	@Test
	public void shouldUnScramble() throws Exception {
		String phrase = "This is a test";
		List<Block> blocks = ScrambleHelper.scramble(phrase, topic);
		assertThat(phrase, Matchers.is(ScrambleHelper.unScramble(blocks)));
	}
	
	@Test
	public void shouldUnScrambleEmptyString() throws Exception {
		String phrase = "";
		List<Block> blocks = ScrambleHelper.scramble(phrase, topic);
		assertThat(phrase, Matchers.is(ScrambleHelper.unScramble(blocks)));
		
	}
	
	@Test
	public void shouldUnScrambleOneString() throws Exception {
		String phrase = "h";
		List<Block> blocks = ScrambleHelper.scramble(phrase, topic);
		assertThat(phrase, Matchers.is(ScrambleHelper.unScramble(blocks)));
		
	}
	
}
