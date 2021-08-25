package HashMapAndHeap;

import java.util.*;

public class HeapDemo {

	public static void main(String[] args) {
		int[] ranks = { 22, 99, 3, 11, 88, 4, 1 };

		// increasing order { 1 3 4 11 22 88 99 }
		// PriorityQueue<Integer> pq = new PriorityQueue<>();

		// decreasing order { 99 88 22 11 4 3 1 }
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int val : ranks) {
			pq.add(val);
		}

		while (!pq.isEmpty()) {
			System.out.print(pq.peek() + " ");
			pq.poll();
		}

	}

}
