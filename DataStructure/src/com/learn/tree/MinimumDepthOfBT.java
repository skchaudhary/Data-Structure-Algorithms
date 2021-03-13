package com.learn.tree;

import com.learn.treeUtil.Node;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDepthOfBT
{
    public static void main(String[] args) {
        Node root=new Node(8);
        root.lchild=new Node(4);
        root.rchild=new Node(4);
        root.lchild.lchild=new Node(2);
        root.lchild.rchild=new Node(6);
        root.rchild.lchild=new Node(6);
        root.rchild.rchild=new Node(2);
        root.rchild.rchild.rchild=new Node(20);
        root.rchild.rchild.rchild.rchild=new Node(56);

        System.out.println("Minimum Depth of BT: "+ getMinDepth(root));
    }

    private static int getMinDepth(Node root) {
        if (root==null)
            return 0;
        Deque<Node> dq=new LinkedList<>();
        dq.offer(root);
        int depth=0;
        while (!dq.isEmpty()){
            depth++;
            int nodeCount= dq.size();
            for (int i=0;i<nodeCount;i++){
                root=dq.poll();
                if (root.lchild==null && root.rchild==null)
                    return depth;
                if (root.lchild!=null)
                    dq.offer(root.lchild);
                if (dq.offer(root.rchild))
                    dq.offer(root.rchild);
            }
        }
        return depth;
    }
}
