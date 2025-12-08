package A2Z.step6_LinkedList.lec1_LinkedList;

public class FindLengthLinkedList {
    static void main() {
        Node head=Node.createList();
        Node.printList(head);

        int size=0;
        Node cur=head;
        while(cur!=null){
            cur=cur.next;
            size++;
        }
        System.out.println(size);

    }
}
