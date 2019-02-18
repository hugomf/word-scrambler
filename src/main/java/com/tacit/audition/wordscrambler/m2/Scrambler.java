package com.tacit.audition.wordscrambler.m2;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

public class Scrambler {

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
	
	public static String unScramble(List<Block> blocks, String corrId) {
		
		Collections.sort(blocks, new Comparator<Block>() {
			@Override
			public int compare(Block o1, Block o2) {
				return o1.getPosition() - o2.getPosition();
			}

		});
		
		StringBuilder unScrambled = new StringBuilder();
		for (Block block : blocks) {
			unScrambled.append(block.getWord());
			unScrambled.append(" ");
		}
		
		return unScrambled.toString().trim();
		
	}

}
