package LinkedList._2_ReverseLinkedList;

import LinkedList.LinkedListForTest;
import LinkedList.Node;

public class _3_Reverse_Nodes_in_Even_Length_Groups_Leetcode_2074_Hard {
    public Node<Integer> reverseEvenLengthGroups(Node<Integer> head) {

        int counter = 2;
        Node<Integer> prev = head;
        Node<Integer> curr = head.getNext();

        while (curr != null) {
            Node<Integer> localCurr = curr;
            Node<Integer> localPrev = prev;
            int count = 1;
            while (curr != null && count <= counter) {
                prev = curr;
                curr = curr.getNext();
                count++;
            }
            count--;
            if (Math.min(count, counter) % 2 == 0) {
                Node<Integer> newHead = reverse(localCurr, Math.min(count, counter));
                localPrev.setNext(newHead);
                prev = localCurr;
            }
            counter++;
        }
        return head;
    }

    private Node<Integer> reverse(Node<Integer> head, int count) {
        Node<Integer> prev = null;
        Node<Integer> curr = head;
        Node<Integer> next = null;
        while (curr != null && count > 0) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            count--;
        }
        head.setNext(next);
        return prev;
    }

    public static void main(String[] args) {
        LinkedListForTest linkedListForTest = new LinkedListForTest();
        _3_Reverse_Nodes_in_Even_Length_Groups_Leetcode_2074_Hard obj = new _3_Reverse_Nodes_in_Even_Length_Groups_Leetcode_2074_Hard();
        System.out.println(obj.reverseEvenLengthGroups(linkedListForTest.getHead()));
    }
}
