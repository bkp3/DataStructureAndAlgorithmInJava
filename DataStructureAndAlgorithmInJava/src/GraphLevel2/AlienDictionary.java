package GraphLevel2;

import java.io.*;
import java.util.*;
/*
i/p->
5
wrt wrf er ett rftt


o/p->
wertf

*/

public class AlienDictionary {

	static String alienOrder(ArrayList<String> words) {
		HashMap<Character, HashSet<Character>> map = new HashMap<>();
		HashMap<Character, Integer> indegree = new HashMap<>();

		for (String st : words) {
			for (char ch : st.toCharArray()) {
				indegree.put(ch, 0);
			}
		}

		for (int i = 0; i < words.size() - 1; i++) {
			String curr = words.get(i);
			String next = words.get(i + 1);
			int len = Math.min(curr.length(), next.length());
			boolean flag = false;

			for (int j = 0; j < len; j++) {
				char ch1 = curr.charAt(j);
				char ch2 = next.charAt(j);

				if (ch1 != ch2) {
					HashSet<Character> set = new HashSet<>();
					if (map.containsKey(ch1) == true) {
						set = map.get(ch1);
						if (set.contains(ch2) == false) {
							set.add(ch2);
							indegree.put(ch2, indegree.get(ch2) + 1);
							map.put(ch1, set);
						}
					} else {
						set.add(ch2);
						indegree.put(ch2, indegree.get(ch2) + 1);
						map.put(ch1, set);
					}
					flag = true;
					break;

				}
			}
			if (flag == false && curr.length() > next.length()) {
				return "";
			}
		}

		// kahns Algorithm
		Queue<Character> q = new LinkedList<>();
		StringBuilder ans = new StringBuilder();

		for (char ch : indegree.keySet()) {
			if (indegree.get(ch) == 0) {
				q.add(ch);
			}
		}

		int count = 0;
		while (q.size() > 0) {
			char rem = q.remove();
			ans.append(rem);
			count++;

			if (map.containsKey(rem) == true) {
				for (char nbr : map.get(rem)) {
					indegree.put(nbr, indegree.get(nbr) - 1);
					if (indegree.get(nbr) == 0) {
						q.add(nbr);
					}
				}
			}
		}

		if (count == indegree.size()) {
			return ans.toString();
		} else {
			return "";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<>();
		String[] parts = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr.add(parts[i]);
		}

		/*
		 * for (String str : arr) { System.out.print(str + " "); } System.out.println();
		 * Collections.sort(arr); for (String str : arr) { System.out.print(str + " ");
		 * }
		 */

		String ans = alienOrder(arr);
		System.out.println(ans);
	}

}