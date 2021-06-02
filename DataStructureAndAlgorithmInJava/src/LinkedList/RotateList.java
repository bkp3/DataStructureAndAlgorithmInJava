package LinkedList;

/*
Linked List is:- 4 8 11 20 29 
Linked list after rotating by k elements :- 
Linked List is:- 20 29 4 8 11 

*/
import java.util.*;

public class RotateList {

	private ListNode head;

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Display the list
	public void display() {
		System.out.print("Linked List is:- ");
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();

	}

	// Rotate the linkedlist by k elements
	public void rotateByK(int k) {
		if (head == null) {
			return;
		}

		ListNode current = head;
		ListNode temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		while (--k > 0) {
			current = current.next;
		}

		temp.next = head;
		head = current.next;
		current.next = null;
		return;
	}

	public static void main(String[] args) {
		RotateList obj = new RotateList();
		obj.head = new ListNode(4);
		ListNode second = new ListNode(8);
		ListNode third = new ListNode(11);
		ListNode fourth = new ListNode(20);
		ListNode five = new ListNode(29);

		// now we will connect them together to form a chain
		obj.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = five;

		// Display the list
		obj.display();
		System.out.println("Linked list after rotating by k elements :- ");
		obj.rotateByK(3);
		obj.display();

	}

}
