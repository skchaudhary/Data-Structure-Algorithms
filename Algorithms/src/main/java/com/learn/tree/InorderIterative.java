package com.learn.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative
{
//    static class Node{
//        int key;
//        Node lchild, rchild;
//        Node(int key){
//            this.key = key;
//        }
//    }

    public static void main(String[] args) {
        Node root=new Node(0);
        root.lchild=new Node(1);
        root.rchild=new Node(2);
        root.lchild.lchild=new Node(3);
        root.lchild.rchild=new Node(4);
        root.rchild.lchild=new Node(5);
        root.rchild.rchild=new Node(6);

        root.lchild.lchild.lchild=new Node(7);
        root.lchild.rchild.lchild=new Node(9);
        root.rchild.lchild.lchild=new Node(11);
        root.rchild.rchild.lchild=new Node(13);
        root.lchild.lchild.rchild=new Node(8);
        root.lchild.rchild.rchild=new Node(10);
        root.rchild.lchild.rchild=new Node(12);
        root.rchild.rchild.rchild=new Node(14);

        List<Integer> ls = inOrderTraversal(root);

        for (Integer i:ls)
            System.out.print(i+" ");
        System.out.println();
    }

    public static List<Integer> inOrderTraversal(Node root) {
        List<Integer> ls = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        while (root !=null || !stack.empty()){
            while (root!=null){
                stack.push(root);
                root=root.lchild;
                continue;
            }
            root = stack.pop();
            ls.add(root.key);

            root=root.rchild;
        }
        return ls;
    }
}
