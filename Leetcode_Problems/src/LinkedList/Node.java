package LinkedList;

public class Node<T>{
    private T val;
    private Node<T> next;

    public Node(T val){
        this.val = val;
        this.next = null;
    }

    public Node (T val, Node<T> next){
        this.val = val;
        this.next = next;
    }

    public T getValue(){
        return this.val;
    }

    public Node<T> getNext(){
        return this.next;
    }
    public void setVal(T val){
        this.val = val;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
