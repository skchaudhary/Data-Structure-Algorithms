package com.learn.tree;

import com.learn.treeUtil.Node;

import java.util.ArrayList;
import java.util.List;

public class BSTLeftView
{
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);

        List<Integer> ls=leftView(root);
        for(Integer i: ls)
            System.out.print(i+"=>");
        System.out.println();
    }

    public static List<Integer> leftView(Node root) {
        List<Integer> result=new ArrayList<>();
        leftView(root, result, result.size());
        return result;
    }

    private static void leftView(Node root, List<Integer> result, int depth) {
        if (root==null)
            return;
        if (depth==result.size())
            result.add(root.key);
        leftView(root.lchild, result, depth+1);
        leftView(root.rchild, result, depth+1);
    }
}
