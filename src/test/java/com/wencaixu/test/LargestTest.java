package com.wencaixu.test;


import junit.framework.TestCase;

/**
 * 首先需要确认需要需要测试什么，从那些方面测试
 *
 * 计划测试：
 *  1. 普通测试
 *  2. 顺序
 *  3. 重复
 *  4. 负数
 *  5. 0个参数
 */
public class LargestTest extends TestCase {

    public LargestTest(String name) {
        super(name);
    }

    /**
     * 此处必须以test开头
     */
    public void testLargest(){
        assertEquals(9,Largest.largest(new int[]{1,2,3,4,5,9}));
    }

    public void testOrder(){
        assertEquals(9,Largest.largest(new int[]{1,9,4,5}));
        assertEquals(9,Largest.largest(new int[]{9,1,4,5}));
        assertEquals(9,Largest.largest(new int[]{1,4,5,9}));
    }

    public void testDup(){
        assertEquals(9,Largest.largest(new int[]{1,2,3,9,9}));
    }

    public void testOne(){
        assertEquals(9,Largest.largest(new int[]{9}));
    }

    public void testZero(){
        try{
            Largest.largest(new int[]{});
            fail();
        } catch (Exception ex){
            assertTrue(true);
        }
    }

    public void testNegative(){
        assertEquals(-1,Largest.largest(new int[]{-1,-2}));
    }



}
