package com.learn.tree;

public class CheckTreeIsSymmetric
{
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(4);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(6);
        root.rchild.rchild=new Node(2);

        System.out.println("Is tree symmetric?: "+isSymmetric(root));
    }

    public static boolean isSymmetric(Node root)
    {
        if (root==null)
            return true;
        return isMirror(root.lchild, root.rchild);
    }

    private static boolean isMirror(Node lchild, Node rchild) {
        if (lchild == null && rchild == null)
            return true;
        if (lchild == null || rchild == null)
            return false;
        if (lchild.key==rchild.key){
            return isMirror(lchild.lchild, rchild.rchild)
                    && isMirror(lchild.rchild, rchild.lchild);
        }
        return false;
    }
}
