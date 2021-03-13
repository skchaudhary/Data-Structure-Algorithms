package com.learn.tree;

import com.learn.treeUtil.Node;
import com.learn.treeUtil.Traverse;

public class RevertBT
{
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);

        Node node = revert(root);

        Traverse.inOrder(node);
    }

    private static Node revert(Node root) {
        if (root==null)
            return null;
        Node left = revert(root.lchild);
        Node right = revert(root.rchild);

        root.lchild = right;
        root.rchild = left;

        return root;
    }
}
