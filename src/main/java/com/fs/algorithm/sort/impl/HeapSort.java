package com.fs.algorithm.sort.impl;

import com.fs.algorithm.sort.Sort;

import java.util.List;

/**
 * 堆排序 小根堆升序  大根堆降序
 */
public class HeapSort implements Sort<Integer>{

    @Override
    public List<Integer> sort(List<Integer> arrays) {
        if (arrays==null || arrays.size()<=1){
            return arrays;
        }
        //最后一个父节点
        for (int i = 0;i<arrays.size();i++){
            adjustHeap(arrays.subList(i,arrays.size()));
        }
        return arrays;
    }

    public List<Integer> adjustHeap(List<Integer> arrays){
        int parentNum = arrays.size()/2;
        for (int curPos = parentNum-1;curPos>=0;curPos--) {
            int leftPos = curPos * 2 + 1;
            int rightPos = curPos * 2 + 2;
            int curVal = arrays.get(curPos);
            int leftVal = arrays.get(leftPos);
            if (rightPos >= arrays.size()) {
                //没有右子节点
                if (leftVal < curVal) {
                    arrays.set(curPos, leftVal);
                    arrays.set(leftPos, curVal);
                }
            } else {
                int rightVal = arrays.get(rightPos);
                if (curVal > leftVal || curVal > rightVal) {
                    if (leftVal < rightVal) {
                        arrays.set(curPos, leftVal);
                        arrays.set(leftPos, curVal);
                    } else if (rightVal < leftVal) {
                        arrays.set(curPos, rightVal);
                        arrays.set(rightPos, curVal);
                    } else {
                        arrays.set(curPos, leftVal);
                        arrays.set(leftPos, curVal);
                    }
                }
            }
        }
        return arrays;
    }
}
