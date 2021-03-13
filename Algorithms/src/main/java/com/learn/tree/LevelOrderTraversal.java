package com.learn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal
{
    static class Node
    {
        int key;
        Node lchild, rchild;
        Node(int key)
        {
            this.key=key;
        }
    }

    public static void main(String[] args) {
        Node root=new Node(0);
        root.lchild=new Node(1);
        root.rchild=new Node(2);
        root.lchild.lchild=new Node(3);
        root.lchild.rchild=new Node(4);
        root.rchild.lchild=new Node(5);
        root.rchild.rchild=new Node(6);

        List<List<Integer>> ll = levelOrderTraversal(root);

        for (List<Integer> levelList:ll){
            for (Integer i:levelList)
                System.out.print(i+" ");
            System.out.println();
        }
    }

    private static List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> ll = new LinkedList<>();

        Queue<Node> q = new LinkedList<>();
        if (root == null)
            return ll;
        q.offer(root);
        while (!q.isEmpty())
        {
            int nodeCount = q.size();
            List<Integer> levelValues = new ArrayList<>();
            for (int i=0;i<nodeCount;i++)
            {
                root = q.poll();
                levelValues.add(root.key);

                if (root.lchild != null)
                    q.offer(root.lchild);
                if (root.rchild != null)
                    q.offer(root.rchild);
            }
            ll.add(levelValues);
        }
        return ll;
    }
}
