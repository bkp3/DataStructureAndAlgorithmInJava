package SegmentTreeLevel3;

import java.util.*;
import java.io.*;

/*
i/p->
4
1 2 3 4
10
1 0 3
0 1 3
1 0 3
1 1 2
0 2 5
1 2 2
1 2 3
1 0 1
1 0 2
1 1 3

o/p->
1 2 3 4 ans:- 4
1 3 3 4 ans:- 4
1 3 3 4 ans:- 3
1 3 5 4 ans:- 5
1 3 5 4 ans:- 5
1 3 5 4 ans:- 3
1 3 5 4 ans:- 5
1 3 5 4 ans:- 5
*/

public class MaxRangeUpdate {
	static int[] tree;
	static int[] arr;

	MaxRangeUpdate(int[] arr) {
		this.arr = arr;
		tree = new int[4 * arr.length];
		build(1, 0, arr.length - 1);
	}

	static void build(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			int left = node * 2;
			int right = node * 2 + 1;
			build(left, start, mid);
			build(right, mid + 1, end);
			tree[node] = Math.max(tree[left], tree[right]);
		}
	}

	static int query(int node, int start, int end, int l, int r) {
		if (end < l || r < start) {
			return Integer.MIN_VALUE;
		}
		if (start == end) {
			return tree[node];
		} else if (l <= start && end <= r) {
			return tree[node];
		} else {
			int mid = (start + end) / 2;
			int left = query(node * 2, start, mid, l, r);
			int right = query(node * 2 + 1, mid + 1, end, l, r);
			return Math.max(left, right);
		}
	}

	static void update(int node, int start, int end, int pos, int val) {
		if (start == end) {
			arr[start] = val;
			tree[node] = val;
		} else {
			int mid = (start + end) / 2;
			if (start <= pos && pos <= mid) {
				update(node * 2, start, mid, pos, val);
			} else {
				update(node * 2 + 1, mid + 1, end, pos, val);
			}
			tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
		}
	}

	static int queryActual(int l, int r) {
		int ans = query(1, 0, arr.length - 1, l, r);
		return ans;
	}

	static void updateActual(int pos, int val) {
		update(1, 0, arr.length - 1, pos, val);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] parts = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(parts[i]);
		}
		MaxRangeUpdate obj = new MaxRangeUpdate(arr);

		int q = Integer.parseInt(br.readLine());
		int[][] qarr = new int[q][3];
		for (int i = 0; i < q; i++) {
			String[] str = br.readLine().split(" ");
			qarr[i][0] = Integer.parseInt(str[0]);
			qarr[i][1] = Integer.parseInt(str[1]);
			qarr[i][2] = Integer.parseInt(str[2]);
		}

		for (int i = 0; i < q; i++) {
			if (qarr[i][0] == 1) {
				int ans = queryActual(qarr[i][1], qarr[i][2]);
				for (int j = 0; j < n; j++) {
					System.out.print(arr[j] + " ");
				}
				System.out.println("ans:- " + ans);
			} else {
				updateActual(qarr[i][1], qarr[i][2]);
			}
		}

	}

}
