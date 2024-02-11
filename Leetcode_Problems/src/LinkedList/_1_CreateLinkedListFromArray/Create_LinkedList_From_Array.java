package LinkedList._1_CreateLinkedListFromArray;

import LinkedList.Node;

public class Create_LinkedList_From_Array {

    public <T> Node<T> convertArrayToLinkedList(T[] array){

        if (array == null || array.length == 0) {
            return null;
        }

        Node<T> head = new Node(-1);
        Node<T> currNode = head;
        for (int arrIdx = 0; arrIdx < array.length; arrIdx++) {
            Node<T> newNode = new Node<>(array[arrIdx]);
            currNode.setNext(newNode);
            currNode = currNode.getNext();
        }

        return head.getNext();
    }

    public static void main(String[] args) {
        Create_LinkedList_From_Array linkedList = new Create_LinkedList_From_Array();
        Integer[] array = {1,2,3,4,5,6,7};
        Node<Integer> head = linkedList.convertArrayToLinkedList(array);
        System.out.println(head);

        Character[] arrayCharacters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        Node<Character> head2 = linkedList.convertArrayToLinkedList(arrayCharacters);
        System.out.println(head2);
    }

}
