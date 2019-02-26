package com.fs.algorithm.sort;

import com.fs.algorithm.sort.impl.BubblingSort;
import com.fs.algorithm.sort.impl.HeapSort;
import com.fs.algorithm.sort.impl.Quicksort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanshuai on 19/2/25.
 */
public class SortMain {
    public static void main(String[] args){
        ArrayList arrays = new ArrayList();
        arrays.add(5);
        arrays.add(1);
        arrays.add(6);
        arrays.add(8);
        arrays.add(2);
        arrays.add(9);
        arrays.add(0);
        arrays.add(2);
        arrays.add(5);
        arrays.add(1);
        System.out.println(arrays);
        System.out.println(new BubblingSort().sort((List)arrays.clone()));
        System.out.println(new Quicksort().sort((List)arrays.clone()));
        System.out.println(new HeapSort().sort((List)arrays.clone()));

    }
}
