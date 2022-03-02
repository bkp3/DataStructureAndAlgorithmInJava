package StringZone;

import java.util.*;

/*
{
1=[a, b, c], 
2=[aa, ab, bc, ac], 
3=[aac, aab, abc], 
4=[aabc]
}

*/
public class SubsequenceOfString {

	public static void main(String[] args) {
		String str = "aabc";
		int n = str.length();

		int limit = (int) Math.pow(2, n);

		HashMap<Integer, HashSet<String>> mp = new HashMap<>();

		for (int i = 1; i <= limit - 1; i++) {
			String sub = "";
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					sub = sub + str.charAt(j);
				}
			}
			if (!mp.containsKey(sub.length())) {
				mp.put(sub.length(), new HashSet<>());
			}
			mp.get(sub.length()).add(sub);
		}
		System.out.println(mp);

	}

}
