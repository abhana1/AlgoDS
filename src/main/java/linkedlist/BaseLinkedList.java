package linkedlist;

/**
 * Source : https://www.geeksforgeeks.org/data-structures/linked-list/
 *
 * This class contains all the basic operations of the linked list.
 * Like: Insert, Delete, Find length, Print LL
 *
 */
public class BaseLinkedList {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.head = new LinkedList.Node(1);
        linkedList.head.next = new LinkedList.Node(2);
        linkedList.head.next.next = new LinkedList.Node(3);
        linkedList.head.next.next.next = new LinkedList.Node(4);
        linkedList.head.next.next.next.next = new LinkedList.Node(5);

        printLL(linkedList.head);

        insertElementAtBeginning(linkedList.head, 7);
        insertElementAtBeginning(null, 5);

        insertElementInMiddle(linkedList.head, 8,2);
        insertElementInMiddle(linkedList.head, 10,0);

        insertElementAtEnd(linkedList.head, 6);
        insertElementAtEnd(null, 6);

        deleteElementInLL(linkedList.head, 1);

        printLL(ReverseLL.reverseLL(linkedList.head));

        printLL(RotateLL.rotate(linkedList.head,6));


    }

    /**
     * This method is used to insert an element at the starting of the given linked list.
     *
     * Note: Always do null check or any condition check at the starting of the method.
     *
     * @param head - pass head of the LL.
     * @param data - data to be inserted.
     */
    static void insertElementAtBeginning(LinkedList.Node head, int data){

        LinkedList.Node newNode = new LinkedList.Node(data);

        if(head == null){
            head = newNode;
            printLL(head);
            return;
        }

        newNode.next = head;
        head = newNode;

        printLL(head);

    }

    /**
     * This method is used to insert element in the middle or at any particular position.
     *
     * @param head - pass the head of the linked list.
     * @param data - value to be inserted.
     * @param position - At which position you want to add the element
     */
    static void insertElementInMiddle(LinkedList.Node head, int data, int position){
        LinkedList.Node newNode = new LinkedList.Node(data);

        if(head == null){
            head = newNode;
            printLL(head);
            return;
        }

        LinkedList.Node current = head;
        LinkedList.Node prev = null;
        int counter = 0;
        // taking position as start from Zero.
        while (counter < (position-1) && current.next != null){
            current = current.next;
            counter++;
        }

        if(counter==(position-1)){
            prev = current;
            current = newNode;
            current.next = prev.next;
            prev.next = current;
        }

        if(position == 0){
            prev = head;
            head = newNode;
            head.next = prev;
        }

        printLL(head);
    }

    /**
     * This method adds element at the end of the linked list.
     *
     * @param head - Always pass head of the ll when you want to represent ll.
     * @param data - data to be inserted in the ll
     */
    static void insertElementAtEnd(LinkedList.Node head, int data){
        LinkedList.Node newNode = new LinkedList.Node(data);

        if(head == null){
            head = newNode;
            printLL(head);
            return;
        }

        LinkedList.Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        printLL(head);
    }

    /**
     *  Trick: The main idea to delete a node is point previous to the next to next node.
     *          This will de-link the delete node.
     *
     * @param head
     * @param key
     */
    static void deleteElementInLL(LinkedList.Node head, int key){
        LinkedList.Node prev = null;
        LinkedList.Node current = head;

        if(head == null){
            return;
        }

        if(head.data == key){
            head = head.next;
            printLL(head);
            return;
        }

        while(current.next != null){
            if(current.next.data == key){
                current.next = current.next.next;
                printLL(head);
                return;
            }
            current = current.next;
        }
    }

    /**
     * This method is used to print the linked list.
     *
     * Trick: The trick is to save the memory and time.
     *          When we don't want to reuse head. Use head.
     *          If we need head, then preserve it and rather use a new node for operations.
     *
     * @param head - Pass head of the linked list.
     */
    static void printLL(LinkedList.Node head){

        if(head == null)
            return;

        while(head != null){
            System.out.print(head.data+" -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}

class LinkedList{
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}
