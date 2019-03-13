package com.yanbing.android_api.until;

import android.support.annotation.NonNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dengyanbing on 2019/3/12.
 * 背包  不支持删除元素的集合数据类型
 */

public class Bag<I> implements Iterable<I> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private I[] theItems;

    public Bag(){
        clear();
    }

    private void clear() {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    private void ensureCapacity(int defaultCapacity) {
        if(defaultCapacity<size){
            return;
        }else {
            I[] oldIs = theItems;
            theItems = (I[])new Object[defaultCapacity];

            for(int i=0;i<size;i++){
                theItems[i]= oldIs[i];
            }
        }
    }

    public void add(I item) {
        if (theItems.length == size()) {
            ensureCapacity(2 * size() + 1);
        }
        theItems[size()] = item;
        size++;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }


    @NonNull
    @Override
    public Iterator iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<I> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public I next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

    }


    public static void Bag_main(String[] args) {
        Bag<Integer> bag = new Bag<Integer>();
        bag.add(1);
        bag.add(3);
        bag.add(6);
        bag.add(4);
        Iterator<Integer> it = bag.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
