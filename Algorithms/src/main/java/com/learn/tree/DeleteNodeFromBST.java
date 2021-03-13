package com.learn.tree;

import com.learn.util.MyReader;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DeleteNodeFromBST
{
    public static void main(String[] args) {
        MyReader mr=new MyReader();
        System.out.println("Enter Number of nodes: ");
        int n=mr.nextInt();

        Node root=null;
        for (int i=0;i<n;i++)
            root = InsertNodeBST.insertNode(root, mr.nextInt());

        root=delete1(root, 4);
        List<Integer> ls = Node.inOrderTraversal(root);
        for (Integer i:ls)
            System.out.print(i+" ");
    }

    private static Node delete(Node root, int key)
    {
        if (root == null)
            return null;

        if (key<root.key)
            root.lchild = delete(root.lchild, key);
        else if (key>root.key)
            root.rchild = delete(root.rchild, key);
        else {
            if (root.rchild==null)
                return root.lchild;
            else if (root.lchild==null)
                return root.rchild;
            else {
                root.key=minKey(root.rchild);
                root.rchild = delete(root.rchild, root.key);
            }
        }
        return root;
    }

    private static Node delete1(Node root, int key)
    {
        if (root == null)
            return null;
        Deque<Node> dq=new LinkedList<>();
        dq.offer(root);
        Node node = null;
        while (!dq.isEmpty()){
            node=dq.poll();
            if (key<node.key)
                dq.push(node.lchild);
            else if (key>node.key)
                dq.push(node.rchild);
            else {
                if (node.rchild==null) {
                    node = node.lchild;
                    break;
                }
                else if (node.lchild==null) {
                    node = node.rchild;
                    break;
                }
                else {
                    node.key=minKey(node.rchild);
                    node.rchild = delete(node.rchild, node.key);
                }
            }
        }
        return root;
    }

    private static int minKey(Node node)
    {
        while (node.lchild != null){
            node=node.lchild;
        }
        return node.key;
    }
}

/**
 15
 8 4 12 2 6 10 14 1 3 5 7 9 11 13 15

 1 2 3 5 6 7 8 9 10 11 12 13 14 15
 */