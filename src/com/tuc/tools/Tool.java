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

        System.out.println("Times compared in insertion in Binary Tree: " + Counter.getCounter(0)/10000);

        /*Search for 100 random numbers*/
        for(int i = 0; i<100; i++)
            bst.findKey(bst.getRoot(), UniqueRandomGenerator.getInstance().getRandomKeys()[i]);

        System.out.println("Times compared searching the key in Binary Tree: " + Counter.getCounter(1)/100);

        for(int i = 0; i<100; i++)
            BinarySearch.binarySearch(UniqueRandomGenerator.getInstance().getSortedInts(), 0,
                    UniqueRandomGenerator.getInstance().getSortedInts().length, i);

        System.out.println("Times compared searching the key: " + Counter.getCounter(4)/100);

    }
}
