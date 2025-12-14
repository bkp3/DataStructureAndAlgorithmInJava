package A2Z.step6_LinkedList.lec3_LLMediumProblems;



public class MiddleOfLinkedList {

    static int middleNode(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null && slow!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }

    static void main() {
        Node head=Node.createList();
        Node.printLinkedList(head);

        int ans=middleNode(head);
        System.out.println(ans);
    }
}
