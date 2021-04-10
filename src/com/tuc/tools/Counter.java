package com.tuc.tools;

/**
 * _counter[0] -> counts comparisons in BinarySearchTree insert
 * _counter[1] -> counts comparisons in BinarySearchTree findKey
 * _counter[2] -> counts comparisons in ThreadedBinarySearchTree insert
 * _counter[3] -> counts comparisons in ThreadedBinarySearchTree findKey
 * _counter[4] -> counts comparisons in sorted array with binary search
 */
public class Counter {
    private static int[] _counter = new int[5];

    public static boolean incCounter(int pos){
        _counter[pos]++;
        return true;
    }

    public static int getCounter(int pos){
        return _counter[pos];
    }
}
