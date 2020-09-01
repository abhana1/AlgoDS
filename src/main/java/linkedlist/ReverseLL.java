package linkedlist;

/**
 * Source: https://www.geeksforgeeks.org/reverse-a-linked-list/
 *
 * Question: Reverse a LL
 *           Input: Head of following linked list
 *          1->2->3->4->NULL
 *          Output: Linked list should be changed to,
 *          4->3->2->1->NULL
 *
 *          Input: Head of following linked list
 *          1->2->3->4->5->NULL
 *          Output: Linked list should be changed to,
 *          5->4->3->2->1->NULL
 *
 * Edge Cases: 1. If the LL has loop.
 *              2. If head is null.
 *              3. If only one element is present.
 *
 * @author Abhishek Anand
 */
public class ReverseLL {

    public static LinkedList.Node reverseLL(LinkedList.Node head){

        if(head == null || head.next == null)
            return head;

        LinkedList.Node prev = null;
        LinkedList.Node current = head;
        LinkedList.Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;

    }

}
