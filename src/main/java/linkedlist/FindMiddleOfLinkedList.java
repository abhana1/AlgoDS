package linkedlist;

/**
 * Source: https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
 *
 * Question:
 *     Find the middle of a given linked list.
 *     Given a singly linked list, find middle of the linked list.
 *     For example, if given linked list is 1->2->3->4->5 then output should be 3.
 *     If there are even nodes, then there would be two middle nodes, we need to print second middle element.
 *     For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 *
 * @author Abhishek Anand (Here author just mean who is the creator of this file.)
 */
public class FindMiddleOfLinkedList {

    /**
     * Method 1: Traverse the ll for first time and calculate the length.
     *           Find the count/2 if odd and count/2 + 1 if even, and traverse again and find the element.
     */
    void findMiddleElementByBruteForce(){

    }


    /**
     * Method 2: Use two pointers concept -
     *           1st pointer will move slowly with only 1 step.
     *           2nd pointer will move every 2 steps.
     *           So, when 2nd pointer is pointing to null it means 1st pointer would have moved just to its half.
     *           So, the element at 1st pointer is the middle element.
     */
    void findMiddleElementByTwoPointers(){

    }

    /**
     * Method 3: We can use a counter and take a mid node reference,
     *           point mid to the head and the mid will move only when the count is odd.
     *           Keep incrementing counter and the head. when head is null or points to null means it has reached end.
     *           Mid will have the middle element.
     */
    void findMiddleElementByMidReferenceOddIncrement(){

    }


}
