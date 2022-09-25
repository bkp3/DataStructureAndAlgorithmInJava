package ArrayMust;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//3
public class MinimumPlatforms {

	static class Schedule implements Comparable<Schedule> {
		int at;
		int dt;

		Schedule(int at, int dt) {
			this.at = at;
			this.dt = dt;
		}

		@Override
		public int compareTo(Schedule o) {
			return this.at - o.at;
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
		int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

		ArrayList<Schedule> trains = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			trains.add(new Schedule(arr[i], dep[i]));
		}
		Collections.sort(trains);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(trains.get(0).dt);
		int count = 1;
		for (int i = 1; i < n; i++) {
			Schedule curr = trains.get(i);
			if (curr.at <= pq.peek()) {
				count++;
			} else {
				pq.poll();
			}
			pq.add(curr.dt);
		}
		System.out.println(count);

	}

}
