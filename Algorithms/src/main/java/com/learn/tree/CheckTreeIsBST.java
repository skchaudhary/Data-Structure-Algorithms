package com.learn.tree;

public class CheckTreeIsBST
{
//    static class Node{
//        int key;
//        Node lchild, rchild;
//        Node(int key){
//            this.key = key;
//            lchild=rchild=null;
//        }
//    }

    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);

        root.lchild.lchild.lchild=new Node(1);
        root.lchild.rchild.lchild=new Node(5);
        root.rchild.lchild.lchild=new Node(9);
        root.rchild.rchild.lchild=new Node(13);
        root.lchild.lchild.rchild=new Node(3);
        root.lchild.rchild.rchild=new Node(7);
        root.rchild.lchild.rchild=new Node(11);
        root.rchild.rchild.rchild=new Node(15);

        boolean flag = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        if (flag)
            System.out.println("Tree is BST.");
        else
            System.out.println("Tree is not BST.");
    }

    public static boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.key<=min || root.key>=max)
            return false;

        return (isBST(root.lchild, min, root.key)
                && isBST(root.rchild, root.key, max));
    }
}
