package LinkedList._2_ReverseLinkedList;

import LinkedList.LinkedListForTest;
import LinkedList.Node;
import LinkedList._1_CreateLinkedListFromArray.Create_LinkedList_From_Array;

public class _2_ReverseLinkedList_II_ByValueOfNodes {

    public <T> Node<T> reverseBetween(Node<T> head, T left, T right) {
        if (head == null || left.equals(right)) {
            return head;
        }

        Node<T> dummy = new Node<>(null);
        dummy.setNext(head);
        Node<T> beforeLeft = dummy;

        // Find the node just before the left target
        while (beforeLeft.getNext() != null && !beforeLeft.getNext().getValue().equals(left)) {
            beforeLeft = beforeLeft.getNext();
        }

        Node<T> leftNode = beforeLeft.getNext();
        Node<T> afterLeft = leftNode.getNext();

        if(left instanceof Integer){
            while (afterLeft != null && beforeLeft.getNext().getValue() != right) {
                leftNode.setNext(afterLeft.getNext());
                afterLeft.setNext(beforeLeft.getNext());
                beforeLeft.setNext(afterLeft);
                afterLeft = leftNode.getNext();  // Update afterLeft pointer correctly
            }
        } else {
            // Reverse the sublist
            while (afterLeft != null && !beforeLeft.getNext().getValue().equals(right)) {
                leftNode.setNext(afterLeft.getNext());
                afterLeft.setNext(beforeLeft.getNext());
                beforeLeft.setNext(afterLeft);
                afterLeft = leftNode.getNext();  // Update afterLeft pointer correctly
            }
        }

        return dummy.getNext();
    }
    public static void main(String[] args) {
        LinkedListForTest linkedListForTest = new LinkedListForTest();
        _2_ReverseLinkedList_II_ByValueOfNodes obj = new _2_ReverseLinkedList_II_ByValueOfNodes();
        System.out.println(obj.reverseBetween(linkedListForTest.getHead(), "C","F"));

        Create_LinkedList_From_Array objConverter = new Create_LinkedList_From_Array();
        Integer[] array = {1,2,3,4,5,6,7,8,9};
        Node linkedList = objConverter.convertArrayToLinkedList(array);
        _2_ReverseLinkedList_II_ByValueOfNodes obj2 = new _2_ReverseLinkedList_II_ByValueOfNodes();
        System.out.println(obj2.reverseBetween(linkedList, 3,7));
    }
}
