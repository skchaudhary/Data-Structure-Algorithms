package com.learn.treeUtil;

public class NodeWithNext
{
    public int key;
    public NodeWithNext lchild;
    public NodeWithNext rchild;
    public NodeWithNext next;
    public NodeWithNext(int key){
        this.key=key;
        lchild=rchild=next=null;
    }
}
