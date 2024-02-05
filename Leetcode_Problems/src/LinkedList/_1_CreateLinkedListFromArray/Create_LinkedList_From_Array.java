package LinkedList._1_CreateLinkedListFromArray;

import LinkedList.Node;

public class Create_LinkedList_From_Array {

    public Node convertArrayToLinkedList(int[] nums){
        Node head = new Node(-1);
        head.setNext(new Node (nums[0]));

        Node currNode = head;
        for (int arrIdx = 1; arrIdx < nums.length; arrIdx++) {
            currNode.setNext(new Node(nums[arrIdx]));
            currNode = currNode.getNext();
        }

        return head;
    }

    public static void main(String[] args) {
        Create_LinkedList_From_Array linkedList = new Create_LinkedList_From_Array();
        System.out.println(linkedList.convertArrayToLinkedList(new int[]{1,2,3,4,5,6,7}));
    }

}
