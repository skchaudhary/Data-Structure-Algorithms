package com.learn.tree;

import com.learn.treeUtil.Node;

public class FlattenBTToLinkedList
{
    static Node processedNode=null;
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);

        flatten(root);
        while (root!=null){
            System.out.print(root.key+"=>");
            root=root.rchild;
        }
    }

    private static void flatten(Node root) {
        if (root==null)
            return;
        flatten(root.rchild);
        flatten(root.lchild);

        root.rchild=processedNode;
        root.lchild=null;

        processedNode=root;
    }
}
