package StackPackage;

import java.util.*;
/*
3
2
1

*/

public class GetMin {

	Stack<Integer> st = new Stack<>();

	public int getMinFun() {
		if (st.isEmpty()) {
			return -1;
		}

		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.addAll(st);
		int min = arr.get(0);
		for (int x : arr) {
			if (x < min) {
				min = x;
			}
		}
		return min;
	}

	public int popFun() {
		if (st.isEmpty()) {
			return -1;
		}
		return st.pop();
	}

	public void pushFun(int x) {
		st.push(x);
	}

	public static void main(String[] args) {
		GetMin obj = new GetMin();
		obj.pushFun(2);
		obj.pushFun(3);
		System.out.println(obj.popFun());
		System.out.println(obj.getMinFun());
		obj.pushFun(1);
		System.out.println(obj.getMinFun());

	}

}
