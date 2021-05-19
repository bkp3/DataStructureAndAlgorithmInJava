package Stack;
import java.util.*;

public class Stack {
	
	private ListNode top;
	private int length;
	
	private class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data){
			this.data=data;
		}
	}
	
	public Stack(){
		top = null;
		length = 0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void push(int data) {
		ListNode temp = new ListNode(data);
		temp.next=top;
		top=temp;
		length++;
		return;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return -1;
		}
		int result = top.data;
		top=top.next;
		length--;
		return result;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return -1;
		}
		return top.data;
	}
	
	public int[] revArray(int arr[]) {
		Stack st = new Stack();
		for(int x: arr) {
			st.push(x);
		}
		for(int i=0;i<arr.length;i++) {
			arr[i]=st.pop();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Stack obj = new Stack();
		Scanner sc = new Scanner(System.in);
//		obj.push(10);
//		obj.push(20);
//		obj.push(30);
//		
//		System.out.println(obj.peek());
//		obj.pop();
//		System.out.println(obj.peek());
//		
		int arr[]= {1,2,3,4,5};
		int arr1[]=obj.revArray(arr);
		System.out.println("Reversed array is:- ");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		
	}

}
