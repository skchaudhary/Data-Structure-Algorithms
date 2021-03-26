package com.studypoint.hackerEarth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class LockingTreeOfSpace {
    static class Node {
        List<Node> descendents;
        String name;
        Integer userId;
        Node parent;
        public Node(String name, int m){
            this.name = name;
            descendents = new ArrayList<>(m);
            userId = null;
            parent = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());;
        int numberOfOperation = Integer.parseInt(sc.nextLine());;
        Node root=null, current=null;
        Queue<Node> queue = new LinkedList<>();
        int c=0;

        Map<String, Node> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            String name = sc.nextLine();
            if (root!=null) {
                if (c==m) {
                    current = queue.poll();
                    c=0;
                }
                Node newNode=new Node(name, m);
                newNode.parent = current;
                current.descendents.add(newNode);
                queue.offer(newNode);
                map.put(name, newNode);
                c++;
            } else {
                root=current=new Node(name, m);
                map.put(name, root);
            }
        }

        for (int i=0;i<numberOfOperation;i++) {
            String operation = sc.nextLine();
            String[] operationArray=operation.split(" ");
            int operationType = Integer.parseInt(operationArray[0]);
            String name = operationArray[1];
            int userId = Integer.parseInt(operationArray[2]);
            if (operationType == 1) {
                Node node = map.get(name);
                if (descendentsNotLocked(node, userId) && ancestorNotLocked(node.parent, userId)) {
                    node.userId = userId;
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            } else if (operationType == 2) {
                Node node = map.get(name);
                if (node.userId!=null) {
                    node.userId = null;
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            } else if (operationType==3) {
                Node node = map.get(name);
                if (node.userId == null && descendentsLockedBySameUser(node, userId)) {
                    unLockDescendents(node, userId);
                    node.userId=userId;
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            }
        }

    }

    private static boolean ancestorNotLocked(Node node, int userId) {
        if (node==null) {
            return true;
        }

        while (node.parent != null) {
            if (node.userId!=null) {
                return false;
            }
            node=node.parent;
        }
        return true;
    }

    private static boolean descendentsNotLocked(Node node, int userId) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node nodeElement = queue.poll();
            if (nodeElement.userId!=null) {
                return false;
            }
            for (Node node1:nodeElement.descendents) {
                queue.offer(node1);
            }
        }
        return true;
    }

    private static boolean descendentsLockedBySameUser(Node node, int userId) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        boolean flag=false;
        while (!queue.isEmpty()) {
            Node nodeElement = queue.poll();
            if (nodeElement.userId!=null) {
                if (nodeElement.userId != userId) {
                    return false;
                } else {
                    flag=true;
                }
            }
            for (Node node1:nodeElement.descendents) {
                queue.offer(node1);
            }
        }
        return flag;
    }

    private static void unLockDescendents(Node node, int userId) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node nodeElement = queue.poll();
            if (nodeElement.userId!=null && nodeElement.userId == userId) {
                nodeElement.userId = null;
            }
            for (Node node1:nodeElement.descendents) {
                queue.offer(node1);
            }
        }
    }
}
