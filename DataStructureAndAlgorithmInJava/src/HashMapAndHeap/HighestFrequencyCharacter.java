package HashMapAndHeap;

import java.util.*;

/*
i/o -> abrakadabra

{a=5, b=2, r=2, d=1, k=1}
a -> 5


*/
public class HighestFrequencyCharacter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (hm.containsKey(c)) {
				int x = hm.get(c);
				x++;
				hm.put(c, x);
			} else {
				hm.put(c, 1);
			}
		}
		System.out.println(hm);

		char ch = str.charAt(0);
		int max = Integer.MIN_VALUE;
		for (Character c : hm.keySet()) {
			if (max < hm.get(c)) {
				max = hm.get(c);
				ch = c;
			}
		}

		System.out.println(ch + " -> " + max);

	}

}
