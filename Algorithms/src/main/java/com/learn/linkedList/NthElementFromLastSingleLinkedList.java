package com.learn.linkedList;

public class NthElementFromLastSingleLinkedList
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
        printNthElement(head, 2);
    }

    private static void printNthElement(Node head, int n) {
        if (head!=null){
            Node mainNode = head;
            Node tempNode = head;
            int count = 0;
            while (count<n){
                if (tempNode == null)
                    return;
                tempNode=tempNode.next;
                count++;
            }
            while (tempNode != null){
                tempNode=tempNode.next;
                mainNode=mainNode.next;
            }
            System.out.println(mainNode.data);
        }
    }
}
