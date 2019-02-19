package com.tacit.audition.wordscrambler.m3;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScrambleHelper {

	public static List<Block> scramble(String phrase, String topic) {
	
		List<Block> scrambledBlocks = Lists.newArrayList();
		if (StringUtils.isEmpty(phrase)) return scrambledBlocks;
		
		
		String[] words = phrase.split(" ");
		for (int i = 0; i < words.length; i++) {
			scrambledBlocks.add(new Block(i,words[i], topic));
		}
		Collections.shuffle(scrambledBlocks);
		
		return scrambledBlocks;
		
	}
	
	public static String unScramble(List<Block> blocks) {
		List<Block> sortedBlocks = blocks.stream()
				.sorted(Comparator.comparingInt(Block::getPosition))
				.collect(Collectors.toList());


		String unScrambled = sortedBlocks.stream()
				.map(Block::getWord)
				.collect(Collectors.joining(" "));
		
		return unScrambled;
	}

}
