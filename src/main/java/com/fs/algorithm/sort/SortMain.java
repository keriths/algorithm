package com.fs.algorithm.sort;

import com.fs.algorithm.sort.impl.BubblingSort;
import com.fs.algorithm.sort.impl.HeapSort;
import com.fs.algorithm.sort.impl.HeapSort2;
import com.fs.algorithm.sort.impl.Quicksort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fanshuai on 19/2/25.
 */
public class SortMain {
    public static void main(String[] args){
        ArrayList arrays = new ArrayList();
        for (int i = 0;i<1000000;i++){
            arrays.add(new Random().nextInt(100000));
        }
        long t = System.currentTimeMillis();
        System.out.println("原始 "+arrays);
        System.out.println(System.currentTimeMillis() - t);
        t = System.currentTimeMillis();
        System.out.println("Quicksort ");
        new Quicksort().sort((List)arrays.clone());
        System.out.println(System.currentTimeMillis() - t);
        t = System.currentTimeMillis();
        System.out.println("HeapSort2 ");
        new HeapSort2().sort((List)arrays.clone());
        System.out.println(System.currentTimeMillis() - t);
        t = System.currentTimeMillis();
        System.out.println("BubblingSort "+new BubblingSort().sort((List)arrays.clone()));
        System.out.println(System.currentTimeMillis() - t);
        t = System.currentTimeMillis();
        System.out.println("HeapSort "+new HeapSort().sort((List)arrays.clone()));
        System.out.println(System.currentTimeMillis() - t);
        t = System.currentTimeMillis();
//        long t1 = System.currentTimeMillis();
//        new HeapSort().sort((List)arrays.clone());
//        long t2 = System.currentTimeMillis();
//        new HeapSort().sort((List)arrays.clone());
//        long t3 = System.currentTimeMillis();
//        new HeapSort().sort((List)arrays.clone());
//        long t4 = System.currentTimeMillis();
//        System.out.println((t2-t1)+"  a  "+(t3-t2)+" a "+(t4-t3));

    }
}
