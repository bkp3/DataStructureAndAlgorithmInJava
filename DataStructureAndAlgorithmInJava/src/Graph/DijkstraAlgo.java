package Graph;

import java.util.*;

/*
5 6 0
0 1 9
0 2 6
0 3 5
0 4 3
2 1 2
2 3 4
The shorted path from node :
0 to 0 is 0
0 to 1 is 8
0 to 2 is 6
0 to 3 is 5
0 to 4 is 3
*/
public class DijkstraAlgo {
	
	private static int N,E;
	private static ArrayList<Node>adjList[];
	private static PriorityQueue<Node>q;
	private static int dist[];
	private static final int INF = 987654321;


	public DijkstraAlgo(int n, int e) {
		//this.N=n+1;		// for vertices start from 1
		this.N = n+1;
		this.E = e;
		adjList = new ArrayList[N];
		for(int i=0;i<N;i++) {
			adjList[i]=new ArrayList<>();
		}
		q = new PriorityQueue<>();
		dist=new int[N];
		for(int i=0;i<N;i++) {
			dist[i]=INF;
		}
		
	}
	
	static class Node implements Comparable<Node>{
		int dst;
		int wt;
		
		public Node() {}
		
		public Node(int dst, int wt) {
			this.dst=dst;
			this.wt=wt;
		}
		@Override
		public int compareTo(Node args) {
			return this.wt - args.wt;
		}
	}
	
	public void dijkstra(int src) {
		
		dist[src]=0;
		q.offer(new Node(src,0));

		while(!q.isEmpty()) {
			Node here=q.poll();

			for(int i=0;i<adjList[here.dst].size();i++) {
				Node a=adjList[here.dst].get(i);
				int there=a.dst;
				int nextdist=dist[here.dst] + a.wt;

				if(dist[there] == INF || dist[there] > nextdist) {
					dist[there]=nextdist;
					q.offer(new Node(there,nextdist));
				}
			
			}
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		int src=sc.nextInt();
		DijkstraAlgo obj = new DijkstraAlgo(n,e);
		
		for(int i=0;i<e;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			adjList[a].add(new Node(b,c));
		}
		
		obj.dijkstra(src);
		
		System.out.println("The shorted path from node :");
		/*
		 * for(int i=1;i<dist.length;i++) {
		 * System.out.println(src+" to "+i+" is "+dist[i]); }
		 */

		for(int i=0;i<N;i++) {
			System.out.println(src+" to "+i+" is "+dist[i]);
		}
	}

}
