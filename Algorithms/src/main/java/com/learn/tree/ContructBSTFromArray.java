package com.learn.tree;

public class ContructBSTFromArray
{
    public static void main(String[] args) {
        int[] arr=new int[]{2, 4, 6, 8, 10, 12, 14};
        Node root=constructBST(arr, 0, arr.length);
        SimpleBinaryTree.preorder(root);
        System.out.println();
        SimpleBinaryTree.inorder(root);
        System.out.println();
        SimpleBinaryTree.postorder(root);
    }

    private static Node constructBST(int[] arr, int low, int high) {
        Node root=null;
        if (low<high){
            int mid=(low+high)/2;
            root=new Node(arr[mid]);

            root.lchild=constructBST(arr, low, mid);
            root.rchild=constructBST(arr, mid+1, high);
        }
        return root;
    }
}
