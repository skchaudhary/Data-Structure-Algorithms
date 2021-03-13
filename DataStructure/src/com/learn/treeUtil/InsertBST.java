package com.learn.treeUtil;

public class InsertBST
{
    public Node insert(Node root, int key)
    {
        if (root==null)
            return new Node(key);
        if (key<root.key)
            root.lchild=insert(root.lchild, key);
        else if (key>root.key)
            root.rchild=insert(root.rchild, key);

        return root;
    }
    public Node insertIterative(Node root, int key)
    {
        if (root==null)
            return new Node(key);
        Node tmp=root;
        while (tmp!=null){
            if (key<tmp.key){
                if (tmp.lchild==null){
                    tmp.lchild=new Node(key);
                    break;
                }
                else
                    tmp=tmp.lchild;
            }
            else if (key>tmp.key){
                if (tmp.rchild==null){
                    tmp.rchild=new Node(key);
                    break;
                }
                else
                    tmp=tmp.rchild;
            }
            else
                break;
        }
        return root;
    }
}
