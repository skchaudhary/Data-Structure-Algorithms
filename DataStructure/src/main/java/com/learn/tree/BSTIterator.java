package com.learn.tree;

import com.learn.treeUtil.Node;

import java.util.Stack;

public class BSTIterator
{
    private static Stack<Node> stack;
    public BSTIterator(Node root){
        stack = new Stack<>();
        Node cur = root;
        while (cur!=null){
            stack.push(cur);
            if (cur.lchild!=null)
                cur=cur.lchild;
            else
                break;
        }
    }
    public boolean hasNext(){
        return !stack.empty();
    }
    public int next(){
        Node node = stack.pop();
        Node cur=node;
        if (cur.rchild!=null){
            cur = cur.rchild;
            while (cur!=null){
                stack.push(cur);
                if (cur.lchild!=null)
                    cur=cur.lchild;
                else
                    break;
            }
        }
        return node.key;
    }

    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(12);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(10);
        root.rchild.rchild=new Node(14);

        BSTIterator bit=new BSTIterator(root);
        while (bit.hasNext())
            System.out.print(bit.next()+"=>");
        System.out.println();
    }
}
