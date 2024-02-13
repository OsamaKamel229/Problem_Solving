package LinkedList._2_ReverseLinkedList;

import LinkedList.LinkedListForTest;
import LinkedList.Node;

public class _2_ReverseLinkedList_II_Leetcode_92_Medium {

    public <T> Node<T> reverseBetweenTwoIndex (Node<T> head, int left, int right){
        if(head == null || left == right){
            return head;
        }

        Node<T> dummy = new Node<>(null);
        dummy.setNext(head);
        Node<T> beforeLeft = dummy;

        for (int i = 0; i < left; i++) {
            beforeLeft = beforeLeft.getNext();
        }

        Node<T> leftNode = beforeLeft.getNext();
        Node<T> afterLeft = leftNode.getNext();

        int steps = right - left;
        while (afterLeft != null && steps > 0){
            leftNode.setNext(afterLeft.getNext());
            afterLeft.setNext(beforeLeft.getNext());
            beforeLeft.setNext(afterLeft);
            afterLeft = leftNode.getNext();
            steps--;
        }

        return dummy.getNext();
    }

    public static void main(String[] args) {
        LinkedListForTest listForTest = new LinkedListForTest();
        _2_ReverseLinkedList_II_Leetcode_92_Medium obj = new _2_ReverseLinkedList_II_Leetcode_92_Medium();
        System.out.println(obj.reverseBetweenTwoIndex(listForTest.getHead(), 3, 7));
    }
}

/*
    problem url: https://leetcode.com/problems/reverse-linked-list-ii/description/
    Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

    Example 1:
    Input: head = [1,2,3,4,5], left = 2, right = 4
    Output: [1,4,3,2,5]

    Example 2:
    Input: head = [5], left = 1, right = 1
    Output: [5]


    Constraints:
    The number of nodes in the list is n.
    1 <= n <= 500
    -500 <= Node.val <= 500
    1 <= left <= right <= n


    Follow up: Could you do it in one pass?

    Solution: -
    To reverse a linked list we have to follow some pattern.

    Ex:
        A -> B -> C -> D -> E -> F -> G -> H -> Null     left = C, right = F
        ^
        |
      head

        A -> B -> F -> E -> D -> C -> G -> H -> Null
        ^
        |
      head

      algorithm:
      1- iterate over the linkedList until you find the node which position before left target.
         and call it beforeLeft, and the node after the left target call it afterLeft.

                            A -> B ->  C  ->  D -> E -> F -> G -> H ->
                                 ^     ^      ^
                                 |     |      |
                            lBefore   left   lAfter

      2- make the beforeLeft.next pointing to afterLeft, and afterLeft.next pointing to left, left pointing to the afterLeft.next.
        then move left and afterLeft pointers only one step forward. and keep beforeLeft in its position. and keep going until
        you find the right target.

                   step 1:  A -> B ->  D  ->  C -> E -> F -> G -> H ->
                                 ^     ^      ^
                                 |     |      |
                            lBefore   lAfter left

                   step 2:  A -> B ->  D  ->  C ->  E -> F -> G -> H ->
                                 ^            ^     ^
                                 |            |     |
                              lBefore        left  lAfter

                   step 2:  A -> B ->  E  ->  D ->  C ->  F -> G -> H ->
                                 ^                  ^     ^
                                 |                  |     |
                              lBefore              left  lAfter

                   step 2:  A -> B ->  F ->  E ->  D ->  C -> G -> H ->
                                 ^                  ^     ^
                                 |                  |     |
                              lBefore              left  lAfter

                   Check if afterLeft == right stop the while loop or the recursion base case.

      3- return head.
*/
