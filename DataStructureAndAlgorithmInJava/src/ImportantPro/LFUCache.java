package ImportantPro;

import java.util.*;
import java.util.Map.Entry;

/*
30
20
40
Freq : 1
1 -> 0 -> 0
1 -> 5 -> 50
Freq : 2
1 -> 0 -> 0
2 -> 4 -> 40
Freq : 3
1 -> 0 -> 0
3 -> 2 -> 25

*/

public class LFUCache {

	final int capacity;
	int curSize;
	int minFreq;
	HashMap<Integer, Node> cache;
	HashMap<Integer, DoubleLinkedList> freqMap;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.curSize = 0;
		this.minFreq = 0;
		this.cache = new HashMap<>();
		this.freqMap = new HashMap<>();
	}

	class Node {
		int k, v;
		int freq;
		Node next;
		Node prev;

		Node(int k, int v) {
			this.k = k;
			this.v = v;
			this.freq=1;
		}
	}

	class DoubleLinkedList {
		int size;
		Node head;
		Node tail;

		DoubleLinkedList() {
			this.size = 0;
			this.head = new Node(0, 0);
			this.tail = new Node(0, 0);
			head.next = tail;
			tail.prev = head;
		}

		void addNode(Node node) {
			Node nextNode = head.next;
			node.next = nextNode;
			node.prev = head;
			head.next = node;
			nextNode.prev = node;
			size++;
		}

		void removeNode(Node node) {
			
			Node prevNode = node.prev;
			Node nextNode = node.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			size--;
		}
	}

	int get(int key) {
		Node curNode = cache.get(key);
		if (curNode == null) {
			return -1;
		}
		updateNode(curNode);
		return curNode.v;
	}

	void updateNode(Node node) {
		int curFreq = node.freq;
		DoubleLinkedList curList = freqMap.get(curFreq);
		curList.removeNode(node);

		if (curFreq == minFreq && curList.size == 0) {
			minFreq++;
		}

		node.freq++;

		DoubleLinkedList newList = freqMap.getOrDefault(node.freq, new DoubleLinkedList());
		newList.addNode(node);
		freqMap.put(node.freq, newList);
	}

	void put(int key, int value) {
		if (capacity == 0) {
			return;
		}
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			node.v = value;
			updateNode(node);
		} else {
			curSize++;
			if (curSize > capacity) {
				// get minimum frequency list
				DoubleLinkedList minFreqList = freqMap.get(minFreq);
				cache.remove(minFreqList.tail.prev.k);
				minFreqList.removeNode(minFreqList.tail.prev);
				curSize--;
			}
			// reset min frequency to 1 because adding new node
			minFreq = 1;
			Node newNode = new Node(key, value);

			// get the list with frequency 1, and then add new node into the list, as well
			// as into LFU cache
			DoubleLinkedList curList = freqMap.getOrDefault(1, new DoubleLinkedList());
			curList.addNode(newNode);
			freqMap.put(1, curList);
			cache.put(key, newNode);
		}
	}

	void display() {
		for (Entry<Integer, DoubleLinkedList> e : freqMap.entrySet()) {
			System.out.println("Freq : " + e.getKey());
			DoubleLinkedList head = e.getValue();
			Node cur = head.head;
			while (cur.next != null) {
				System.out.println(cur.freq + " -> " + cur.k + " -> " + cur.v);
				cur = cur.next;
			}
		}
	}

	public static void main(String[] args) {

		LFUCache obj = new LFUCache(3);
		obj.put(1, 10);
		obj.put(2, 20);
		obj.put(3, 30);
		obj.put(4, 40);
		System.out.println(obj.get(3));
		System.out.println(obj.get(2));
		System.out.println(obj.get(4));
		obj.put(5, 50);
		obj.put(2, 25);

		obj.display();

	}

}
