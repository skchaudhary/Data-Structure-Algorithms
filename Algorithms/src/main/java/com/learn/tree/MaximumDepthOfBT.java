package com.learn.tree;

public class MaximumDepthOfBT
{
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);

        SimpleBinaryTree.postorder(root);

        System.out.println("Maximum depth of binary Tree: "+maxDepth(root));
    }

    public static int maxDepth(Node root) {
        return findDepth(root);
    }

    private static int findDepth(Node root) {
        if (root == null)
            return 0;
        return Integer.max(findDepth(root.lchild)+1, findDepth(root.rchild)+1);
    }
}
