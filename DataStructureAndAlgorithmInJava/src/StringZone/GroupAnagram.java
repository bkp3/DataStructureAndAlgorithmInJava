package StringZone;

import java.util.*;

/*
input:-
{ "cat", "dog", "tac", "god", "act" };
output:-
act --> [cat, tac, act]
dgo --> [dog, god]

*/
public class GroupAnagram {

	public static void main(String[] args) {
		String[] words = { "cat", "dog", "tac", "god", "act" };

		HashMap<String, ArrayList<String>> mp = new HashMap<>();

		for (String x : words) {
			char[] arr = x.toCharArray();
			Arrays.sort(arr);
			String temp = new String(arr);
			if (mp.containsKey(temp)) {
				ArrayList<String> al = mp.get(temp);
				al.add(x);
				mp.put(temp, al);
			} else {
				ArrayList<String> al = new ArrayList<>();
				al.add(x);
				mp.put(temp, al);
			}

		}

		for (Map.Entry<String, ArrayList<String>> e : mp.entrySet()) {
			System.out.println(e.getKey() + " --> " + e.getValue());
		}

	}

}
