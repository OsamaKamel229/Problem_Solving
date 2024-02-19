package LinkedList._2_ReverseLinkedList;

import LinkedList.LinkedListForTest;
import LinkedList.Node;

public class _5_Reverse_Nodes_in_k_Group_25_Hard {

    public <T> Node<T> reverseNodesInKGroup(Node<T> head, int k){
        if(head == null || head.getNext() == null) return head;
        int listLength = getLinkedListLength(head);
        int numberOfSwapOperations = listLength / k;
        int numberOfNodesEverySwapOperation = k;

        Node<T> dummy = new Node<>(null);
        dummy.setNext(head);
        Node<T> prev = dummy;
        Node<T> curr = head;
        Node<T> after = curr.getNext();

        while(numberOfSwapOperations > 0){
            numberOfNodesEverySwapOperation = k;
            while(numberOfNodesEverySwapOperation > 1){
                curr.setNext(after.getNext());
                after.setNext(prev.getNext());
                prev.setNext(after);
                after = curr.getNext();
                numberOfNodesEverySwapOperation--;
            }
            prev = curr;
            curr = prev.getNext();
            after = curr.getNext();
            numberOfSwapOperations--;
        }

        return dummy.getNext();
    }
    public int getLinkedListLength(Node head){
        int length = 0;
        while(head != null){
            head = head.getNext();
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        LinkedListForTest linkedListForTest = new LinkedListForTest();
        _5_Reverse_Nodes_in_k_Group_25_Hard obj = new _5_Reverse_Nodes_in_k_Group_25_Hard();
        Node<String> head = obj.reverseNodesInKGroup(linkedListForTest.getHead(), 3);
        System.out.println(head);
    }
}

/*
    https://leetcode.com/problems/reverse-nodes-in-k-group/

    Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
    k is a positive integer and is less than or equal to the length of the linked list.
    If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
    You may not alter the values in the list's nodes, only nodes themselves may be changed.

    Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]

    Input: head = [1,2,3,4,5], k = 3
    Output: [3,2,1,4,5]

    Constraints:
    The number of nodes in the list is n.
    1 <= k <= n <= 5000
    0 <= Node.val <= 1000

    Follow-up: Can you solve the problem in O(1) extra memory space?

    solution:
    1- I need to know the length of this linkedList, and check how many k exist on it.
       number of operation required op = linkedList.length / k.

    2- perform op time of swap operation (reverse operation).

    3- return head of the linkedList (perform in place without using any extra space).


    Example:        head = 1,           k = 3.

    step 1: iterate over the linkedList and find the length of this linkedList. (8 nodes)
    step 2: find number of swap operations needed = linkedListLength / k. (8 / 3 = 2 swap operations needed only)
    step 3: perform 2 swap operations of length k and return the dummy.next

                    1   ->  2   ->  3   ->  4   ->  5   ->  6   ->  7   ->  8   ->  NULL

        swap operation 1: -
        ---------------------------------------------------------------------------------
        DUMMY   ->  1   ->  2   ->  3   ->  4   ->  5   ->  6   ->  7   ->  8   ->  NULL

          ^         ^       ^
          |         |       |
       prev       curr     next

        DUMMY   ->  2   ->  1   ->  3   ->  4   ->  5   ->  6   ->  7   ->  8   ->  NULL

          ^         ^       ^
          |         |       |
       prev       next     curr

       DUMMY   ->   2   ->  1   ->  3   ->  4   ->  5   ->  6   ->  7   ->  8   ->  NULL

          ^                 ^       ^
          |                 |       |
       prev                curr     next

       DUMMY   ->   3   ->   2   ->  1   ->  4   ->  5   ->  6   ->  7   ->  8   ->  NULL

          ^         ^                ^
          |         |                |
       prev        next             curr

      DUMMY   ->   3   ->   2   ->  1   ->  4   ->  5   ->  6   ->  7   ->  8   ->  NULL

          ^                         ^       ^
          |                         |       |
       prev                        curr     next
      -----------------------------------------------------------------------------------
      swap operation 2: -

      DUMMY   ->   3   ->   2   ->  1   ->  4   ->  5   ->  6   ->  7   ->  8   ->  NULL

                                    ^       ^       ^
                                    |       |       |
                                 prev     curr     next

      DUMMY   ->   3   ->   2   ->  1   ->  5   ->  4   ->  6   ->  7   ->  8   ->  NULL

                                    ^               ^       ^
                                    |               |       |
                                 prev             curr     next

      DUMMY   ->   3   ->   2   ->  1   ->  6   ->  5   ->  4   ->  7   ->  8   ->  NULL

                                    ^               ^       ^
                                    |               |       |
                                 prev             curr     next
      ---------------------------------------------------------------------------------

      return  3   ->   2   ->  1   ->  6   ->  5   ->  4   ->  7   ->  8   ->  NULL
*/
