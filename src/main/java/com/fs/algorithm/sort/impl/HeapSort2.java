package com.fs.algorithm.sort.impl;

import com.fs.algorithm.sort.Sort;

import java.util.List;

/**
 * 堆排序 小根堆升序  大根堆降序
 */
public class HeapSort2 implements Sort<Integer>{

    @Override
    public List<Integer> sort(List<Integer> arrays) {
        if (arrays==null || arrays.size()<=1){
            return arrays;
        }
        //初始大顶堆
        initBigHeap(arrays);
        //最后一个父节点
        for (int i = 0;i<arrays.size()-1;i++){
            initBigHeap(arrays.subList(0,arrays.size()-i-1));
        }
        return arrays;
    }
    public void initBigHeap(List<Integer> arrays){
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
                if (curVal < leftVal || curVal < rightVal) {
                    if (leftVal > rightVal) {
                        arrays.set(curPos, leftVal);
                        arrays.set(leftPos, curVal);
                        bigChildUpdate(arrays,leftPos);
                    } else if (rightVal > leftVal) {
                        arrays.set(curPos, rightVal);
                        arrays.set(rightPos, curVal);
                        bigChildUpdate(arrays,rightPos);
                    }
                }
            }
        }
    }

    public void bigChildUpdate(List<Integer> arrays,int index){
        int curValue = arrays.get(index);
        int leftPos = index * 2 + 1;
        int rightPos = index * 2 + 2;
        if (leftPos >= arrays.size()){
            //没有子节点
            return;
        }
        int leftValue = arrays.get(leftPos);
        if (rightPos >= arrays.size()){
            //只有左节点
            if (leftValue>curValue){
                arrays.set(leftPos,curValue);
                arrays.set(index,leftValue);
            }
        }else {
            int rightValue = arrays.get(rightPos);
            if (rightValue>curValue || leftValue>curValue){
                if (leftValue > rightValue) {
                    arrays.set(index, leftValue);
                    arrays.set(leftPos, curValue);
                    bigChildUpdate(arrays,leftPos);
                } else if (rightValue > leftPos) {
                    arrays.set(index, rightValue);
                    arrays.set(rightPos, curValue);
                    bigChildUpdate(arrays,rightPos);
                }
            }else {
                return;
            }
        }


    }


//
//    public List<Integer> adjustHeap(List<Integer> arrays){
//        int parentNum = arrays.size()/2;
//        for (int curPos = parentNum-1;curPos>=0;curPos--) {
//            int leftPos = curPos * 2 + 1;
//            int rightPos = curPos * 2 + 2;
//            int curVal = arrays.get(curPos);
//            int leftVal = arrays.get(leftPos);
//            if (rightPos >= arrays.size()) {
//                //没有右子节点
//                if (leftVal < curVal) {
//                    arrays.set(curPos, leftVal);
//                    arrays.set(leftPos, curVal);
//                }
//            } else {
//                int rightVal = arrays.get(rightPos);
//                if (curVal > leftVal || curVal > rightVal) {
//                    if (leftVal < rightVal) {
//                        arrays.set(curPos, leftVal);
//                        arrays.set(leftPos, curVal);
//                    } else if (rightVal < leftVal) {
//                        arrays.set(curPos, rightVal);
//                        arrays.set(rightPos, curVal);
//                    } else {
//                        arrays.set(curPos, leftVal);
//                        arrays.set(leftPos, curVal);
//                    }
//                }
//            }
//        }
//        return arrays;
//    }
}
