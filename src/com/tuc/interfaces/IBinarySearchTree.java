package com.tuc.interfaces;

public interface IBinarySearchTree {

    int getRight(int pos);
    int getLeft(int pos);
    int getKey(int pos);
    int addKey(int key);
    int getRightPointer();
    int getLeftPointer();
    int insert(int key, int pos);
    int findKey(int pos, int key);

}
