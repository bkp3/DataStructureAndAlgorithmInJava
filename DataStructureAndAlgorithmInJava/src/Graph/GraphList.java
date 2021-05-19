package Graph;
import java.util.*;
public class GraphList {

	private static int N;
	private static int E;
	private static LinkedList<Integer>adj[];
	
	public GraphList(int n, int e) {
		this.N=n;
		this.E=e;
		this.adj=new LinkedList[n];
		for(int i=0;i<n;i++) {
			adj[i]=new LinkedList<>();
		}
	}
	
	public void addEdges(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	public void print() {
		for(int i=0;i<N;i++) {
			System.out.print(i+"---> ");
			for(int x:adj[i]) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		GraphList obj = new GraphList(n,e);
		
		for(int i=0;i<e;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			obj.addEdges(x, y);
		}
		
		obj.print();

	}

}
