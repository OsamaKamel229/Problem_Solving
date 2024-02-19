package LinkedList._2_SwapNodes_In_LinkedList;

import LinkedList.LinkedListForTest;
import LinkedList.Node;
import LinkedList._1_CreateLinkedListFromArray.Create_LinkedList_From_Array;


            // replace by swap the nodes not the values only. Not typically the same leetcode problem.
public class _2_Swapping_Nodes_in_a_Linked_List_Leetcode_1721_Medium_Custom {

    public <T> Node<T> swapNodesInLinkedList(Node<T> head, int k){
        if(head == null) return null;

        int linkedListLength = getLinkedListLength(head);

        Node<T> dummy = new Node<>(null);
        dummy.setNext(head);
        Node<T> currNode = dummy;

        Node<T> beforeFirstPosition = currNode;
        Node<T> beforeSecondPosition = currNode;

        int firstIndex = k;
        int secondIndex = linkedListLength - k+1;
        int currIndex = 1;

        while(currIndex < secondIndex){
            if(currIndex < firstIndex){
                beforeFirstPosition = beforeFirstPosition.getNext();
            }
            beforeSecondPosition = beforeSecondPosition.getNext();
            currIndex++;
        }

        Node<T> firstPosition = beforeFirstPosition.getNext();
        Node<T> afterFirstPosition = firstPosition.getNext();

        Node<T> secondPosition = beforeSecondPosition.getNext();
        Node<T> afterSecondPosition = secondPosition.getNext();

        /*
                1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
                1- > 7
                2 -> 8
                7 -> 3
                6 -> 2
        */

        if (secondPosition != null) { // Check if secondPosition is not null
            // Check if the nodes to be swapped are not adjacent
            if (firstPosition.getNext() != secondPosition) {
                beforeFirstPosition.setNext(secondPosition);
                firstPosition.setNext(afterSecondPosition);
                secondPosition.setNext(afterFirstPosition);
                beforeSecondPosition.setNext(firstPosition);
            } else { // If the nodes are adjacent, swap them directly
                firstPosition.setNext(afterSecondPosition);
                secondPosition.setNext(firstPosition);
                beforeFirstPosition.setNext(secondPosition);
            }
        } else { // If secondPosition is null, swap with the last node
            beforeFirstPosition.setNext(afterFirstPosition);
            firstPosition.setNext(null);
            currNode.setNext(firstPosition);
            beforeSecondPosition.setNext(dummy.getNext());
            dummy.setNext(secondPosition);
        }

        return dummy.getNext();
    }

    public <T> int getLinkedListLength(Node<T> head){
        int counter = 0;

        while(head != null){
            head = head.getNext();
            counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        LinkedListForTest linkedListForTest = new LinkedListForTest();
        _2_Swapping_Nodes_in_a_Linked_List_Leetcode_1721_Medium_Custom obj = new _2_Swapping_Nodes_in_a_Linked_List_Leetcode_1721_Medium_Custom();
        Node<String> head = obj.swapNodesInLinkedList(linkedListForTest.getHead(), 1);
        System.out.println(head);

        LinkedListForTest linkedListForTest2 = new LinkedListForTest();
        _2_Swapping_Nodes_in_a_Linked_List_Leetcode_1721_Medium_Custom obj2 = new _2_Swapping_Nodes_in_a_Linked_List_Leetcode_1721_Medium_Custom();
        Node<String> head2 = obj2.swapNodesInLinkedList(linkedListForTest2.getHead(), 5);
        System.out.println(head2);

        Create_LinkedList_From_Array converter = new Create_LinkedList_From_Array();
        Integer[] arr = {7,9,6,6,7,8,3,0,9,5};
        Node<Integer> head3 =converter.convertArrayToLinkedList(arr);
        _2_Swapping_Nodes_in_a_Linked_List_Leetcode_1721_Medium_Custom obj3 = new _2_Swapping_Nodes_in_a_Linked_List_Leetcode_1721_Medium_Custom();
        Node<Integer> head4 = obj3.swapNodesInLinkedList(head3, 5);
        System.out.println(head4);

    }
}
/*      1721. Swapping Nodes in a Linked List
        https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/

        You are given the head of a linked list, and an integer k.
        Return the head of the linked list after swapping the values of the kth node from the beginning
        and the kth node from the end (the list is 1-indexed).

        Example 1:
        Input: head = [1,2,3,4,5], k = 2
        Output: [1,4,3,2,5]

        Example 2:
        Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
        Output: [7,9,6,6,8,7,3,0,9,5]

        Constraints:
        The number of nodes in the list is n.
        1 <= k <= n <= 105
        0 <= Node.val <= 100
*/