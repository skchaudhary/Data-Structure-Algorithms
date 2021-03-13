package com.learn.tree;

import com.learn.util.MyReader;

import java.util.List;

public class InsertNodeBST
{
    public static void main(String[] args) {
        MyReader mr=new MyReader();
        System.out.println("Enter Number of nodes: ");
        int n=mr.nextInt();

        Node root=null;
        for (int i=0;i<n;i++)
            root = insertNode1(root, mr.nextInt());

        List<Integer> ls = Node.inOrderTraversal(root);
        for (Integer i:ls)
            System.out.print(i+" ");
    }

    public static Node insertNode(Node root, int key) {
        if (root==null)
            return new Node(key);

        if (key<root.key)
            root.lchild=insertNode(root.lchild, key);
        else if (key>root.key)
            root.rchild=insertNode(root.rchild, key);
        return root;
    }
    private static Node insertNode1(Node root, int key) {
        if (root==null)
            return new Node(key);
        Node node=root;
        while (node != null)
        {
            if (key<node.key) {
                if (node.lchild == null) {
                    node.lchild = new Node(key);
                    break;
                }
                else
                    node = node.lchild;
            }
            else if (key>node.key) {
                if (node.rchild == null) {
                    node.rchild = new Node(key);
                    break;
                }
                else
                    node = node.rchild;
            }
            else
                break;
        }
        return root;
    }
}