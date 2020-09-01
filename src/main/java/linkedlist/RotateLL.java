package linkedlist;

/**
 * Source: https://www.geeksforgeeks.org/rotate-a-linked-list/
 *
 * Question: Given a singly linked list, rotate the linked list counter-clockwise by k nodes.
 *           Where k is a given positive integer. For example, if the given linked list is
 *           10->20->30->40->50->60 and k is 4, the list should be modified to
 *           50->60->10->20->30->40.
 *           Assume that k is smaller than the count of nodes in linked list.
 *
 * @author Abhishek Anand
 */
public class RotateLL {

    public static LinkedList.Node rotate(LinkedList.Node head, int index){
        if(index < 1)
            return head;

        if(head == null || head.next == null)
            return head;

        LinkedList.Node newHead = null;
        LinkedList.Node current = head;
        LinkedList.Node prev = null;

        int count = 0;
        while(current.next != null){
            count++;
            if(count < index){
                prev = current;
            }

            if(count == index){
                newHead = current;
                prev.next = null;
            }

            current = current.next;
        }
        current.next = head;

        return newHead;
    }
}
