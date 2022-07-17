package LinkedList;

import java.util.Scanner;

public class DeleteWithoutHeadPointer {

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

	void deleteNode(ListNode del) {
		del.data = del.next.data;
		del.next = del.next.next;
	}

	public static void main(String[] args) {
		DeleteWithoutHeadPointer obj = new DeleteWithoutHeadPointer();
		obj.head = new ListNode(4);
		ListNode second = new ListNode(8);
		ListNode third = new ListNode(11);
		ListNode fourth = new ListNode(8);
		ListNode five = new ListNode(4);

		// ow we will connect them together to form a chain
		obj.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = five;

		// Display the list
		obj.display();

	}

}
