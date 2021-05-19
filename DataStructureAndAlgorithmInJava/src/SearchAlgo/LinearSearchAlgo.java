package SearchAlgo;
import java.util.*;

public class LinearSearchAlgo {

	private static int N;
	private static int arr[];
	
	public LinearSearchAlgo(int n) {
		this.N=n;
		arr=new int[N];
	}
	
	public boolean isAvail(int key) {
		for(int i=0;i<N;i++) {
			if(arr[i]==key) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		LinearSearchAlgo obj = new LinearSearchAlgo(n);
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		
		
		if(obj.isAvail(5)) {
			System.out.println("Number founded...");
		}else {
			System.out.println("Number not founded...");
		}
		

	}

}
