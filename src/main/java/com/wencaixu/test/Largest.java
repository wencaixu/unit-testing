package com.wencaixu.test;

/**
 * Hello world!
 *
 */
public class Largest
{
   public static int largest(int[] list){
       if(list.length == 0){
           throw new RuntimeException("数组长度为空");
       }
       int max = Integer.MIN_VALUE;
       for(int i = 0; i < list.length; i++){
           if(list[i] > max){
               max = list[i];
           }
       }
       return max;
   }
}
