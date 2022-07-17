package StackPackage;

import java.util.*;

/*

1
1
false


*/
public class QueueUsingStack {
	Stack<Integer> st = new Stack();

	public void push(int x) {
		Stack<Integer> temp = new Stack<>();
		while (!st.isEmpty()) {
			temp.add(st.pop());
		}
		temp.add(x);
		while (!temp.isEmpty()) {
			st.add(temp.pop());
		}
	}

	public int pop() {
		return st.pop();
	}

	public int peek() {
		return st.peek();
	}

	public boolean empty() {
		return st.isEmpty();
	}

	public static void main(String[] args) {
		QueueUsingStack obj = new QueueUsingStack();

		obj.push(1);
		obj.push(2);
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.empty());

	}

}
