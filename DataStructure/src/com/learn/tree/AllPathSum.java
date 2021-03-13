package com.learn.tree;

import com.learn.treeUtil.Node;

import java.util.LinkedList;
import java.util.List;

public class AllPathSum
{
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(4);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(2);
        root.rchild.rchild=new Node(2);
        root.rchild.rchild.rchild=new Node(20);
        root.rchild.rchild.rchild.rchild=new Node(56);

        int sum=14;
        List<List<Integer>> result=findPath(root, sum);
        for (List<Integer> ls:result) {
            for (Integer i : ls)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    private static List<List<Integer>> findPath(Node root, int sum) {
        List<List<Integer>> result=new LinkedList<>();
        List<Integer> currentResult=new LinkedList<>();
        findPath(root, sum, result, currentResult);

        return result;
    }

    private static void findPath(Node root, int sum, List<List<Integer>> result, List<Integer> currentResult) {
        if (root==null)
            return;
        currentResult.add(new Integer(root.key));
        if (root.lchild==null && root.rchild==null && root.key==sum){
            result.add(new LinkedList<>(currentResult));
            currentResult.remove(currentResult.size()-1);
            return;
        }
        else {
            findPath(root.lchild, sum-root.key, result, currentResult);
            findPath(root.rchild, sum-root.key, result, currentResult);
        }
        currentResult.remove(currentResult.size()-1);
    }
}
