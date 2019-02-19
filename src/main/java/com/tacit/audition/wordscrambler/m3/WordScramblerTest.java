package com.tacit.audition.wordscrambler.m3;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordScramblerTest {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(4);
		Collector collector = new Collector(5);
		
		String corrId1 = UUID.randomUUID().toString();
		String corrId2 = UUID.randomUUID().toString();
		String corrId3 = UUID.randomUUID().toString();
		String corrId4 = UUID.randomUUID().toString();
//		String corrId5 = UUID.randomUUID().toString();
//		String corrId6 = UUID.randomUUID().toString();
//		String corrId7 = UUID.randomUUID().toString();
//		String corrId8 = UUID.randomUUID().toString();
//		String corrId9 = UUID.randomUUID().toString();
//		String corrId10 = UUID.randomUUID().toString();

		
		Scrambler producer1 = new Scrambler(collector, "You know you’re in love when you can’t fall asleep because reality is finally better than your dreams", 50, corrId1);
		Unscrambler consumer1 = new Unscrambler(collector, 100, corrId1);
		Scrambler producer2 = new Scrambler(collector, "I’m selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can’t handle me at my worst, then you sure as hell don’t deserve me at my best.", 50, corrId2);
		Unscrambler consumer2 = new Unscrambler(collector, 100, corrId2);
		Scrambler producer3 = new Scrambler(collector, "The first step toward success is taken when you refuse to be a captive of the environment in which you first find yourself.", 50, corrId3);
		Unscrambler consumer3 = new Unscrambler(collector, 100, corrId3);
		Scrambler producer4 = new Scrambler(collector, "When one door of happiness closes, another opens; but often we look so long at the closed door that we do not see the one which has been opened for us.", 50, corrId4);
		Unscrambler consumer4 = new Unscrambler(collector, 100, corrId4);
//		
//		Producer producer5 = new Producer(collector, "Twenty years from now you will be more disappointed by the things that you didn’t do than by the ones you did do.", 50, corrId5);
//		Consumer consumer5 = new Consumer(collector, 100, corrId5);
//		
//		Producer producer6 = new Producer(collector, "When I dare to be powerful – to use my strength in the service of my vision, then it becomes less and less important whether I am afraid.", 50, corrId6);
//		Consumer consumer6 = new Consumer(collector, 100, corrId6);
//
//		Producer producer7 = new Producer(collector, "It had long since come to my attention that people of accomplishment rarely sat back and let things happen to them. They went out and happened to things", 50, corrId7);
//		Consumer consumer7 = new Consumer(collector, 100, corrId7);
//
//		Producer producer8 = new Producer(collector, "A successful man is one who can lay a firm foundation with the bricks others have thrown at him.", 50, corrId8);
//		Consumer consumer8 = new Consumer(collector, 100, corrId8);
//		
//		Producer producer9 = new Producer(collector, "I can’t give you a sure-fire formula for success, but I can give you a formula for failure: try to please everybody all the time.", 50, corrId9);
//		Consumer consumer9 = new Consumer(collector, 100, corrId9);
//
//		Producer producer10 = new Producer(collector, "Would you like me to give you a formula for success? It’s quite simple, really: Double your rate of failure. You are thinking of failure as the enemy of success. But it isn’t at all. You can be discouraged by failure or you can learn from it, so go ahead and make mistakes. Make all you can. Because remember that’s where you will find success.", 50, corrId10);
//		Consumer consumer10 = new Consumer(collector, 100, corrId10);
		
		
		executor.execute(producer1);
		executor.execute(consumer1);

		executor.execute(producer2);
		executor.execute(consumer2);
		
		executor.execute(producer3);
		executor.execute(consumer3);
		
		executor.execute(producer4);
		executor.execute(consumer4);
		
//		executor.execute(producer5);
//		executor.execute(consumer5);
//
//		executor.execute(producer6);
//		executor.execute(consumer6);
//		
//		executor.execute(producer7);
//		executor.execute(consumer7);
//		
//		executor.execute(producer8);
//		executor.execute(consumer8);
//		
//		executor.execute(producer9);
//		executor.execute(consumer9);
//		
//		executor.execute(producer10);
//		executor.execute(consumer10);

		
		executor.shutdown();
	}
}






