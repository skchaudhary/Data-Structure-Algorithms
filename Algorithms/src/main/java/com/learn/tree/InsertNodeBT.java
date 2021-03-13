package com.learn.tree;

import com.learn.util.MyReader;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InsertNodeBT
{
    public static void main(String[] args) {
        MyReader mr=new MyReader();
        System.out.println("Enter Number of nodes: ");
        int n=mr.nextInt();

        Node root=null;
        for (int i=0;i<n;i++)
            root = insertNode(root, mr.nextInt());

        List<Integer> ls = Node.inOrderTraversal(root);
        for (Integer i:ls)
            System.out.print(i+" ");
    }

    private static Node insertNode(Node root, int key) {
        if (root==null)
            return new Node(key);

        Deque<Node> dq=new LinkedList<>();
        Node node=root;
        dq.offer(root);
        while (!dq.isEmpty()){
             node=dq.poll();
             if (node.lchild != null){
                 dq.offer(node.lchild);
             }
             else {
                 node.lchild = new Node(key);
                 break;
             }
             if (node.rchild != null)
                 dq.offer(node.rchild);
             else {
                 node.rchild=new Node(key);
                 break;
             }
        }
        dq.clear();
        return root;
    }
}
