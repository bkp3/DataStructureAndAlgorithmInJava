package ArrayMust;

import java.util.Comparator;
import java.util.PriorityQueue;
//7

public class KthSmallestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int arr[] = { 7, 10, 4, 3, 20, 15 };
		int k = 3;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		for (int i = k; i < n; i++) {
			if (arr[i] < pq.peek()) {
				pq.add(arr[i]);
				pq.remove();
			}
		}
		System.out.println(pq.peek());

	}

}
