package com.tuc.tools;

public class BinarySearch {
    /**
     *
     * @param array
     * @param left
     * @param right
     * @param key
     * @return the position of the key in the array
     */
    public static int binarySearch(int array[], int left, int right, int key)
    {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (array[mid] == key)
                return mid;

            if (array[mid] > key)
                return binarySearch(array, left, mid - 1, key);

            return binarySearch(array, mid + 1, right, key);
        }

        //if key hasn't been found
        return -1;
    }
}
