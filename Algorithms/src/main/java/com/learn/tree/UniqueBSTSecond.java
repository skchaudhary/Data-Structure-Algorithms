package com.learn.tree;

import com.learn.util.MyReader;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTSecond
{
    public static void main(String[] args) {
        MyReader mr = new MyReader();
        System.out.println("Enter number of node to find all BST: ");
        int n = mr.nextInt();
        List<Node> ls = findAllBST(n);
        for (Node node:ls) {
            //System.out.println(node.key);
            SimpleBinaryTree.preorder(node);
            System.out.println();
        }
    }

    private static List<Node> findAllBST(int n) {
        return findAllBST(1, n);
    }

    private static List<Node> findAllBST(int start, int end) {
        List<Node> ls=new ArrayList<>();
        if (start>end){
            ls.add(null);
            return ls;
        }
        if (start==end){
            ls.add(new Node(start));
            return ls;
        }
        List<Node> left, right;
        for (int i=start;i<=end;i++){
            left=findAllBST(start, i-1);
            right=findAllBST(i+1, end);
            for (Node lnode:left){
                for (Node rnode:right){
                    Node root=new Node(i);
                    root.lchild=lnode;
                    root.rchild=rnode;
                    ls.add(root);
                }
            }
        }
        return ls;

    }
}
