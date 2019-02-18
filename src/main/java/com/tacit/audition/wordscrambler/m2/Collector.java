package com.tacit.audition.wordscrambler.m2;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Collector {

	private Map<String, Queue<Block>> map;
	
	private int size;

	public Collector(int size) {

		this.size = size;
		this.map = new LinkedHashMap<String, Queue<Block>>();
		
	}

	public void add(Block block, String topic) throws InterruptedException {
		synchronized (this) {

			Queue<Block> queue = this.map.get(topic);
			if (queue==null) {
				queue = new LinkedList<Block>();
				map.put(topic, queue);
			}
			if (queue.size() >= this.size) {
				wait();
			}
 			queue.add(block);
			notify();
		}
	}

	public Block take(String topic) throws InterruptedException {
		synchronized (this) {
			
			
			while(!this.map.containsKey(topic) || this.map.get(topic).size() == 0) {
				wait();
			}
			
			Block block = this.map.get(topic).poll();
			notify();
			return block;			
			
		}
	}
	
	
	
}
