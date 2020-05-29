package com.baomidou.mybatisplus.samples.quickstart.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组转集合
 */

public class ArrayToList {

    /**
     * 数组转集合
     *
     * @param array
     * @return
     */
    public static List<Integer> toList(Integer[] array){
        //初始化一个集合
        List<Integer> list = new ArrayList<>();
        //通过foreach的方式对数组进行遍历
        for (Integer ids : array) {
            //将数组的内容放入我们的list集合里面去
            list.add(ids);
        }
        return list;
    }

}