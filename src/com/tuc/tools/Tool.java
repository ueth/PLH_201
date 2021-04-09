package com.tuc.tools;

import com.tuc.bst.BinarySearchTree;

import java.util.Random;

public class Tool {


    static BinarySearchTree bst = new BinarySearchTree();
    static Random r = new Random();

    public static void main(String[] args) {
        bst.resetCurrentPos();

        //for(int i = 0)

        System.out.println("ADD 10");
        bst.insert(10, bst.getRoot());
        bst.resetCurrentPos();
        System.out.println("ADD 13");
        bst.insert(13, bst.getRoot());
        bst.resetCurrentPos();
        System.out.println("ADD 15");
        bst.insert(15, bst.getRoot());
        bst.resetCurrentPos();
        System.out.println("ADD 5");
        bst.insert(5, bst.getRoot());
        bst.resetCurrentPos();
        System.out.println("ADD 11");
        bst.insert(11, bst.getRoot());
        bst.resetCurrentPos();
        System.out.println("ADD 4");
        bst.insert(4, bst.getRoot());
        bst.resetCurrentPos();
        System.out.println("ADD 6");
        bst.insert(6, bst.getRoot());
        bst.resetCurrentPos();
        System.out.println("ADD 3");
        bst.insert(3, bst.getRoot());
        bst.resetCurrentPos();
        System.out.println("ADD 2");
        bst.insert(2, bst.getRoot());
        bst.resetCurrentPos();
        System.out.println("ADD 0");
        bst.insert(0, bst.getRoot());
        bst.resetCurrentPos();
        System.out.println("ADD 1");
        bst.insert(1, bst.getRoot());

        bst.printTree(bst.getRoot(), 1);



//        System.out.println("in main" + bst.getTree()[bst.getRoot()][0]);

    }
}
