package PriorityQueue;

import java.util.*;

/*

-------------for min heap--------------
3
3
3
2
2
[2, 3, 4, 5, 7]
-------------for max heap--------------
3
5
5
5
7
[7, 5, 4, 2, 3]

*/


public class PriorityQueueCollection {

	private static PriorityQueue<Integer> minHeap;
	private static PriorityQueue<Integer> maxHeap;

	private static int N;

	public PriorityQueueCollection(int n) {
		this.N = n;
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 4, 2, 7 };
		PriorityQueueCollection obj = new PriorityQueueCollection(arr.length);

		System.out.println("-------------for min heap--------------");
		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			System.out.println(minHeap.peek());
		}
		System.out.println(minHeap);

		System.out.println("-------------for max heap--------------");
		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(arr[i]);
			System.out.println(maxHeap.peek());
		}
		System.out.println(maxHeap);

	}
}
