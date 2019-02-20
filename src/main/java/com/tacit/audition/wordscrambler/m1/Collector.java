package com.tacit.audition.wordscrambler.m1;

import java.util.LinkedList;
import java.util.Queue;

public class Collector {

	private Queue<String> queue;
	private int size;

	public Collector(int size) {
		this.size = size;
		this.queue = new LinkedList<String>();
	}

	public void add(String block) throws InterruptedException {
		synchronized (this) {
			if (queue.size() >= this.size) {
				System.out.println(String.format("Thread:%s - Collector is full, waiting...", Thread.currentThread().getId()));
				wait();
			}
 			queue.add(block);
			notify();
		}
	}

	public String take() throws InterruptedException {
		synchronized (this) {
			while(this.queue.size() == 0) {
				wait();
			}
			String block = this.queue.poll();
			notify();
			return block;			
		}
	}

}
