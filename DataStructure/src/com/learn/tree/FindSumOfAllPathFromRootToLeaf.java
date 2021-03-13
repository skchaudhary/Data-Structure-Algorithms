package com.learn.tree;

import com.learn.treeUtil.Node;

public class FindSumOfAllPathFromRootToLeaf
{
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.lchild.rchild=new Node(3);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);

        System.out.println(maxValue(root, 0));
    }

    private static int maxValue(Node root, int sum) {
        if (root==null)
            return 0;
        if (root.lchild==null && root.rchild==null)
            return sum*10+root.key;
        return maxValue(root.rchild, sum*10+root.key)
                +maxValue(root.rchild, sum*10+root.key);
    }
}
