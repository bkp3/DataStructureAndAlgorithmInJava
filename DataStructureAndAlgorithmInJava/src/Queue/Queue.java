package Queue;
import java.util.*;

public class Queue {
	
	private ListNode front;
	private ListNode rear;
	private int length;
	
	private class ListNode{
		private int data;
		private ListNode next;
		public ListNode(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	public Queue() {
		this.front=null;
		this.rear=null;
		this.length=0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		ListNode current = front;
		while(current!=null) {
			System.out.print(current.data+" ");
			current=current.next;
		}
		return;
	}
	
	public void enqueue(int data) {
		ListNode temp = new ListNode(data);
		if(isEmpty()) {
			front=temp;
		}else {
			rear.next=temp;
		}
		rear=temp;
		length++;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		int result = front.data;
		front=front.next;
		if(front==null) {
			rear=null;
		}
		length--;
		return result;
				
	}
	
	public static void main(String[] args) {
		Queue obj = new Queue();
		obj.enqueue(12);
		obj.enqueue(20);
		obj.enqueue(15);
		
		obj.print();
		
		System.out.println("Dequeue operation is:- "+obj.dequeue());
		obj.print();
	}

}
