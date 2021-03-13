package com.learn.tree;

import com.learn.treeUtil.NodeWithNext;

import java.util.Deque;
import java.util.LinkedList;

public class PopulatingNextRightPointerIterative
{
    public static void main(String[] args) {
        NodeWithNext root=new NodeWithNext(8);
        root.lchild=new NodeWithNext(4);
        root.rchild=new NodeWithNext(12);
        root.lchild.lchild=new NodeWithNext(2);
        root.lchild.rchild=new NodeWithNext(6);
        root.rchild.lchild=new NodeWithNext(10);
        root.rchild.rchild=new NodeWithNext(14);

        populate(root);
        while (root!=null){
            NodeWithNext tmp=root;
            while (tmp!=null){
                System.out.print(tmp.key+"=>");
                tmp=tmp.next;
            }
            System.out.println();
            root=root.lchild;
        }
    }

    private static void populate(NodeWithNext root) {
        if (root==null)
            return;

        Deque<NodeWithNext> dq=new LinkedList<>();
        dq.offer(root);
        while (!dq.isEmpty()){
            NodeWithNext prev=null;
            int nodeCount=dq.size();
            for (int i=0;i<nodeCount;i++){
                NodeWithNext node=dq.poll();
                if (prev!=null)
                    prev.next=node;

                prev=node;

                if (node.lchild!=null)
                    dq.offer(node.lchild);
                if (node.rchild!=null)
                    dq.offer(node.rchild);
            }
        }
    }
}
