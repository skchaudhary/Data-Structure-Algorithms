package com.learn.tree;

import com.learn.treeUtil.Node;
import com.learn.treeUtil.Traverse;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder
{
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);

        List<Integer> ls=postOrder(root);
        for (Integer i:ls)
            System.out.print(i+"=>");

        System.out.println();
        Traverse.postOrder(root);
    }

    private static List<Integer> postOrder(Node root) {
        Stack<Node> stack=new Stack<>();
        LinkedList<Integer> result=new LinkedList<>();
        Node p=root;
        while (!stack.empty() || p!=null){
            if (p!=null){
                result.addFirst(p.key);
                stack.push(p);
                p=p.rchild;
                continue;
            }
            Node node=stack.pop();
            p=node.lchild;
        }
        return result;
    }
}
