package com.learn.treeUtil;

public class Traverse
{
    public static void inOrder(Node root){
        if (root==null)
            return;
        inOrder(root.lchild);
        System.out.print(root.key+"=>");
        inOrder(root.rchild);
    }
    public static void preOrder(Node root){
        if (root==null)
            return;
        System.out.print(root.key+"=>");
        preOrder(root.lchild);
        preOrder(root.rchild);
    }
    public static void postOrder(Node root){
        if (root==null)
            return;
        postOrder(root.lchild);
        postOrder(root.rchild);
        System.out.print(root.key+"=>");
    }
}
