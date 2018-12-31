package datastructures.list.model;

/**
 * Created by I073413 on 9/27/2017.
 */
public class Node {
    private Object data;

    Node next;

    Node prev;

    public Node(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }




}
