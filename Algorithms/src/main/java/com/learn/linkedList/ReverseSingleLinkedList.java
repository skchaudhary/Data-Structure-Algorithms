package com.learn.linkedList;

public class ReverseSingleLinkedList
{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next=new Node(4);
        printReverse(head);
    }

    private static void printReverse(Node head) {
        if (head.next != null)
            printReverse(head.next);

        System.out.println(head.data);
    }
}
