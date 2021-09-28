package GraphSelf;

import java.io.*;
import java.util.*;

/*

there are n words and k starting alphabets of standard dictionary.
we have find the order of characters in the alien language.

i/p->
5
4
baa abcd abca cab cad
o/p->
bdac

i/p->
3
3
caa aaa aab
o/p->
cab

*/
public class AlienDictionary {

	public static void topo(ArrayList<Integer>[] adj, int src, boolean[] visited, Stack<Integer> st) {
		visited[src] = true;
		for (int x : adj[src]) {
			if (visited[x] == false) {
				topo(adj, x, visited, st);
			}
		}
		st.add(src);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		String[] dict = br.readLine().split(" ");

		ArrayList<Integer> adj[] = new ArrayList[k];
		for (int i = 0; i < k; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			String word1 = dict[i];
			String word2 = dict[i + 1];
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					adj[word1.charAt(j) - 'a'].add(word2.charAt(j) - 'a');
					break;
				}
			}
		}

		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[adj.length];

		for (int i = 0; i < adj.length; i++) {
			if (visited[i] == false) {
				topo(adj, i, visited, st);
			}
		}
		String ans = "";
		while (st.size() > 0) {
			ans = ans + (char) ('a' + st.pop());
			// System.out.println((char) ('a' + st.pop()));
		}
		System.out.println(ans);

	}

}
