package com.learn.tree;

public class ConstructBTreeFromInPre
{
    public static void main(String[] args) {
        int[] inorder=new int[]{2, 4, 6, 8, 10, 12, 14};
        int[] preorder=new int[]{8, 4, 2, 6, 12, 10, 14};//postorder 2==>6==>4==>10==>14==>12==>8

        Node root=constructBtree(inorder, preorder);
        SimpleBinaryTree.preorder(root);
        System.out.println();
        SimpleBinaryTree.inorder(root);
        System.out.println();
        SimpleBinaryTree.postorder(root);
    }

    public static Node constructBtree(int[] inorder, int[] preorder) {
        if (inorder==null || preorder==null || inorder.length!=preorder.length)
            return null;

        return constructBtree(0, 0, inorder.length-1, inorder, preorder);
    }

    private static Node constructBtree(int inStart, int preStart, int inLength, int[] inorder, int[] preorder) {
        if (preStart>preorder.length-1 || inStart>inLength)
            return null;
        Node root=new Node(preorder[preStart]);
        int inIndex=0;
        for (int i=inStart;i<=inLength;i++){
            if (inorder[i]==root.key) {
                inIndex = i;
            }
        }
        root.lchild=constructBtree(inStart, preStart+1, inIndex-1, inorder, preorder);
        root.rchild=constructBtree(inIndex+1,preStart+(inIndex-inStart)+1,
                inLength, inorder, preorder);

        return root;
    }
}
