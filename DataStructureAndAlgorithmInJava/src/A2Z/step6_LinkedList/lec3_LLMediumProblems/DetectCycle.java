package A2Z.step6_LinkedList.lec3_LLMediumProblems;

public class DetectCycle {

    static boolean detectLoop(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    static void main() {
        Node head=Node.createList();
        Node.printLinkedList(head);

        boolean flag=detectLoop(head);
        System.out.println(flag);
    }
}
