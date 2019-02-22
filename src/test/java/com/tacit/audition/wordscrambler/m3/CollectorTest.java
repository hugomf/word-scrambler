package com.tacit.audition.wordscrambler.m3;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CollectorTest {

    private String topic = "MSG";

    @Test
    public void shouldCreateCollectorWithSizeOfFiveBlocksAndNotAddMoreBlocksThanThat() throws InterruptedException {
        //given
        Collector collector = new Collector(5);

        //when
        Runnable addCollectors = () -> {
            try {
                collector.add(new Block(1, "word1", topic), topic);
                collector.add(new Block(2, "word2", topic), topic);
                collector.add(new Block(3, "word3", topic), topic);
                collector.add(new Block(4, "word4", topic), topic);
                collector.add(new Block(5, "word5", topic), topic);
                collector.add(new Block(6, "word6", topic), topic);
                collector.add(new Block(7, "word7", topic), topic);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(addCollectors).start();
        Thread.sleep(1000);

        //then
        assertThat(collector.size(topic), is(5));
    }

    @Test
    public void shouldTakeBlocksFromCollectorInOrderTheyArrived() throws InterruptedException {
        //given
        Collector collector = new Collector(5);
        collector.add(new Block(2, "word2", topic), topic);
        collector.add(new Block(1, "word1", topic), topic);
        collector.add(new Block(4, "word4", topic), topic);
        collector.add(new Block(3, "word3", topic), topic);
        collector.add(new Block(5, "word5", topic), topic);

        //when
        Block firstBlockConsumed = collector.take(topic);
        Block secondBlockConsumed = collector.take(topic);
        Block thirdBlockConsumed = collector.take(topic);

        //then
        assertThat(firstBlockConsumed.getWord(), is("word2"));
        assertThat(secondBlockConsumed.getWord(), is("word1"));
        assertThat(thirdBlockConsumed.getWord(), is("word4"));
    }

}
