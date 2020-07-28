package com.darren.center.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>tank-service</h3>
 * <p>组合模式</p>
 *
 * @author : Darren
 * @date : 2020年07月28日 10:18:55
 **/
public class Main {

    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode b1 = new BranchNode("BranchNode1");
        BranchNode b2 = new BranchNode("BranchNode2");
        Node l1 = new LeafNode("LeafNode1");
        Node l2 = new LeafNode("LeafNode2");
        Node l3 = new LeafNode("LeafNode3");

        BranchNode b3 = new BranchNode("BranchNode3");
        Node l4 = new LeafNode("LeafNode4");
        Node l5 = new LeafNode("LeafNode5");

        //root添加分支节点
        root.add(b1);
        root.add(b2);
        //root添加叶子节点
        root.add(l1);

        //分支一添加叶子节点
        b1.add(l2);
        b1.add(l3);
        //分支二添加分支节点
        b2.add(b3);

        //分支二的子分支添加叶子节点
        b3.add(l4);
        b3.add(l5);

        tree(root, 0);
    }

    /**
     * 递归调用 -> 栈式遍历
     * @param b
     */
    static void tree(Node b, int depth){
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        b.p();
        if (b instanceof BranchNode){
            for (Node node : ((BranchNode) b).nodes) {
                tree(node, depth + 1);
            }
        }
    }

}

abstract class Node{
    abstract void p();
}

/**
 * 叶子节点
 */
class LeafNode extends Node{

    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    void p() {
        System.out.println(content);
    }
}

/**
 * 分支节点
 */
class BranchNode extends Node{

    List<Node> nodes = new ArrayList<>();

    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    void p() {
        System.out.println(name);
    }

    public void add(Node n){
        nodes.add(n);
    }
}


