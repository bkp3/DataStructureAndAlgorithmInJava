package ArrayMust;

import java.util.ArrayList;

//0 -> 3
//4 -> 6

public class StockBuySell {

	static class Pair {
		int buy;
		int sell;

		Pair(int buy, int sell) {
			this.buy = buy;
			this.sell = sell;
		}

		public Pair() {
		}
	}

	public static void main(String[] args) {
		int n = 7;
		int[] arr = { 100, 180, 260, 310, 40, 535, 695 };

		ArrayList<Pair> ans = new ArrayList<>();
		int i = 0;
		while (i < n - 1) {
			while ((i < n - 1) && (arr[i + 1] <= arr[i]))
				i++;

			if (i == n - 1)
				break;

			Pair p = new Pair();
			p.buy = i++;

			while ((i < n) && (arr[i] >= arr[i - 1]))
				i++;

			p.sell = i - 1;
			ans.add(p);

		}

		for (Pair p : ans) {
			System.out.println(p.buy + " -> " + p.sell);
		}

	}

}
