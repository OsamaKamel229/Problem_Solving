package LinkedList._2_SwapNodes_In_LinkedList;

import LinkedList.LinkedListForTest;
import LinkedList.Node;

public class _2_Swapping_Nodes_in_a_Linked_List_Leetcode_1721_Medium {

    public <T> Node<T> swapNodes(Node<T> head, int k) {
        int listLength = 0;
        Node<T> frontNode = null;
        Node<T> endNode = null;
        Node<T> currentNode = head;
        // set the front node and end node in single pass
        while (currentNode != null) {
            listLength++;
            if (endNode != null)
                endNode = endNode.getNext();
            // check if we have reached kth node
            if (listLength == k) {
                frontNode = currentNode;
                endNode = head;
            }
            currentNode = currentNode.getNext();
        }
        // swap the values of front node and end node
        T temp = frontNode.getValue();
        frontNode.setVal(endNode.getValue());
        endNode.setVal(temp);
        return head;
    }

    public static void main(String[] args) {
        LinkedListForTest linkedListForTest = new LinkedListForTest();
        _2_Swapping_Nodes_in_a_Linked_List_Leetcode_1721_Medium obj = new _2_Swapping_Nodes_in_a_Linked_List_Leetcode_1721_Medium();
        Node<String> head = obj.swapNodes(linkedListForTest.getHead(), 3);
        System.out.println(head);
    }
}
