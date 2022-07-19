package QueueMust;

import java.util.*;

public class MaximumOfAllSubarraysOfSizeK {

	static ArrayList<Integer> usingDeque(int[] arr, int n, int k) {
		ArrayList<Integer> ans = new ArrayList<>();

		Deque<Integer> dq = new LinkedList<Integer>();

		for (int i = 0; i < k; ++i) {
			while (dq.size() > 0) {
				if (arr[i] >= arr[dq.peekLast()]) {
					dq.removeLast();
				}
			}

			dq.addLast(i);
		}
		for (int i = k; i < n; ++i) {
			ans.add(arr[dq.peek()]);
			
			while ((!dq.isEmpty()) && dq.peek() <= i - k)
				dq.removeFirst();
			while ((!dq.isEmpty()) && arr[i] >= arr[dq.peekLast()])
				dq.removeLast();
			dq.addLast(i);
		}
		ans.add(arr[dq.peek()]);
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int k = 3;
		int n = arr.length;

		ArrayList<Integer> ans = usingDeque(arr, n, k);
		System.out.println(ans);

	}

}
