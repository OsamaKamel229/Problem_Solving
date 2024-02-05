package LinkedList;

public class LinkedListForTest {
    private Node head;

    public LinkedListForTest(){
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");
        Node node7 = new Node("G");
        Node node8 = new Node("H");
        Node node9 = new Node("I");
        Node node10 = new Node("J");

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node10);
        node10.setNext(null);

        this.head = node1;
    }

    public Node getHead (){
        return this.head;
    }
}
