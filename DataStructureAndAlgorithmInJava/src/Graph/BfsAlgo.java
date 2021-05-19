/*

4 6
0 1
0 2
1 2
2 0
2 3
3 3

output:--
2 0 3 1 


*/


package Graph;
import java.util.*;

public class BfsAlgo {
	
	private static int V;
	private static int E;
	private static ArrayList<Integer>adj[];
	boolean[] visited;
	Queue<Integer>q;
	
	public BfsAlgo(int n, int e) {
		this.V=n;
		this.E=e;
		adj=new ArrayList[V];
		for(int i=0;i<V;i++) {
			adj[i]=new ArrayList<>();
		}
		visited = new boolean[V];
		q=new LinkedList<>();
	}
	
	
	
	public void print() {
		for(int i=0;i<V;i++) {
			System.out.print(i+" ---> ");
			for(int x:adj[i]) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
	
	public void bfs(int src) {
		
		visited[src]=true;
		q.offer(src);
		while(!q.isEmpty()) {
			int u=q.poll();
			System.out.print(u+" ");
			for(int v:adj[u]) {
				if(!visited[v]) {
					visited[v]=true;
					q.offer(v);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		BfsAlgo obj = new BfsAlgo(n,e);

		for(int i=0;i<e;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			adj[x].add(y);
		}
		
		//obj.print();
		obj.bfs(2);
	}

}
