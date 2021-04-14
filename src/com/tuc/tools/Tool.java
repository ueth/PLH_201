package com.tuc.tools;

import com.tuc.bst.BinaryTree;
import com.tuc.bst.ThreadedBinaryTree;

public class Tool {

    static BinaryTree bst = new BinaryTree();
    static ThreadedBinaryTree tbst = new ThreadedBinaryTree();

    public static void main(String[] args) {
        binaryTreeOperations();
        threadedBinaryTreeOperations();
        sortedArrayOperations();
    }

    private static void binaryTreeOperations(){
        System.out.println("");
        System.out.println("---BinaryTree Searches---");

        /*Fill the tree with random numbers*/
        for(int i = 0; i<10000; i++){
            bst.resetCurrentPos();
            bst.insert(UniqueRandomGenerator.getInstance().getRandomInts()[i], 0);
        }
        System.out.println("Times compared in insertion in Binary Tree: " + Counter.getCounter(0)/10000);

        /*Search for 100 random numbers*/
        for(int i = 0; i<100; i++)
            bst.findKey(bst.getRoot(), UniqueRandomGenerator.getInstance().getRandomKeys()[i]);
        System.out.println("Times compared searching a random key in Binary Tree: " + Counter.getCounter(1)/100);

        bst.rangeSearch(bst.getRoot(), 50000, 50100);
        System.out.println("Times compared searching a key with range search in Binary Tree (when K=100): " + Counter.getCounter(5));

        Counter.clearCounter(5);

        bst.rangeSearch(bst.getRoot(), 50000, 51000);
        System.out.println("Times compared searching a key with range search in Binary Tree (when K=1000): " + Counter.getCounter(5));
    }

    private static void threadedBinaryTreeOperations(){
        System.out.println("");
        System.out.println("---ThreadedBinaryTree Searches---");

        /*Fill the tree with random numbers*/
        for(int i = 0; i<10000; i++)
            tbst.insert(UniqueRandomGenerator.getInstance().getRandomInts()[i], 0);
        System.out.println("Times compared in insertion in Threaded Binary Tree: " + Counter.getCounter(2)/10000);

        /*Search for 100 random numbers*/
        for(int i = 0; i<100; i++)
            tbst.findKey(0, UniqueRandomGenerator.getInstance().getRandomKeys()[i]);
        System.out.println("Times compared searching a random key in Threaded Binary Tree: " + Counter.getCounter(3)/100);

        tbst.rangeSearch(0, 50000, 50100);
        System.out.println("Times compared searching a key with range search in Threaded Binary Tree (when K=100): " + Counter.getCounter(6));

        Counter.clearCounter(6);

        tbst.rangeSearch(0, 50000, 51000);
        System.out.println("Times compared searching a key with range search in Threaded Binary Tree (when K=1000): " + Counter.getCounter(6));
    }

    private static void sortedArrayOperations(){
        System.out.println("");
        System.out.println("---Binary Searches---");

        for(int i = 0; i<100; i++)
            BinarySearch.binarySearch(UniqueRandomGenerator.getInstance().getSortedInts(), 0,
                    UniqueRandomGenerator.getInstance().getSortedInts().length, i);
        System.out.println("Times compared searching the key: " + Counter.getCounter(4)/100);
    }
}
