package com.learn.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Node
{
    int key;
    Node lchild;
    Node rchild;
    Node(int key)
    {
        this.key=key;
        lchild=rchild=null;
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
