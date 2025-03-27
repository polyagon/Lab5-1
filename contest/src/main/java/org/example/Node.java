package org.example;

public class Node {
    public Node next;
    public int val;
    public Node(int val){
        this.val = val;
        this.next = null;
    }
    public Node(int val, Node next){
        this.next = next;
        this.val = val;
    }

}
