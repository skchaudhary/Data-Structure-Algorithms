package com.learn.tree;

import java.util.logging.Logger;

public class RecoverBST
{
    final static Logger logger = Logger.getLogger(RecoverBST.class.getName());
    static Node firstNode=null;
    static Node secondNode=null;
    static Node prevNode=new Node(Integer.MIN_VALUE);
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(13);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);

        root.lchild.lchild.lchild=new Node(1);
        root.lchild.rchild.lchild=new Node(5);
        root.rchild.lchild.lchild=new Node(9);
        root.rchild.rchild.lchild=new Node(6);
        root.lchild.lchild.rchild=new Node(3);
        root.lchild.rchild.rchild=new Node(7);
        root.rchild.lchild.rchild=new Node(11);
        root.rchild.rchild.rchild=new Node(15);

        System.out.println("Is tree is BST?: "
                +CheckTreeIsBST.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        recoverBST(root);
        SimpleBinaryTree.inorder(root);
    }

    private static void recoverBST(Node root) {
        traverse(root);

        try {
            int tmp=firstNode.key;
            firstNode.key=secondNode.key;
            secondNode.key=tmp;
        }
        catch (NullPointerException e){
            logger.info("NullPointer Exception caught");
        }
    }

    private static void traverse(Node root) {
        if (root==null)
            return;
        traverse(root.lchild);

        if (firstNode == null && prevNode.key>=root.key)
            firstNode=prevNode;

        if (firstNode != null && prevNode.key >= root.key)
            secondNode=root;
        prevNode=root;

        traverse(root.rchild);
    }
}
