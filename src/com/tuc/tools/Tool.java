package com.tuc.tools;

import com.tuc.bst.BinarySearchTree;

public class Tool {


    static BinarySearchTree bst = new BinarySearchTree();

    public static void main(String[] args) {
        bst.resetCurrentPos();

        for(int i = 0; i<100; i++){
            bst.insert(UniqueRandomGenerator.getInstance().getRandomKeys()[i], 0);
        }

        //bst.printTree(bst.getRoot(), 1);

        //System.out.println(bst.findKey(bst.getRoot(), 100));




//        System.out.println("in main" + bst.getTree()[bst.getRoot()][0]);

    }
}
