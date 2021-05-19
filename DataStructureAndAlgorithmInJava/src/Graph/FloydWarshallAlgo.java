package Graph;
import java.util.*;
public class FloydWarshallAlgo {

	private static int N;
	private static final int INF=987654321;
	private static int dist[][];
	
	public FloydWarshallAlgo(int n) {
		this.N=n;
		dist=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dist[i][j]=INF;
			}
		}
	}
	
	public void floyd() {
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		FloydWarshallAlgo obj = new FloydWarshallAlgo(n);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dist[i][j]=sc.nextInt();
			}
		}
		
		obj.floyd();
		
		System.out.println("Shortest distance paths:- ");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(dist[i][j]==INF) {
					System.out.print("INF ");
				}else {
					System.out.print(dist[i][j]+"  ");
				}
			}
			System.out.println();
		}

	}

}
