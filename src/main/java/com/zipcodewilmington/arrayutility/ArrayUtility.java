package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <E> {

    private E[] containerArray;

    public ArrayUtility(E[] array){
        this.containerArray = array;
    }

    public E[] removeValue(E value){
        E[] newArray = (E[]) Array.newInstance(value.getClass(), containerArray.length);
        int count = 0;
        for(int i = 0; i < containerArray.length; i++){
            if(containerArray[i] != value){
                newArray[count++] = containerArray[i];
            }

        }
        E[] output = (E[]) Array.newInstance(value.getClass(), count);
        for (int i = 0; i < count; i++){
            output[i] = newArray[i];
        }
        return output;
    }

    public Integer countDuplicatesInMerge(E[] array, E value){
        int count = 0;
        for(E e : array){
            if(e == value){
                count++;
            }
        }
        for(E e : containerArray){
            if(e == value){
                count++;
            }
        }
        return count;
    }

    public E getMostCommonFromMerge(E[] array){
        HashMap<E, Integer> map = new HashMap<>();

        for(int i = 0; i < containerArray.length; i++){
            if(map.containsKey(containerArray[i])){
                map.put(containerArray[i], map.get(containerArray[i]) + 1);
            }
            else{
                map.put(array[i], 1);
            }
        }
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) +1);
            }
            else{
                map.put(array[i], 1);
            }
        }

        int value = 0;
        E key = null;

        for(Map.Entry<E, Integer> element : map.entrySet()){
            if (element.getValue() > value) {
                value = element.getValue();
                key = element.getKey();
            }
        }
        return key;
    }

    public Integer getNumberOfOccurrences(E value){
        int count = 0;

        for(int i = 0; i < containerArray.length; i++){
            if(containerArray[i] == value){
                count++;
            }
        }
        return count;
    }



}
