package StringZone;

import java.util.HashMap;
import java.util.Map;

public class IndexFirstNonRepeatingCharacter {

	static int fun(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
				return i;
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		String str = "ababdbafd";
		System.out.println(fun(str));
		
		int n = str.length();
		Map<Character, Integer> mp = new HashMap<>();
		for (char c : str.toCharArray()) {
			if (mp.containsKey(c)) {
				mp.put(c, mp.get(c) + 1);
			} else {
				mp.put(c, 1);
			}
		}

		for (int i = 0; i < n; i++) {
			if (mp.get(str.charAt(i)) == 1) {
				System.out.print(i);
				return;
			}
		}
		System.out.println("-1");

	}

}
