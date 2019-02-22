package com.tacit.audition.wordscrambler.m3;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScramblerHelperTest {
	
	private String topic = "MSG";

	@Test
	public void  shouldSplitPhraseIntoBlocksAndScrambleThem() {
		//given
		String phrase = "You know you’re in love when you can’t fall asleep";

		//when
		List<Block> scrambledList = ScrambleHelper.scramble(phrase, this.topic);

		//then
		assertThat(scrambledList.size(), is(phrase.split(" ").length));
		StringBuilder scrambledString = new StringBuilder();
		for (Block block : scrambledList) {
			scrambledString.append(block.getWord());
			assertThat(block.getTopic(), is(topic));
		}
		assertThat(scrambledString.toString().equals(phrase), is(false));
	}

	@Test
	public void shouldRetrieveEmptyListOfBlocksWhenPhraseToScrambleIsEmpty()  {
		//Given
		String phraseEmpty = "";
		String phraseNull = null;

		//When
		List<Block> scrambledListEmpty = ScrambleHelper.scramble(phraseEmpty, this.topic);
		List<Block> scrambledListNull = ScrambleHelper.scramble(phraseNull, this.topic);

		//Then
		assertThat(scrambledListEmpty.size(), is(0));
		assertThat(scrambledListNull.size(), is(0));
	}


	@Test
	public void shouldUnscrambleBlocksFromLongPhrase() {
		//given
		String originalPhrase = "You know you’re in love when you can’t fall asleep";
		List<Block> blocks = ScrambleHelper.scramble(originalPhrase, topic);

		//when
		String unscrambledPhrase = ScrambleHelper.unScramble(blocks);

		//then
		assertThat(originalPhrase, is(unscrambledPhrase));
	}

	@Test
	public void shouldRetrieveEmptyStringWhenBlocksToUnscrambleAreEmpty() {
		//given
		String originalPhrase = "";
		List<Block> blocks = ScrambleHelper.scramble(originalPhrase, topic);

		//when
		String scrambledPhrase = ScrambleHelper.unScramble(blocks);

		//then
		assertThat(scrambledPhrase.isEmpty(), is(true));
		assertThat(originalPhrase, is(scrambledPhrase));

	}
	
}
