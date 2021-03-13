package com.learn.tree;

public class ConstructBTreeFromInPost
{
    public static void main(String[] args) {
        int[] inorder=new int[]{2, 4, 6, 8, 10, 12, 14};
        int[] postoreder=new int[]{2, 6, 4, 10, 14, 12, 8};//preorder 8, 4, 2, 6, 12, 10, 14

        Node root=constructBT(inorder, postoreder);
        SimpleBinaryTree.preorder(root);
        System.out.println();
        SimpleBinaryTree.inorder(root);
        System.out.println();
        SimpleBinaryTree.postorder(root);
    }

    public static Node constructBT(int[] inorder, int[] postoreder) {
        if (inorder==null || postoreder==null || inorder.length!=postoreder.length)
            return null;

        return constructBT(0, postoreder.length-1, inorder.length-1, inorder, postoreder);
    }

    private static Node constructBT(int inStart, int pStart, int inLength, int[] inorder, int[] postoreder) {
        if (inStart>inLength || pStart<0)
            return null;
        Node root=new Node(postoreder[pStart]);
        int inIndex=0;
        for(int i=inStart;i<=inLength;i++){
            if (inorder[i]==root.key)
                inIndex=i;
        }

        root.lchild=constructBT(inStart, pStart-(inIndex-inStart)-1, inIndex-1, inorder, postoreder);
        root.rchild=constructBT(inIndex+1, pStart-1, inLength, inorder, postoreder);
        return root;
    }
}
