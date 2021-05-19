package Array;
import java.util.*;

public class Array {
	private static int arr[];
	private int n;
	
	Array(int n){
		this.n = n;
		arr = new int[n];
	}
	
	public void printArray() {
		System.out.println("Elements in array are :- ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	
	public int minValue() {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(min>arr[i]) {
				min=arr[i];
			}
		}
		return min;
	}
	
	public int maxValue() {
	    int max=arr[0];
	    for(int i=0;i<n;i++){
	        if(max<arr[i]){
	            max=arr[i];
	        }
	    }
	    return max;
	}
	
	public void reverseArray() {
		for(int i=0;i<(n/2);i++) {
			int temp=arr[i];
			arr[i]=arr[n-i-1];
			arr[n-i-1]=temp;
		}
		return;
	}
	
	public boolean isPali() {
		for(int i=0;i<n/2;i++) {
			if(arr[i] != arr[n-i-1]) {
				return false;
			}
		}
		return true;
	}
	
	public int secondLargest() {
		int max=arr[0];
		int secMax=arr[0];
		for(int i=0;i<n;i++) {
			if(max<arr[i]) {
				secMax=max;
				max=arr[i];
			}else if(arr[i]>secMax && arr[i]!=max) {
				secMax=arr[i];
			}
		}
		return secMax;
	}
	
	public int[] twoSum(int target) {
		int result[] = new int[2];
		Map<Integer, Integer> mp =new HashMap<>();
		for(int i=0;i<n;i++) {
			if(!mp.containsKey(target-arr[i])) {
				mp.put(arr[i], i);
			}else {
				result[1]=i;
				result[0]=mp.get(target-arr[i]);
				return result;
			}
		}
		return result;
	}
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of an array :- ");
		int n = sc.nextInt();
		Array obj = new Array(n);
		System.out.println("Enter elements in array :- ");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		obj.printArray();
		
		//Minimum value of array
//		System.out.println("Minimum value is :- "+obj.minValue());
//
//		//Maximum value of array
//		System.out.println("Maximum value is :- "+obj.maxValue());
		
		//Reverse an array
//		System.out.println("Reverse Array :- ");
//		obj.reverseArray();
//		obj.printArray();
//		
		// Check array is palindromeor not
//		boolean b = obj.isPali();
//		if(b) {
//			System.out.println("Array is palindrome.");
//		}else {
//			System.out.println("Array is not palindrome.");
//		}
		
		//Second Maximum value of array
		//System.out.println("Second Maximum value is :- "+obj.secondLargest());
			
		//Two sum problems
		int res[] = obj.twoSum(21);
		System.out.println("Two index of two sum is:- "+res[0]+" and "+res[1]);
		
	}

}
