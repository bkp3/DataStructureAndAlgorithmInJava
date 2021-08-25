package HashMapAndHeap;

import java.util.*;
import java.io.*;

/*
i/p->

4
5
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39

o/p->

*/

public class MergeKsortedLists {

	static class Pair implements Comparable<Pair>{
		int li;
		int di;
		int val;

		Pair(int li, int di, int val) {
			this.li = li;
			this.di = di;
			this.val = val;
		}

		@Override
		public int compareTo(Pair o) {
			return this.val - o.val;
		}
	}
	
	public static ArrayList<Integer> fun(ArrayList<ArrayList<Integer>>lists){
		ArrayList<Integer>rv=new ArrayList<>();
		
		PriorityQueue<Pair>pq=new PriorityQueue<>();
		for(int i=0;i<lists.size();i++) {
			pq.add(new Pair(i,0,lists.get(i).get(0)));
		}
		
		while(!pq.isEmpty()) {
			Pair p = pq.remove();
			rv.add(p.val);
			p.di++;
			
			if(p.di < lists.get(p.li).size()) {
				p.val=lists.get(p.li).get(p.di);
				pq.add(p);
			}
		}
		
		
		return rv;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			String[] elements = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				list.add(Integer.parseInt(elements[j]));
			}
			lists.add(list);
		}

		ArrayList<Integer> ans = fun(lists);
		System.out.println(ans);

	}

}
