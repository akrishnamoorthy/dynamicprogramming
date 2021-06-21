package dynamicprogramming.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Node{
    Integer data;
    Node left;
    Node right;

    public Node(int i) {
        this.data = i;
    }
    public Node(int i, Node left, Node right) {
        this.data = i;
        this.left=left;
        this.right=right;
    }
}


class InOrderTraversal {

    public static void main(String argos[]) {
        List<Node> nodes = new LinkedList<Node>();
        Node root = readNodes(nodes);
        Stack<Integer> stack = new Stack();
        pushInOrderStack(root, stack);
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    static void pushInOrderStack(Node node, Stack<Integer> stack) {
        if (node != null) {
            pushInOrderStack(node.left, stack);
            stack.push(node.data);
            pushInOrderStack(node.right, stack);

        }


    }

    static Node readNodes(List<Node> nodes) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node3 = new Node(3, node6, node7);
        Node node2 = new Node(2, node4, node5);
        Node node1 = new Node(1, node2, node3);
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);
        nodes.add(node7);
        return node1;

    }
}
