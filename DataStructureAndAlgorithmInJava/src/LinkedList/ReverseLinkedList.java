package LinkedList;

/*
Linked List is:- 4 8 11 20 29 
Linked List is:- 29 20 11 8 4 


*/
import java.util.*;
public class ReverseLinkedList {
	
	private ListNode head;
	
	private static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	//Display the list
	public void display() {
		System.out.print("Linked List is:- ");
		ListNode current = head;
		while(current!=null) {
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
		
	}
	
	//Reversed the linkedlist
	public void reversed() {
		ListNode current=head;
		ListNode next=null;
		ListNode prev=null;
		
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
	}
	
	public static void main(String []args) {
		ReverseLinkedList obj=new ReverseLinkedList();
		obj.head = new ListNode(4);
		ListNode second = new ListNode(8);
		ListNode third = new ListNode(11);
		ListNode fourth = new ListNode(20);
		ListNode five = new ListNode(29);
		
		Scanner sc = new Scanner(System.in);
		
		// ow we will connect them together to form a chain
		obj.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = five;
		
		//Display the list
		obj.display();
		obj.reversed();
		obj.display();
		
		
		
		
	}

}
