package com.fs.algorithm.sort.impl;

import com.fs.algorithm.sort.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 快排 - 找基准值，把小的放基准值右边，大的放基准值左边，然后再对左右进行同样的方法排序，值到只有一个元素结束
 * Created by fanshuai on 19/2/25.
 */
public class Quicksort implements Sort<Integer> {
    @Override
    public List<Integer> sort(List<Integer> arrays) {
        if (arrays==null || arrays.size()<=1){
            return arrays;
        }
        int standIndex = new Random().nextInt(arrays.size());
        int stand = arrays.get(standIndex);

        int l = arrays.size();
        for (int i = 0;i<standIndex;){
            if (arrays.get(i)<stand){
                i++;
            }else if (arrays.get(i)>stand){
                int last = arrays.get(l-1);
                arrays.set(l-1,arrays.get(i));
                arrays.set(i,last);
                if (l-1 == standIndex){
                    standIndex = i;
                    break;
                }
                l--;
            }else {
                i++;
            }
        }
        for (int i = standIndex+1;i<l;){
            if (arrays.get(i)<stand){
                arrays.set(standIndex,arrays.get(i));
                arrays.set(i,stand);
                standIndex++;
            }else if (arrays.get(i)>stand){
                int standNext = arrays.get(i);
                arrays.set(i,arrays.get(l-1));
                arrays.set(l-1,standNext);
                l--;
            } else
            if (arrays.get(i)==stand){
                standIndex++;
            }
            i = standIndex+1;
        }
        List<Integer> ll = arrays.subList(0,standIndex);
        List<Integer> rr = arrays.subList(standIndex+1,arrays.size());

        List<Integer> leftList = sort(ll);
        List<Integer> rightList = sort(rr);
        ArrayList a = new ArrayList();
        a.addAll(leftList);
        a.add(stand);
        a.addAll(rightList);
        return a;
    }
}
