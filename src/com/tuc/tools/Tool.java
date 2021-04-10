package com.tuc.tools;

import com.tuc.bst.BinarySearchTree;

public class Tool {


    static BinarySearchTree bst = new BinarySearchTree();

    public static void main(String[] args) {
        /*Fill the tree with random numbers*/
        for(int i = 0; i<10000; i++){
            bst.resetCurrentPos();
            bst.insert(UniqueRandomGenerator.getInstance().getRandomInts()[i], 0);
        }

        /*Search for a random number and print its position*/
        System.out.println(bst.findKey(bst.getRoot(), UniqueRandomGenerator.getInstance().getRandomKeys()[99]));

    }
}
