package com.learn.tree;

import com.learn.treeUtil.Node;

public class CheckBTreeIsBalanced
{
    final static int UN_BALANCED=-1;
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

        System.out.println("Is tree Balanced? : "+ isBalanced(root));
    }

    private static boolean isBalanced(Node root) {
        return heightDifferance(root)!=-1;
    }

    private static int heightDifferance(Node root) {
        if (root==null)
            return 0;
        if (root.lchild==null && root.rchild==null)
            return 1;
        int left=heightDifferance(root.lchild);
        if (left==UN_BALANCED)
            return UN_BALANCED;

        int right=heightDifferance(root.rchild);
        if (right==UN_BALANCED)
            return UN_BALANCED;

        if (Math.abs(left-right)>1)
            return UN_BALANCED;

        return Integer.max(left, right)+1;
    }
}
