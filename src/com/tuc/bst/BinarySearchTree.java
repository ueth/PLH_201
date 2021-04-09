package com.tuc.bst;

/**
 * Binary tree implemented with 2d array.
 * _tree[x][0] = key
 * _tree[x][1] = left node
 * _tree[x][2] = right node
 */
public class BinarySearchTree {

    private static final int NUMBER_OF_NODES = 10000;
    private final int ROOT = 0;

    private final int[][] _tree;
    private int _currentPos;
    private int _nextPosition;
    private int _parentPosition;


    public BinarySearchTree(){
        _currentPos = ROOT;
        _tree = new int[NUMBER_OF_NODES][3];
        initTree();
    }

    /**
     * Initiate stack pointers
     */
    private void initTree(){
        for(int i = 0; i<NUMBER_OF_NODES; i++){
            _tree[i][0] = -1;
            _tree[i][1] = -1;
            _tree[i][2] = i+1;
        }
        _tree[NUMBER_OF_NODES-1][2] = 0;
    }

    public int setRight(int position){
        return _tree[_currentPos][2] = position;
    }

    public int setLeft(int position){
        return _tree[_currentPos][1] = position;
    }

    public int setKey(int key){
        return _tree[_currentPos][0] = key;
    }

    public int getKey(int pos){
        return _tree[pos][0];
    }

    public boolean isEmpty(int pos){
        return _tree[pos][0] == -1 && _tree[pos][1] == -1;
    }

    public int getNextAvailablePosition(){
        return isEmpty(_currentPos) ? _tree[_currentPos][2] : -1;
    }

    /**
     * When adding a key we must hold the next available position
     * @param key
     * @return key
     */
    public int addKey(int key){
        _nextPosition = getNextAvailablePosition();
        _tree[_currentPos][0] = key;
        _tree[_currentPos][1] = -1;
        _tree[_currentPos][2] = -1;

        return key;
    }

    public int getLeftPointer(){
        if(_tree[_currentPos][1] == -1)
            _tree[_currentPos][1] = _nextPosition;
        return _currentPos = _tree[_currentPos][1];
    }

    public int getRightPointer() {
        if(_tree[_currentPos][2] == -1)
            _tree[_currentPos][2] = _nextPosition;
        return _currentPos = _tree[_currentPos][2];
    }

    public int insert(int key, int pos){
        System.out.println(_tree[pos][0] + " " + _tree[pos][1] + " " + _tree[pos][2]);
        if(isEmpty(pos)) return addKey(key);

        if(key < getKey(pos)) insert(key, getLeftPointer());
        else insert(key, getRightPointer());
        return key;
    }

//    public void printhelp(int pos, int level) {
//        if (_tree[pos] == null)
//            return;
//        printhelp(rt.right(), level + 1);
//        for (int i = 0; i < level; i++) // Indent based on level
//            System.out.print("  ");
//        System.out.println((Elem) rt.element()); // Print node value
//        printhelp(rt.left(), level + 1);
//    }

    public void resetCurrentPos(){
        _currentPos = ROOT;
    }

    public int[][] getTree() {
        return _tree;
    }

    public int getRoot(){
        return ROOT;
    }
}
