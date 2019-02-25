package com.fs.algorithm.sort;

import java.util.List;

/**
 * 冒泡排序
 */
public class BubblingSort implements Sort<Integer>{
    @Override
    public List<Integer> sort(List<Integer> arrays) {
        if (arrays==null || arrays.size()<=1){
            return arrays;
        }
        for (int i = 1;i<arrays.size();i++){
            for (int j = 0;j<arrays.size()-i;j++){
                if (arrays.get(j)>arrays.get(j+1)){
                    int oldj = arrays.get(j);
                    arrays.set(j,arrays.get(j+1));
                    arrays.set(j+1,oldj);
                }
            }
        }
        return arrays;
    }
}
