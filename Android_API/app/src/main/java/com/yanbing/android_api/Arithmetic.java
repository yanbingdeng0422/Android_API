package com.yanbing.android_api;

/**
 * Created by dengyanbing on 2019/2/20.
 */

public class Arithmetic {

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

}
