package com.learn.tree;

import com.learn.treeUtil.Node;
import com.learn.treeUtil.Traverse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrder
{
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);

        List<Integer> ls = preOrder(root);
        for (Integer i:ls)
            System.out.print(i+"=>");
        System.out.println();
        Traverse.preOrder(root);
    }

    private static List<Integer> preOrder(Node root) {
        List<Integer> result=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        Node node=root;
        while (!stack.empty() || node!=null){
            if (node!=null){
                result.add(node.key);
                stack.push(node);
                node=node.lchild;
                continue;
            }
            node=stack.pop();
            node=node.rchild;
        }
        return result;
    }
}
