package HashMapAndHeap;

import java.util.*;

/*

8
2 10 5 17 7 18 6 4
3

*/
public class KthLargestElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			arr.add(x);
		}
		int k = sc.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			if (i < k) {
				pq.add(arr.get(i));
			} else {
				if (arr.get(i) > pq.peek()) {
					pq.remove();
					pq.add(arr.get(i));
				}
			}
		}
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}

	}

}
