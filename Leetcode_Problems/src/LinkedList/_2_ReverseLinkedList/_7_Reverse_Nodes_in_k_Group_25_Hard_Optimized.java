package LinkedList._2_ReverseLinkedList;

import LinkedList.LinkedListForTest;
import LinkedList.Node;

public class _7_Reverse_Nodes_in_k_Group_25_Hard_Optimized {

    public <T> Node<T> reverseNodesInKGroup(Node<T> head, int k) {
        if (head == null || head.getNext() == null || k == 1) return head;

        Node<T> dummy = new Node<>(null);
        dummy.setNext(head);
        Node<T> prev = dummy;

        while (prev != null) {
            prev = reverseNextKNodes(prev, k);
        }

        return dummy.getNext();
    }

    private <T> Node<T> reverseNextKNodes(Node<T> prev, int k) {
        Node<T> lastPrev = prev;
        for (int i = 0; i < k; i++) {
            lastPrev = lastPrev.getNext();
            if (lastPrev == null) return null; // Not enough nodes to reverse
        }

        Node<T> prevNode = prev.getNext();
        Node<T> currNode = prevNode.getNext();

        for (int i = 0; i < k - 1; i++) {
            Node<T> nextNode = currNode.getNext();
            currNode.setNext(prevNode);
            prevNode = currNode;
            currNode = nextNode;
        }

        Node<T> nextGroupStart = prev.getNext();
        prev.getNext().setNext(currNode);
        prev.setNext(prevNode);

        return nextGroupStart;
    }

    public static void main(String[] args) {
        LinkedListForTest linkedListForTest = new LinkedListForTest();
        _7_Reverse_Nodes_in_k_Group_25_Hard_Optimized obj = new _7_Reverse_Nodes_in_k_Group_25_Hard_Optimized();
        Node<String> head = obj.reverseNodesInKGroup(linkedListForTest.getHead(), 3);
        System.out.println(head);
    }
}
