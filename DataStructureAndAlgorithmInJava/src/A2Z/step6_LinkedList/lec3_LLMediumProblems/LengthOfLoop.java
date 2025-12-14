package A2Z.step6_LinkedList.lec3_LLMediumProblems;

public class LengthOfLoop {

    static int findLength(Node slow, Node fast){
        int cnt=0;
        fast=fast.next;
        while(fast!=slow){
            cnt++;
            fast=fast.next;
        }
        return cnt;
    }

    static int lengthOfLoop(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return findLength(slow,fast);
            }
        }
        return 0;
    }

    static void main() {
        Node head=Node.createList();
        Node.printLinkedList(head);

        int length=lengthOfLoop(head);
        System.out.println(length);

    }
}
