package LinkedList;

/*
Linked List is:- 4 8 11 20 29 
nth node from last :-
20

*/
import java.util.*;

public class NthFromLast {

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

	public void getNthFromLast(int n) {
		if (head == null) {
			return;
		}

		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			len++;
			temp = temp.next;
		}

		if (len < n) {
			return;
		}
		int m = len - n;
		ListNode current = head;
		while (m-- > 0) {
			current = current.next;
		}
		System.out.println(current.data);

	}

	public static void main(String[] args) {
		NthFromLast obj = new NthFromLast();
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

		// Display the list
		obj.display();
		System.out.println("nth node from last :-");
		obj.getNthFromLast(2);

	}

}
