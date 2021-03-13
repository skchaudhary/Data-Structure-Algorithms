package com.learn.tree;

import com.learn.treeUtil.Node;

public class MaxPath
{
    public static int maxValue;
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.lchild.rchild=new Node(3);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);
        root.rchild.rchild.rchild=new Node(20);
        root.rchild.rchild.rchild.rchild=new Node(56);

        System.out.println(maxPath(root));
    }

    private static int maxPath(Node root) {
        maxValue = Integer.MIN_VALUE;
        maxPathSum(root);
        return maxValue;
    }

    private static int maxPathSum(Node root) {
        if (root==null)
            return 0;
        int left=Math.max(0, maxPathSum(root.lchild));
        int right=Math.max(0, maxPathSum(root.rchild));

        maxValue=Math.max(maxValue, left+right+root.key);
        return Math.max(left, right)+root.key;
    }
}
