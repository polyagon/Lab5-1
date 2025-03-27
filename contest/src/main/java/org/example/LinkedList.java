package org.example;

public class LinkedList {
    Node head = new Node(0);
    int size ;
    public LinkedList() {

    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }


        Node temp = this.head.next;

        while (index-- > 0){
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
            Node temp = this.head;

            while (index -- > 0){
                temp = temp.next;
            }
            temp.next = new Node(val, temp.next);
            size++;
    }

    public void deleteAtIndex(int index) {
        if(index >= size || index < 0){
            return;
        }

        Node temp = this.head;
        while (index-- > 0){
            temp = temp.next;
        }
        Node dele = temp.next;
        temp.next = dele.next;
        dele.next = null;
        size--;
    }

    public void printList(){
        int i = 0;
        Node temp = this.head.next;
        do{
            System.out.println(temp.val);
            temp = temp.next;
        } while (temp != null);
    }
}
