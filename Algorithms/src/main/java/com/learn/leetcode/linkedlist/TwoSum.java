package com.learn.leetcode.linkedlist;
class ListNode{
    int val;
    ListNode next;
    ListNode(int data){
        val=data;
    }
}
class ResultNode{
    int carry=0;
    ListNode node=null;
}
public class TwoSum {
    public static void main(String[] args) {
        ListNode l=new ListNode(2);
        l.next=new ListNode(4);
        l.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        ListNode node=new TwoSum().addTwoNumbers(l, l2);
        while (node!=null){
            System.out.print(node.val + " ");
            node=node.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1=findLength(l1);
        int length2=findLength(l2);

        int diff=Math.abs(length1-length2);
        ListNode first=length1<=length2?l1:l2;
        ListNode second=length2>=length1?l2:l1;

        for(int i=0;i<diff;i++){
            first=insertBefore(first, 0);
        }
        ResultNode result = solveHelper(first, second);
        ListNode node=result.node;
        if(result.carry>0){
            node=insertBefore(node, result.carry);
        }
        return node;
    }

    public ResultNode solveHelper(ListNode l1, ListNode l2){
        if(l1==null && l2==null){
            return new ResultNode();
        }

        ResultNode result=solveHelper(l1.next, l2.next);

        int sum=result.carry+l1.val+l2.val;

        ListNode node=insertBefore(result.node, sum%10);

        result.node=node;
        result.carry=sum/10;
        return result;
    }

    public ListNode insertBefore(ListNode l, int data){
        ListNode node=new ListNode(data);
        node.next=l;
        return node;
    }
    public int findLength(ListNode l){
        int length=0;
        while(l!=null){
            length++;
            l=l.next;
        }
        return length;
    }
}
