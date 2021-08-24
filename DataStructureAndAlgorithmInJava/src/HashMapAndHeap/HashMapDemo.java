package HashMapAndHeap;

import java.util.*;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("India", 135);
		hm.put("China", 150);
		hm.put("Pakistan", 30);
		hm.put("USA", 35);
		hm.put("UK", 15);

		System.out.println(hm);

		hm.put("Sri Lanka", 5);
		hm.put("India", 140);

		System.out.println(hm);

		System.out.println(hm.get("India"));
		System.out.println(hm.get("USA"));

		System.out.println(hm.containsKey("China"));
		System.out.println(hm.containsKey("Canada"));

		Set<String> keys = hm.keySet();
		System.out.println(keys);

		for (String key : keys) {
			int v = hm.get(key);
			System.out.println(key + " " + v);
		}

	}

}
