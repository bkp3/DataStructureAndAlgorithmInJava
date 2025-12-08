package A2Z.step6_LinkedList.lec1_LinkedList;

public class DeleteLastNodeLinkedList {
    static void main() {
        Node head=Node.createList();
        Node.printList(head);

        Node cur=head;
        while(cur.next.next!=null){
            cur=cur.next;
        }
        cur.next=null;
        Node.printList(head);
    }
}
