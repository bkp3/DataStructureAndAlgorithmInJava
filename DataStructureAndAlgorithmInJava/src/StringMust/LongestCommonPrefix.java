package StringMust;

//gee

public class LongestCommonPrefix {
	static class Trie {
		char c;
		Trie[] children = new Trie[26];
		int count;

	}

	public static void main(String[] args) {
		String[] arr = { "geeksforgeeks", "geeks", "geek", "geezer" };
		int n = arr.length;

		Trie root = new Trie();
		Trie head = root;
		String ans = "";

		for (int i = 0; i < n; i++) {
			root = head;
			for (int j = 0; j < arr[i].length(); j++) {

				Trie temp = root.children[arr[i].charAt(j) - 'a'];
				if (temp == null) {
					temp = new Trie();
					temp.c = arr[i].charAt(j);
				}

				temp.count++;
				root.children[arr[i].charAt(j) - 'a'] = temp;

				if (temp.count == n) {
					ans = ans + temp.c;
				}
				root = temp;
			}

		}

		if (ans.length() > 0) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}

	}

}
