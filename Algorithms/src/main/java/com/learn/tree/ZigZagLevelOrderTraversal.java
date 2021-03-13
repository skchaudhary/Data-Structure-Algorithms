package com.learn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal
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

        root.lchild.lchild.lchild=new Node(7);
        root.lchild.rchild.lchild=new Node(9);
        root.rchild.lchild.lchild=new Node(11);
        root.rchild.rchild.lchild=new Node(13);
        root.lchild.lchild.rchild=new Node(8);
        root.lchild.rchild.rchild=new Node(10);
        root.rchild.lchild.rchild=new Node(12);
        root.rchild.rchild.rchild=new Node(14);

        List<List<Integer>> ll = zigZaglevelOrderTraversal(root);

        for (List<Integer> levelList:ll){
            for (Integer i:levelList)
                System.out.print(i+" ");
            System.out.println();
        }

        ll = zigZagReverselevelOrderTraversal(root);

        for (int i=ll.size()-1;i>=0;i--){
            List<Integer> levelList = ll.get(i);
            for (Integer j:levelList)
                System.out.print(j+" ");
            System.out.println();
        }
    }

    private static List<List<Integer>> zigZaglevelOrderTraversal(Node root) {
        List<List<Integer>> ll = new LinkedList<>();
        if (root == null)
            return ll;

        boolean reverseLevel = false;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int nodeCount = q.size();
            List<Integer> levelValues = new ArrayList<>();

            for (int i=0;i<nodeCount;i++){
                root = q.poll();
                if (reverseLevel)
                    levelValues.add(0, root.key);
                else
                    levelValues.add(root.key);

                if (root.lchild != null)
                    q.offer(root.lchild);
                if (root.rchild != null)
                    q.offer(root.rchild);
            }
            ll.add(levelValues);
            reverseLevel = !reverseLevel;
        }
        return ll;
    }

    private static List<List<Integer>> zigZagReverselevelOrderTraversal(Node root) {
        List<List<Integer>> ll = new LinkedList<>();
        if (root == null)
            return ll;
        int ht = height(root);
        boolean reverseLevel = ht%2 == 0? false : true;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int nodeCount = q.size();
            List<Integer> levelValues = new ArrayList<>();

            for (int i=0;i<nodeCount;i++){
                root = q.poll();
                if (reverseLevel)
                    levelValues.add(0, root.key);
                else
                    levelValues.add(root.key);

                if (root.lchild != null)
                    q.offer(root.lchild);
                if (root.rchild != null)
                    q.offer(root.rchild);
            }
            ll.add(levelValues);
            reverseLevel = !reverseLevel;
        }
        return ll;
    }

    private static int height(Node root) {
        if (root==null) return 0;
        return Math.max(height(root.lchild), height(root.rchild))+1;
    }
}
