package com.learn.linkedList;

public class DetectCircleSingleLinkedList
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
        head.next.next.next=head.next;
        detectCircle(head);
    }

    private static void detectCircle(Node head) {
        Node slow, fast;
        slow=fast=head;
        while (slow!=null && fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if (slow==fast){
                    System.out.println("Cycle found");
                    return;
                }
        }
        System.out.println("Cycle not found");
    }
}
