package com.tacit.audition.wordscrambler.m2;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tacit.audition.wordscrambler.m2.Block;
import com.tacit.audition.wordscrambler.m2.Scrambler;

public class UnScramblerTest {
	
	private String topic = "MSG";
	
	@Test
	public void shouldUnScramble() throws Exception {
		String phrase = "Esta es una prueba";
		List<Block> blocks = Scrambler.scramble(phrase, topic);
		assertThat(phrase, Matchers.is(Scrambler.unScramble(blocks, topic)));
	}
	
	@Test
	public void shouldUnScrambleEmptyString() throws Exception {
		String phrase = "";
		List<Block> blocks = Scrambler.scramble(phrase, topic);
		assertThat(phrase, Matchers.is(Scrambler.unScramble(blocks, topic)));
		
	}
	
	@Test
	public void shouldUnScrambleOneString() throws Exception {
		String phrase = "h";
		List<Block> blocks = Scrambler.scramble(phrase, topic);
		assertThat(phrase, Matchers.is(Scrambler.unScramble(blocks, topic)));
		
	}
	
}
