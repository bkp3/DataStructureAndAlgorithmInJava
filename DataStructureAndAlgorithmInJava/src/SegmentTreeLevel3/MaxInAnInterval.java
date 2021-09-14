package SegmentTreeLevel3;

import java.util.*;
import java.io.*;

/*
i/p
8
8 7 4 2 5 3 1 10
4
0 7
0 3
2 7
1 6

o/p->
10
8
10
7
*/

public class MaxInAnInterval {
	static int[] tree;
	static int[] arr;

	MaxInAnInterval(int[] arr) {
		this.arr = arr;
		tree = new int[4 * arr.length];
		build(1, 0, arr.length - 1);
	}

	// building of segment tree
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

	// query function
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

	static int queryActual(int l, int r) {
		int ans = query(1, 0, arr.length - 1, l, r);
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] parts = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(parts[i]);
		}
		MaxInAnInterval obj = new MaxInAnInterval(arr);

		int q = Integer.parseInt(br.readLine());
		int[][] qarr = new int[q][2];
		for (int i = 0; i < q; i++) {
			String[] str = br.readLine().split(" ");
			qarr[i][0] = Integer.parseInt(str[0]);
			qarr[i][1] = Integer.parseInt(str[1]);
		}

		for (int i = 0; i < q; i++) {
			int ans = queryActual(qarr[i][0], qarr[i][1]);
			System.out.println(ans);
		}

	}

}
