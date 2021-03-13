package com.learn.tree;

import com.learn.treeUtil.Node;

public class KthSmallestElement
{
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);
        int k=4;
        Node node = kthSmallestElement(root, k);
        if (root != null)
            System.out.println("Kth Smallest element is: "+root.key);
        else
            System.out.println("Total node is less than "+k);
    }

    private static Node kthSmallestElement(Node root, int k) {
        if (root==null)
            return null;
        int count = countNode(root.lchild);
        if (k<=count)
            return kthSmallestElement(root.lchild, k);
        else if (k>count+1){
            return kthSmallestElement(root.rchild, k-count-1);
        }
        else
            return root;
    }

    private static int countNode(Node root) {
        if (root==null)
            return 0;
        return 1+countNode(root.lchild)+countNode(root.rchild);
    }
}
