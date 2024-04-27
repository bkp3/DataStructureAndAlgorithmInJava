package StackPackage;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	static Queue<Integer> q1 = new LinkedList<>();
	static Queue<Integer> q2 = new LinkedList<>();
	static int cur_size;

	static void push(int x) {
		q2.add(x);
		while (!q1.isEmpty()) {
			q2.add(q1.peek());
			q1.remove();
		}
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
	}

	static void pop() {
		if (q1.isEmpty()) {
			return;
		}
		q1.remove();
	}

	static int top() {
		if (q1.isEmpty()) {
			return -1;
		}
		return q1.peek();
	}

	static int size() {
		return q1.size();
	}

	public static void main(String[] args) {
		StackUsingQueue obj = new StackUsingQueue();
		push(1);
		push(2);
		push(3);
		System.out.println(size());
		System.out.println(top());
		pop();

	}

}
