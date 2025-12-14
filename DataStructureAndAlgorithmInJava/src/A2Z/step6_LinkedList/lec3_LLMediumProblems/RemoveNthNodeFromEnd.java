package A2Z.step6_LinkedList.lec3_LLMediumProblems;

/*
 Given a linked list and an integer N, the task is to delete the Nth node from the end of the linked list and print the updated linked list.

Examples
Input:  5->1->2, N=2
Output: 5->2
Explanation: The 2nd node from the end of the linked list is 1. Therefore, we get this result after removing 1 from the linked list


*/

public class RemoveNthNodeFromEnd {

    static Node removeNthNodeBruteForce(Node head,int n){
        int cnt=0;
        Node tmp=head;
        while(tmp!=null){
            tmp=tmp.next;
            cnt++;
        }
        if(cnt==n){
            return head.next;
        }
        int res=cnt-n;
        tmp=head;
        while(res-->1){
            tmp=tmp.next;
        }
        tmp.next=tmp.next.next;
        return head;
    }

    static Node removeNthNodeOptimal(Node head,int n){
        Node fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null){
            return head.next;
        }
        Node slow=head;
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    static void main() {
        Node head=Node.createList();
        Node.printLinkedList(head);

        int n=2;

        //BruteForce
        Node newHead=removeNthNodeBruteForce(head,n);
        Node.printLinkedList(newHead);

        //optimal
        Node newHead2=removeNthNodeOptimal(head,n);
        Node.printLinkedList(newHead2);
    }
}
