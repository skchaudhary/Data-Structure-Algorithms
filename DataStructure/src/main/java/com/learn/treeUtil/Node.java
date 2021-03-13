package com.learn.treeUtil;

public class Node
{
    public int key;
    public Node lchild;
    public Node rchild;
    public Node(int key)
    {
        this.key=key;
        lchild=rchild=null;
    }
}
