package LinkedList._2_ReverseLinkedList;

import LinkedList.LinkedListForTest;
import LinkedList.Node;

public class _3_Swap_Nodes_in_Pairs_24_Medium {

    public <T> Node<T> swapPairsInLinkedList(Node<T> head){
        if(head == null || head.getNext() == null) return head;

        Node<T> dummy = new Node<>(null);
        dummy.setNext(head);
        Node<T> prevNode = dummy;

        while(head != null && head.getNext() != null){
            Node<T> firstNode = head;
            Node<T> secondNode = head.getNext();
            Node<T> thirdNode = secondNode.getNext();

            prevNode.setNext(secondNode);
            firstNode.setNext(thirdNode);
            secondNode.setNext(firstNode);

            prevNode =firstNode;
            head = thirdNode;
        }

        return dummy.getNext();
    }

    public static void main(String[] args) {
        LinkedListForTest linkedListForTest = new LinkedListForTest();
        _3_Swap_Nodes_in_Pairs_24_Medium obj = new _3_Swap_Nodes_in_Pairs_24_Medium();
        Node<String> newHead = obj.swapPairsInLinkedList(linkedListForTest.getHead());
        System.out.println(newHead);
    }
}
/*
        https://leetcode.com/problems/swap-nodes-in-pairs/description/

         Given a linked list, swap every two adjacent nodes and return its head.
         You must solve the problem without modifying the values in the list's nodes
         (i.e., only nodes themselves may be changed.)

         Example 1:
         Input: head = [1,2,3,4]
         Output: [2,1,4,3]

         Example 2:
         Input: head = []
         Output: []

         Example 3:
         Input: head = [1]
         Output: [1]

         Constraints:
         The number of nodes in the list is in the range [0, 100].
         0 <= Node.val <= 100
*/