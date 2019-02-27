package com.fs.algorithm.search;

import java.util.ArrayList;
import java.util.List;

public class Bintree {
    Node root;
    static class Node{
        private Node pre;
        private Integer value;
        private Node left;
        private Node right;
    }

    public Bintree addNode(Integer value){
        Node node = new Node();
        node.value=value;
        if (root==null){
            root = node;
            return this;
        }
        addNode(root,node);
        return this;
    }
    public Bintree addNode(Node node){
        if (root==null){
            root = node;
            return this;
        }
        addNode(root,node);
        return this;
    }
    public void addNode(Node root,Node addNode){
        if (addNode.value<=root.value){
            if (root.left==null){
                root.left = addNode;
                addNode.pre=root;
            }else {
                addNode(root.left,addNode);
            }
        }else if (addNode.value>root.value){
            if (root.right==null){
                root.right=addNode;
                addNode.pre=root;
            }else {
                addNode(root.right,addNode);
            }
        }
    }

    public List<Node> search(Integer value){
        if (root==null){
            return null;
        }
        List<Node> nodes = new ArrayList<Node>();
        return search(root,value,nodes);
    }
    public List<Node> search(Node root,Integer value,List<Node> nodes){
        if (root==null){
            return null;
        }
        if (root.value==value){
            nodes.add(root);
        }
        if (root.left!=null){
            search(root.left,value,nodes);
        }
        if (root.right!=null){
            search(root.right,value,nodes);
        }
        return nodes;
    }


    public static void main(String[] args){
        Bintree bintree = new Bintree();
        bintree.addNode(4);
        bintree.addNode(1);
        bintree.addNode(2);
        bintree.addNode(5);
        bintree.addNode(3);
        bintree.addNode(8);
        bintree.addNode(30);
        bintree.addNode(23);
        bintree.addNode(7);
        bintree.addNode(3);
        bintree.addNode(8);

        List<Node> nodes = bintree.search(3);
        System.out.println(nodes);
    }

}
