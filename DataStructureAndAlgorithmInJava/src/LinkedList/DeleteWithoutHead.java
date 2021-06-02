package LinkedList;

/*
Linked List is:- 4 8 11 20 29 
delete node without head pointer :- 
Linked List is:- 4 8 20 29 

*/
import java.util.*;

public class DeleteWithoutHead {

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

	// delete node without head pointer
	public void deleteNode(ListNode node) {
		if (node.next == null) {
			return;
		}
		node.data = node.next.data;
		node.next = node.next.next;
		return;
	}

	public static void main(String[] args) {
		DeleteWithoutHead obj = new DeleteWithoutHead();
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
		System.out.println("delete node without head pointer :- ");
		obj.deleteNode(third);
		obj.display();

	}

}
