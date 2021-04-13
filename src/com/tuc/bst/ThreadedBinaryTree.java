package com.tuc.bst;

import com.tuc.interfaces.IBinaryTree;
import com.tuc.tools.Counter;

public class ThreadedBinaryTree implements IBinaryTree {

    private static final int NUMBER_OF_NODES = 10000;
    private final int ROOT = 0;

    private final int[][] _tree;
    private int _currentPos;
    private int _nextPosition;

    public ThreadedBinaryTree(){
        _currentPos = ROOT;
        _tree = new int[NUMBER_OF_NODES][5];
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
            _tree[i][3] = -1;
            _tree[i][4] = -1;
        }
        _tree[NUMBER_OF_NODES-1][2] = 0;
    }

    private void setLeftThread(int num, int pos){_tree[pos][3] = num;}

    private void setRightThread(int num, int pos){_tree[pos][4] = num;}

    public int getRightThread(int pos){ return _tree[pos][4];}

    public int getLeftThread(int pos){ return _tree[pos][3];}

    private void setLeft(int num, int pos){_tree[pos][1] = num;}

    private void setRight(int num, int pos){_tree[pos][2] = num;}

    public int getRight(int pos){ return _tree[pos][2]; }

    public int getLeft(int pos){
        return _tree[pos][1];
    }

    public int getKey(int pos){
        return _tree[pos][0];
    }

    public int getNextAvailablePosition(int pos){ return _tree[pos][2]; }

    /**
     * When adding a key we must hold the next available position
     * @param key
     * @return key
     */
    public int addKey(int key, int pos){
        _nextPosition = getNextAvailablePosition(pos);
        _tree[pos][0] = key;
        _tree[pos][1] = -1;
        _tree[pos][2] = -1;
        return _nextPosition;
    }

    public int getRightPointer() {
        return 0;
    }

    public int getLeftPointer() {
        return 0;
    }

    public int insert(int key, int pos) {

        int parentPos=-1;

        while(getKey(pos) != -1 && Counter.incCounter(2)){

            if(getKey(pos) == key && Counter.incCounter(2)){
                System.out.printf("Duplicate Key !\n");
                return key;
            }

            parentPos = pos;

            if(key < getKey(pos) && Counter.incCounter(2)){
                if(getLeftThread(pos) == -1 && Counter.incCounter(2))
                    pos = getLeft(pos);
                else
                    break;
            }
            else{
                if(getRightThread(pos) == -1 && Counter.incCounter(2))
                    pos = getRight(pos);
                else
                    break;
            }
        }

        if(parentPos == -1){
            addKey(key, pos);
            setLeftThread(1, pos);
            setRightThread(1, pos);
            return pos;
        }

        pos = _nextPosition;
        addKey(key, pos);
        setLeftThread(1, pos);
        setRightThread(1, pos);

        if(key < getKey(parentPos ) && Counter.incCounter(2)){
            setLeft(getLeft(parentPos), pos);
            setRight(parentPos, pos);
            setLeftThread(-1, parentPos);
            setLeft(pos, parentPos);
        }
        else{
            setLeft(parentPos, pos);
            setRight(getRight(parentPos), pos);
            setRightThread(-1, parentPos);
            setRight(pos, parentPos);
        }

        return pos;
    }

    public int findKey(int pos, int key) {
        return 0;
    }
}
