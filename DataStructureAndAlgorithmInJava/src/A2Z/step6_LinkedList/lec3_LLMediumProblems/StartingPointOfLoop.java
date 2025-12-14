package A2Z.step6_LinkedList.lec3_LLMediumProblems;

public class StartingPointOfLoop {

    static Node findStartingPoint(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    static void main() {
        Node head=Node.createList();
        Node.printLinkedList(head);

        Node startNode=findStartingPoint(head);
        System.out.println(startNode==null?"No Loop":startNode.data);
    }
}
