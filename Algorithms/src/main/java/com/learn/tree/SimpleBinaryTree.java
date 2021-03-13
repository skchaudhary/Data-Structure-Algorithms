package com.learn.tree;

public class SimpleBinaryTree
{
//    static class Node{
//        int key;
//        Node lchild, rchild;
//        Node(int key){
//            this.key=key;
//            lchild=rchild=null;
//        }
//    }
    public static void main(String[] args) {
        Node root=new Node(0);
        root.lchild=new Node(1);
        root.rchild=new Node(2);
        root.lchild.lchild=new Node(3);
        root.lchild.rchild=new Node(4);
        root.rchild.lchild=new Node(5);
        root.rchild.rchild=new Node(6);

        System.out.println("\nPreorder traversal: ");
        preorder(root);
        System.out.println("\nInorder traversal: ");
        inorder(root);
        System.out.println("\nPostorder traversal: ");
        postorder(root);
    }

    public static void postorder(Node root) {
        if (root==null)
            return;
        postorder(root.lchild);
        postorder(root.rchild);
        System.out.print(root.key+"==>");
    }

    public static void inorder(Node root) {
        if (root==null)
            return;
        inorder(root.lchild);
        System.out.print(root.key+"==>");
        inorder(root.rchild);
    }

    public static void preorder(Node root) {
        if (root==null)
            return;
        System.out.print(root.key+"==>");
        preorder(root.lchild);
        preorder(root.rchild);
    }
}
