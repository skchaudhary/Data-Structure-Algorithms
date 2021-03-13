package com.learn.tree;

import com.learn.treeUtil.NodeWithNext;

public class PopulatingNextRightPointer
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
        if (root.lchild!=null)
            root.lchild.next=root.rchild;
        if (root.rchild!=null)
            root.rchild.next=(root.next!=null)?root.next.lchild:null;

        populate(root.lchild);
        populate(root.rchild);
    }
}
