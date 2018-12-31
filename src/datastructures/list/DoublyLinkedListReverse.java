package datastructures.list;
import datastructures.list.model.Node;
/**
 * Created by I073413 on 9/27/2017.
 */

/**
 * Given a linked list ,reverse it
 * Input :
 * 1<->2<->3<->4<->5</->6
 * Output :
 * 6<->5<->4<->3<->2</->1
 */
public class DoublyLinkedListReverse {

    public static  void main(String args[]) throws ClassNotFoundException {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setPrev(node5);
        node5.setPrev(node4);
        node4.setPrev(node3);
        node3.setPrev(node2);
        node2.setPrev(node1);

        Node head = new Node(null);
        head.setNext(node1);

        traverse(head);
        reverseRecursive(head.getNext(),head);
        traverse(head);

    }

    private static void reverseNonRecrusive(Node node,Node head) {
        while(node != null){
            Node prev = node;
            if(node.getNext() == null){
                head.setNext(node);
            }
            node = node.getNext();
            prev.setNext(prev.getPrev());
            prev.setPrev(node);
        }
    }

    private static void reverseRecursive(Node node, Node head) {
           if(node == null){
               return ;
           }else {
               Node prev = node;
               node = node.getNext();
               prev.setNext(prev.getPrev());
               prev.setPrev(node);
               if (node  == null){
                   head.setNext(prev);
               }
               reverseRecursive(node,head);
           }

    }

    private static void traverse(Node head){
        while(head.getNext() != null ){
            head = head.getNext();
            System.out.println( (Integer)head.getData());
        }
    }
}
