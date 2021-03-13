package com.learn.tree;

public class CheckIdenticalTree
{
    public static void main(String[] args) {
        Node root1=new Node(8);
        root1.lchild=new Node(4);
        root1.rchild=new Node(12);
        root1.lchild.lchild=new Node(2);
        root1.lchild.rchild=new Node(6);
        root1.rchild.lchild=new Node(10);
        root1.rchild.rchild=new Node(14);

        Node root2=new Node(8);
        root2.lchild=new Node(4);
        root2.rchild=new Node(12);
        root2.lchild.lchild=new Node(2);
        root2.lchild.rchild=new Node(6);
        root2.rchild.lchild=new Node(10);
        root2.rchild.rchild=new Node(14);

        System.out.println("Is tree Identical?: "+identicalTreeCheck(root1, root2));
    }

    private static Boolean identicalTreeCheck(Node root1, Node root2) {
        if (root1==null && root2==null)
            return true;
        if (root1==null || root2==null)
            return false;
        if (root1.key!=root2.key)
            return false;
        return identicalTreeCheck(root1.lchild, root2.lchild)
                && identicalTreeCheck(root1.rchild, root2.rchild);
    }
}
