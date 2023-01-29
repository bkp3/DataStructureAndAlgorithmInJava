package ImportantPro;

import java.util.*;

/*

15
12
-1
0 -> 0
4 -> 25
2 -> 12
3 -> 15

*/
public class LRUCache {

	Node head = new Node(0, 0);
	Node tail = new Node(0, 0);
	HashMap<Integer, Node> mp = new HashMap<>();
	int capacity;

	class Node {
		Node prev, next;
		int k, v;

		Node(int k, int v) {
			this.k = k;
			this.v = v;
		}
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	int get(int key) {
		if (mp.containsKey(key)) {
			Node node = mp.get(key);
			remove(node);
			insert(node);
			return node.v;
		}
		return -1;
	}

	void put(int key, int value) {
		if (mp.containsKey(key)) {
			remove(mp.get(key));
		}
		if (mp.size() == capacity) {
			remove(tail.prev);
		}
		insert(new Node(key, value));
	}

	void remove(Node node) {
		mp.remove(node.k);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	void insert(Node node) {
		mp.put(node.k, node);
		Node headNext = head.next;
		head.next = node;
		node.prev = head;
		headNext.prev = node;
		node.next = headNext;
	}

	void display() {
		Node cur = head;
		while (cur.next != null) {
			System.out.println(cur.k + " -> " + cur.v);
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		LRUCache obj = new LRUCache(3);
		obj.put(1, 10);
		obj.put(3, 15);
		obj.put(2, 12);
		System.out.println(obj.get(3));
		obj.put(4, 20);
		System.out.println(obj.get(2));
		obj.put(4, 25);
		System.out.println(obj.get(10));
		obj.display();

	}

}
