package LinkedList;

/*
Linked List is:- 4 8 11 20 29 
nth node from last :-
20

*/
import java.util.*;

public class IntersectionPoint {

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

	// Intersection point in Y shapped linked list
	public int intersectPoint(ListNode head1, ListNode head2) {
		if (head1 == null && head2 == null) {
			return -1;
		}

		ListNode cur1 = head1;
		ListNode cur2 = head2;
		HashMap<ListNode, Boolean> mp = new HashMap<>();

		while (cur1 != null) {
			mp.put(cur1, true);
			cur1 = cur1.next;
		}

		while (cur2 != null) {
			if (mp.containsKey(cur2)) {
				return cur2.data;
			}
			cur2 = cur2.next;
		}
		return -1;

	}

	public static void main(String[] args) {
		IntersectionPoint obj = new IntersectionPoint();
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

	}

}
