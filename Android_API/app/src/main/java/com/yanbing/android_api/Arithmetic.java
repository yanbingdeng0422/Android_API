package com.yanbing.android_api;

import android.util.Log;

/**
 * Created by dengyanbing on 2019/2/20.
 */

public class Arithmetic {
    private static final String TAG = "Arithmetic";

    //二分查找法
    //key       查找的目标值
    //a[]       数组
    //return    数组下标值
    public static int rank(int key,int[] a){
        if(a==null){
            return -1;
        }
        int lo = 0;
        int hi = a.length-1;

        while (lo<=hi){
            int mid = lo +(hi-lo)/2;
            if(key<a[mid]){
                hi = mid-1;
            }else if(key>a[mid]){
                lo = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    //讲一个整数N用二进制表示并转换为一个String类型的值s
    //方法一
    public static String IntToBinaryString_1(int N){
        String s = Integer.toBinaryString(N);
        return s;
    }
    //方法二
    public static String IntToBinaryString_2(int N){
        String s = "";
        for (int n = N;n>0;n/=2)
            s=(n%2)+s;
        return s;
    }

    //获取Heap(堆)内存大小,单位M
    public static  long MaxMermory(){
        return Runtime.getRuntime().maxMemory()/1024/1024;
    }


    /*
     *题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
     *也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
     *那么对应的输出是重复的数字2或者3。
     * */

    /*
    * 解法一
    * 1、将数组排序
    * 2、在排序的数组中找
    * */
    public int getRePeat(int[] arrays){
        if(arrays ==null || arrays.length<=0){
            Log.d(TAG+"getRePeat","array 无效");
            return -1;
        }

        for(int array:arrays){
            if(array<0 || array>arrays.length-1){
                Log.d(TAG+"getRePeat","array out of range超出范围");
                return -1;
            }
        }

        for(int i=0;i<arrays.length;i++){
            int temp;
            while (arrays[i] !=i){
                if(arrays[arrays[i]] ==arrays[i]){
                    return arrays[i];
                }
                temp = arrays[i];
                arrays[i] =arrays[temp];
                arrays[temp] = temp;
            }
        }
        Log.d(TAG+"getRePeat","array no identical number 没有重复的数字");
        return -1;
    }

}
