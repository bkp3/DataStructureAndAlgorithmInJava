package LinkedList;

import java.util.*;
public class SinglyLinkedList {
	
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
	
	//Length of list
	public int lengthOfList() {
		
		if(head==null) {
			return 0;
		}
		int count = 0;
		ListNode current = head;
		while(current!=null) {
			count = count + 1;
			current = current.next;
		}
		return count;
	}
	
	//Insert node at the begining 
	public void insertAtTheBeginning(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head=newNode;
		return;
	}
	
	
	//Insert node at the end
	public void insertAtTheEnd(int value) {
		ListNode newNode = new ListNode(value);
		if(head==null) {
			head=newNode;
			return;
		}
		ListNode current = head;
		while(current.next!=null) {
			current=current.next;
		}
		current.next=newNode;
		return;
	}
	
	//Insert node at given position
	public void insertAtThePos(int value, int pos, int size) {
		if(pos>size) {
			System.out.println("Enter correct position");
			return;
		}
		ListNode newNode = new ListNode(value);
		if(pos==0) {
			newNode.next=head;
			head=newNode;
			return;
		}
		ListNode current = head;
		while(--pos!=0) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next=newNode;
		return;
	}
	
	//delete first node
	public void deleteAtFirst() {
		if(head==null) {
			return;
		}
		ListNode current = head;
		head=head.next;
		current.next=null;
		return;
	}
	
	
	//delete last node
	public void deleteAtLast() {
		if(head==null) {
			return;
		}
		if(head.next==null) {
			head=null;
			return;
		}
		ListNode prev = head;
		ListNode current = head;
		while(current.next!=null) {
			prev=current;
			current=current.next;
		}
		prev.next=null;
		return;
	}
	
	// delete node at the given position
	public void deleteAtGivenPos(int pos, int size) {
		if(pos>size) {
			System.out.println("Enter correct position");
			return;
		}
		if(head==null) {
			return;
		}
		if(head.next==null) {
			head=null;
			return;
		}
		if(pos==1) {
			ListNode temp = head;
			head = head.next;
			temp.next=null;
			return;
		}
		ListNode prev = head;
		ListNode current = head;
		while(--pos!=0) {
			prev=current;
			current=current.next;
		}
		prev.next = current.next;
		current.next=null;
		return;
			
	}
	
	// search an element
	public boolean searchAnElement(int value) {
		if(head==null) {
			return false;
		}
		ListNode current = head;
		while(current!=null) {
			if(current.data==value) {
				return true;
			}
			current=current.next;
		}
		return false;
	}
	
	
	//reverse linked list
	public void reverseList() {
		ListNode prev = null;
		ListNode nxt = null;
		ListNode current = head;
		while(current!=null) {
			nxt = current.next;
			current.next = prev;
			prev = current;
			current = nxt;
		}
		head = prev;
		return;
	}
	
	//find middle element
	public int findMiddle() {
		ListNode fast = head;
		ListNode slow = head;
		while(fast!= null && fast.next!=null) {
			slow = slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
	
	
	// find nth node from end
	public int findNthFromEnd(int n) {
		ListNode current = head;
		ListNode temp = head;
		while(--n!=0) {
			temp=temp.next;
		}
		while(temp.next!=null) {
			temp=temp.next;
			current=current.next;
		}
		return current.data;
	}
	
	// delete duplicates from sorted list
	public void deleteDuplicateFromSortedList() {
		ListNode current = head;
		while(current!=null && current.next!=null) {
			if(current.data == current.next.data) {
				current.next = current.next.next;
			}else {
				current=current.next;
			}
		}
		return;
	}
	
	// insert node in sorted linked list
	public void insertNodeInSortedList(int value) {
		if(head==null) {
			return;
		}
		
		ListNode newNode = new ListNode(value);
		
		if(head.data > newNode.data) {
			newNode.next = head;
			head=newNode;
			return;
		}
		
		ListNode current = head;
		ListNode prev = head;
		while(current!=null && current.data < newNode.data) {
			prev = current;
			current = current.next;
		}
		newNode.next = current;
		prev.next = newNode;
		return;
	}
	
	
	// remove node with the given key
	public void removeKey(int key) {
		if(head==null) {
			return;
		}
		if(head.data == key) {
			ListNode temp = head;
			head = head.next;
			temp.next=null;
		}
		
		ListNode prev = head;
		ListNode current = head;
		while(current!=null && current.data!=key) {
			prev=current;
			current=current.next;
		}
		if(current==null)
			return;
		prev.next = current.next;
		current.next=null;
		return;
		
	}
	
	
	// detect loop in linked list
	public boolean detectLoop() {
		if(head==null) {
			return false;
		}
		
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		while(fastPtr!=null && fastPtr.next!=null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String []args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(4);
		ListNode second = new ListNode(8);
		ListNode third = new ListNode(11);
		ListNode fourth = new ListNode(20);
		ListNode five = new ListNode(29);
		
		Scanner sc = new Scanner(System.in);
		
		// ow we will connect them together to form a chain
		sll.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = five;
		
		//Display the list
		sll.display();
		
		//Length of the list
		int length = sll.lengthOfList();
		System.out.println("Length of Linked List :- " + length);
		
//		//Add node at the begining
//		Scanner sc = new Scanner(System.in);
//		int value = sc.nextInt();
//		sll.insertAtTheBeginning(value);
//		
//		//Display list after adding at the begining
//		sll.display();
//		
		
		
//		//Add node at the end
//		
//		int value = sc.nextInt();
//		sll.insertAtTheEnd(value);
//		
//		//Display list after adding at the begining
//		sll.display();
		
//		//Add node at the given position
//		int val = sc.nextInt();
//		int pos = sc.nextInt();
//		sll.insertAtThePos(val, pos, sll.lengthOfList());
//		//Display list after adding at the given position
//		sll.display();
//		
//		sll.deleteAtFirst();
//		//Display list after deletd node at the begining
//		sll.display();
//		
		
		
//		sll.deleteAtLast();
//		//Display list after deletd node at the end
//		sll.display();
		
//		System.out.println("Enter position for deletion:- ");
//		int pos = sc.nextInt();
//		sll.deleteAtGivenPos(pos, sll.lengthOfList());
//		//Display list after deletd node at the givn position
//		sll.display();
//	
//		System.out.println("Enter value for search:- ");
//		int value = sc.nextInt();
//		boolean isAvailable = sll.searchAnElement(value);
//		if(isAvailable) {
//			System.out.println(value+" is present in list");
//		}else {
//			System.out.println(value+" is not present in list");
//		}
//		//Display list after deletd node at the givn position
//		sll.display();
	
//		sll.reverseList();
//		//Display list after reversing the list
//		sll.display();
//	
		
		// Middle node of linked list
//		int midNode = sll.findMiddle();
//		System.out.println("Middle element is :- "+midNode);
//		
		
//		System.out.println("Enter nth posiriton from end:- ");
//		int n = sc.nextInt();
//		int nthNode = sll.findNthFromEnd(n);
//		System.out.println("nth node from end is :- "+nthNode);
		
		//Remove duplicates from sorted list
//		sll.deleteDuplicateFromSortedList();
//		System.out.println("List after removal of duplicates in linked list:-");
//		sll.display();
		
//		//Add node in sorted linked list
//		System.out.println("Enter value for insertion :- ");
//		int value = sc.nextInt();
//		sll.insertNodeInSortedList(value);
//		System.out.println("List after adding the node in the sorted linked list :- ");
//		sll.display();
		
		//delete node in sorted linked list with given key
//		System.out.println("Enter key for deletion of node :- ");
//		int key = sc.nextInt();
//		sll.removeKey(key);
//		System.out.println("List after deleting the node in the sorted linked list :- ");
//		sll.display();
		
		
		
	}

}
