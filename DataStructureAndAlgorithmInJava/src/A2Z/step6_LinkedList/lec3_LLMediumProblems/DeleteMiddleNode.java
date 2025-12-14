package A2Z.step6_LinkedList.lec3_LLMediumProblems;

/*
Given the head of a linked list of integers, delete the middle node of the linked list and return the modified head. However, if the linked list has an even number of nodes, delete the second middle node.

Examples
Input: 1->2->3->4->5
Output: 1->2->4->5



*/

public class DeleteMiddleNode {

    static Node deleteMiddleNode(Node head){
        Node slow=head;
        Node fast=head;
        Node tmp=head;
        while(fast.next!=null && fast.next.next!=null){
            tmp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        tmp.next=tmp.next.next;
        return head;
    }

    static void main() {
        Node head=Node.createList();
        Node.printLinkedList(head);

        Node newHead=deleteMiddleNode(head);
        Node.printLinkedList(newHead);
    }
}
