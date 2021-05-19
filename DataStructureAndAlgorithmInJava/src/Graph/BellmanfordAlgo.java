// wormhole

package Graph;
import java.util.*;
public class BellmanfordAlgo {
	
	private static int V,E;
	private static int dist[];
	private static ArrayList<Node>adjList[];
	private static final int INF=987654321;
	
	public BellmanfordAlgo(int n,int e) {
		this.V=n;
		this.E=e;
		dist=new int[V];
		adjList = new ArrayList[V];
		for(int i=0;i<V;i++) {
			adjList[i]=new ArrayList<>();
		}
		for(int i=0;i<V;i++) {
			dist[i]=INF;
		}
	}
	
	static class Node{
		int idx;
		int cost;
		public Node(int idx,int cost) {
			super();
			this.idx=idx;
			this.cost=cost;
		}
	}
	
	public boolean bellman() {
		dist[1]=0;
		boolean isUpdated=false;
		for(int i=1;i<=V;i++) {
			isUpdated=false;
			for(int here=1;here<=V;here++) {
				for(Node node:adjList[here]) {
					int nextIdx=node.idx;
					int nextCost=node.cost;
					if(dist[nextIdx] > dist[here]+nextCost) {
						dist[nextIdx]=dist[here]+nextCost;
						isUpdated=true;
					}
				}
			}
			if(!isUpdated) {
				break;
			}
		}
		if(isUpdated) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		int w=sc.nextInt();
		BellmanfordAlgo obj = new BellmanfordAlgo(n, e);
		
		for(int i=0;i<e;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			adjList[a].add(new Node(b,c));
			adjList[b].add(new Node(a,c));
		}
		
		for(int i=0;i<w;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			adjList[a].add(new Node(b,-c));
		}
		
		boolean ans=obj.bellman();
		if(ans) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		

	}

}
