package PriorityQueue;
import java.util.*;

public class MaxPQ {
	private int []heap;
	int n;
	public MaxPQ(int capacity) {
		heap=new int[capacity + 1];
		n=0;
	}
	
	public boolean isEmpty() {
		return n==0;
	}
	
	public int size() {
		return n;
	}
	
	public void insert(int x) {
		if(n==heap.length-1) {
			resize(2*heap.length);
		}
		n++;
		heap[n]=x;
		swim(n);
	}
	
	public void swim(int k) {
		while(k>1 && heap[k/2]<heap[k]) {
			int temp=heap[k];
			heap[k]=heap[k/2];
			heap[k/2]=temp;
			k=k/2;
		}
	}
	
	public void resize(int capacity) {
		int[] temp=new int[capacity];
		for(int i=0;i<heap.length;i++) {
			temp[i]=heap[i];
		}
		heap=temp;
	}
	
	public void printHeap() {
		for(int i=1;i<=n;i++) {
			System.out.print(heap[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		MaxPQ obj = new MaxPQ(3);
		System.out.println(obj.size());
		System.out.println(obj.isEmpty());
		
		obj.insert(4);
		obj.insert(5);
		obj.insert(2);
		obj.insert(6);
		obj.insert(1);
		obj.insert(3);
		
		System.out.println(obj.size());
		obj.printHeap();
	}
	

}
