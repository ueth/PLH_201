package com.tuc.tools;

import java.util.Arrays;

public class UniqueRandomGenerator {
    private static UniqueRandomGenerator _instance ;

    private static int START_INT = 1;
    private static int END_INT = 1000001;
    private static int NO_OF_ELEMENTS = 10000;

    private static int[] _randomInts;
    private static int[] _sortedInts;
    private static int _randomKeys[] = new int[100];

    private UniqueRandomGenerator(){

    }

    static {
        generateRandomNumbers();
        generateRandomKeys();
        _sortedInts = _randomInts;
        Arrays.sort(_sortedInts);
    }

    /**
     * This method generates 10.000 random key numbers
     */
    public static void generateRandomNumbers() {
        java.util.Random randomGenerator = new java.util.Random();
        _randomInts = randomGenerator.ints(START_INT, END_INT).distinct().limit(NO_OF_ELEMENTS).toArray();
    }

    public static void generateRandomKeys() {
        java.util.Random randomGenerator = new java.util.Random();
        int r[] = randomGenerator.ints(START_INT, NO_OF_ELEMENTS).distinct().limit(100).toArray();
        for(int i = 0; i < 100; i++)
            _randomKeys[i] = _randomInts[r[i]];
    }

    public int[] getRandomKeys() {
        return _randomKeys;
    }

    public int[] getRandomInts() {
        return _randomInts;
    }

    public int[] getSortedInts() {
        return _sortedInts;
    }

    public static UniqueRandomGenerator getInstance() {
        return _instance == null ? _instance = new UniqueRandomGenerator() : _instance;
    }
}