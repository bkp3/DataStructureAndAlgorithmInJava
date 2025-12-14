package A2Z.step6_LinkedList.lec3_LLMediumProblems;

public class SegregateEvenAndOddIndexNodes {

    static Node segregateEvenAndOddNodes(Node head){
        if (head == null || head.next == null) return head;

        Node odd=head;
        Node even=head.next;
        Node evenHead=head.next;
        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }

    static void main() {
        Node head=Node.createList();
        Node.printLinkedList(head);

        Node newHead=segregateEvenAndOddNodes(head);
        Node.printLinkedList(newHead);


    }
}
