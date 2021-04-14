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

        while(Counter.incCounter(2) && getKey(pos) != -1){

            if(Counter.incCounter(2) && getKey(pos) == key){
                System.out.printf("Duplicate Key !\n");
                return key;
            }

            parentPos = pos;

            if(Counter.incCounter(2) && key < getKey(pos)){
                if(Counter.incCounter(2) && getLeftThread(pos) == -1)
                    pos = getLeft(pos);
                else
                    break;
            }
            else{
                if(Counter.incCounter(2) && getRightThread(pos) == -1)
                    pos = getRight(pos);
                else
                    break;
            }
        }

        if(Counter.incCounter(2) && parentPos == -1){
            addKey(key, pos);
            setLeftThread(1, pos);
            setRightThread(1, pos);
            return pos;
        }

        pos = _nextPosition;
        addKey(key, pos);
        setLeftThread(1, pos);
        setRightThread(1, pos);

        if(Counter.incCounter(2) && key < getKey(parentPos)){
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
        if (Counter.incCounter(3) && pos == -1)
            return -1;
        else if (Counter.incCounter(3) && getKey(pos) == key)
            return key;

        while(Counter.incCounter(3) && pos != -1){
            if(Counter.incCounter(3) && key < getKey(pos))
                pos = getLeft(pos);
            else
                pos = getRight(pos);
            if(Counter.incCounter(3) && key == getKey(pos))
                break;
        }

        if(Counter.incCounter(3) && pos != -1)
            return key;

        return -1;
    }

    /*public void rangeSearch(int pos, int k1, int k2){
        if(Counter.incCounter(6) && pos == -1)
            return;

        while(Counter.incCounter(6) && pos != -1){
            if(Counter.incCounter(6) && k1 <= getKey(pos)){
                pos = getLeft(pos);
            }

            else if(Counter.incCounter(6) && k1 <= getKey(pos) && k2 >= getLeft(pos)){
                System.out.println("Key found: " + getKey(pos));
            }


            else if(Counter.incCounter(6) && k2 >= getLeft(pos)){
                pos = getRight(pos);
            }

            if(k2 < getLeft(pos) || k1 > getRight(pos))
                break;
        }
    }*/
}
