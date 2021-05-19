package Graph;

public class GraphMat {
	
	private int V; //number of vertices of graph
	private int E; //number of edges of graph
	private int [][]mat;
	
	public GraphMat(int n) {
		this.V=n;
		this.E=0;
		this.mat=new int[n][n];
	}
	
	public void addEdge(int u, int v) {
		this.mat[u][v]=1;
		this.mat[v][u]=1;
		E++;
	}
	
	public void disp() {
		System.out.println("Graph elements are:- ");
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		GraphMat g = new GraphMat(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		
		g.disp();

	}

}
