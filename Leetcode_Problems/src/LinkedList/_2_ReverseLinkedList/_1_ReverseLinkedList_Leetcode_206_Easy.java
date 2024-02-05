package LinkedList._2_ReverseLinkedList;

import LinkedList.LinkedListForTest;
import LinkedList.Node;

public class _1_ReverseLinkedList_Leetcode_206_Easy {

    public Node reverseLinkedList(Node head){
        Node before = null;

        while(head != null){
            Node after = head.getNext();
            head.setNext(before);

            before = head;
            head = after;
        }

        return before;
    }

    public static void main(String[] args) {
        LinkedListForTest linkedListForTest = new LinkedListForTest();
        _1_ReverseLinkedList_Leetcode_206_Easy obj = new _1_ReverseLinkedList_Leetcode_206_Easy();
        System.out.println(obj.reverseLinkedList(linkedListForTest.getHead()));
    }

    /*
    Problem URL: https://leetcode.com/problems/reverse-linked-list/description/

    To reverse a linked list we have to follow some pattern.
        ^
    Ex:
        A -> B -> C -> D -> E -> F -> G -> H -> Null
        ^
        |
      head

    instead of having the last node H pointing to null value, and head pointing to node A,
    we need to make the Node head pointing to node H and Node A pointing to null, and every node between
    node A and Node H pointing to the opposite direction.

        Null <- A <- B <- C <- D <- E <- F <- G <- H
                                                   ^
                                                   |
                                                  head
      to implements this algorithm : -
      1- we need to define new node called beforeHeadNode and make it pointing to the head node.
      2- we need to define new node called afterHeadNode and make it pointing to the head next node.

       null      A -> B -> C -> D -> E -> F -> G -> H -> Null
        ^        ^    ^
        |        |    |
      before    head   after

      3- we need to traverse this LinkedList from its head (A) to the last Node (H) and each time we change the direction
         of the pointing from the afterHeadNode to the beforeHeadNode and after that we move the prevHeadNode to head node
         and the head node to the afterHeadNode. and so on, until reaching the end (when head == null).

         null  <-  A   B -> C -> D -> E -> F -> G -> H -> Null
           ^       ^   ^
           |       |   |
         before   head   after

          Null <- A    B -> C -> D -> E -> F -> G -> H -> Null
                  ^    ^    ^
                  |    |    |
              before  head   after

          Null <- A <- B    C -> D -> E -> F -> G -> H -> Null
                       ^    ^    ^
                       |    |    |
                   before  head  after

          Null <- A <- B <- C    D -> E -> F -> G -> H -> Null
                            ^    ^    ^
                            |    |    |
                        before  head   after

          Null <- A <- B <- C <- D    E -> F -> G -> H -> Null
                                 ^    ^    ^
                                 |    |    |
                             before  head   after

          Null <- A <- B <- C <- D <- E    F -> G -> H -> Null
                                      ^    ^    ^
                                      |    |    |
                                  before  head  after

          Null <- A <- B <- C <- D <- E <-  F     G -> H -> Null
                                            ^    ^    ^
                                            |    |    |
                                        before  head  after

          Null <- A <- B <- C <- D <- E <-  F <- G    H -> Null
                                                 ^    ^    ^
                                                 |    |    |
                                            before  head  after

          Null <- A <- B <- C <- D <- E <-  F <- G <- H  Null
                                                      ^    ^    ^
                                                      |    |    |
                                                 before  head  after

         4- return before, which in our example == node(H).

*/
}


