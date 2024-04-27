package LinkedList;

/*
Linked List is:- 11 11 11 21 43 43 60 
Linked List is:- 11 21 43 60 
 

*/
import java.util.*;

public class RemoveDuplicateInSotedList {

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

	public void fun() {
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.data == cur.next.data) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}

	}

	public static void main(String[] args) {
		RemoveDuplicateInSotedList obj = new RemoveDuplicateInSotedList();
		obj.head = new ListNode(11);
		ListNode second = new ListNode(11);
		ListNode third = new ListNode(11);
		ListNode fourth = new ListNode(21);
		ListNode five = new ListNode(43);
		ListNode six = new ListNode(43);
		ListNode seven = new ListNode(60);

		Scanner sc = new Scanner(System.in);

		// ow we will connect them together to form a chain
		obj.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = five;
		five.next = six;
		six.next = seven;

		// Display the list
		obj.display();
		obj.fun();
		obj.display();

	}

}
