package com.learn.tree;

import com.learn.treeUtil.Node;

public class PathSum
{
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(4);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(6);
        root.rchild.rchild=new Node(2);
        root.rchild.rchild.rchild=new Node(20);
        root.rchild.rchild.rchild.rchild=new Node(56);
        int sum=90;
        System.out.println("Is tree consist PathSum for sum "+sum+"? : "+ hasPathSum(root, sum));
    }

    private static boolean hasPathSum(Node root, int sum) {
        if (root==null)
            return false;
        if (root.lchild==null && root.rchild==null && (sum-root.key)==0)
            return true;
        return hasPathSum(root.lchild, sum-root.key)
                || hasPathSum(root.rchild, sum-root.key);
    }
}
