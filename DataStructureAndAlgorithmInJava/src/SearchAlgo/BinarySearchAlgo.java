package SearchAlgo;
import java.util.*;

public class BinarySearchAlgo {

	private static int N;
	private static int arr[];
	
	public BinarySearchAlgo(int n) {
		this.N=n;
		arr=new int[N];
	}
	
	public int isAvail(int key) {
		int low=0;
		int high=N-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(arr[mid]==key) {
				return mid;
			}
			if(key<arr[mid]) {
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		BinarySearchAlgo obj = new BinarySearchAlgo(n);
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		if(obj.isAvail(6)!=-1) {
			System.out.println("Element founds at index "+obj.isAvail(6));
		}else {
			System.out.println("Element not found.");
		}

	}

}
