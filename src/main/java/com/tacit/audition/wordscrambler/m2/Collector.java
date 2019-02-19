package com.tacit.audition.wordscrambler.m2;

import java.util.LinkedList;
import java.util.Queue;

class Collector {

	private Queue<Block> queue;
	
	private int size;

	public Collector(int size) {
		this.size = size;
		this.queue = new LinkedList<Block>();
	}

	public void add(Block block) throws InterruptedException {
		synchronized (this) {
			if (queue.size() >= this.size) {
				System.out.println(String.format("Thread: %s - Collector is full, waiting...", Thread.currentThread().getId()));
				wait();
			}
 			queue.add(block);
			notify();
		}
	}

	public Block take() throws InterruptedException {
		synchronized (this) {
			while(this.queue.size() == 0) {
				wait();
			}
			Block block = this.queue.poll();
			notify();
			return block;			
		}
	}
	
	
}
