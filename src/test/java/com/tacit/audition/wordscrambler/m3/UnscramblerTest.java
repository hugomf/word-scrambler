package com.tacit.audition.wordscrambler.m3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UnscramblerTest {

    private String topic = "MSG";
    private List<Block> consumedBlocks = new ArrayList<>();
    private Collector collector = new Collector(5) {
        @Override
        public Block take(String topic) throws InterruptedException {
            Block block = super.take(topic);
            consumedBlocks.add(block);
            return block;
        }
    };

    @Test
    public void shouldConsumeBlocksStoredInCollectorAsTheyArrived() throws InterruptedException {
        //given
        String phraseToTest = "This phrase will be scrambled";
        List<Block> scrambledBlocks = ScrambleHelper.scramble(phraseToTest, topic);
        for(Block block : scrambledBlocks) {
            collector.add(block, topic);
        }
        Unscrambler unscrambler = new Unscrambler(collector, 100, topic);

        //when
        new Thread(unscrambler).start();
        Thread.sleep(1000);

        //then
        assertThat(consumedBlocks.size(), is(5));
        consumedBlocks.forEach(block -> assertThat(phraseToTest.contains(block.getWord()), is(true)));
        int i = 0;
        for(Block block : consumedBlocks) {
            block.getWord().equals(consumedBlocks.get(i).getWord());
            i++;
        }
    }
}
