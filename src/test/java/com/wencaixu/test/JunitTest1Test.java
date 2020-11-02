package com.wencaixu.test;

import junit.framework.TestCase;


// 继承TestCase方法可以完成大多数的测试，
// 并且内部以test开头的方法都是可执行的
public class JunitTest1Test extends TestCase {

    public JunitTest1Test(String name) {
        super(name);
    }

    public void testIsEqual() {
        assertEquals("函数的两个只不相同",1,JunitTest1.isEqual(1,1));
        System.out.println("JunitTest1Test.testIsEqual");
    }

    // 比较两个小数的时候可以设置可容忍的范围
    // assertEquals(String message,expected,actual,tolerance)
    public void testFloat(){
        assertEquals("两个值相同",3.33,10.0/3.0,0.01);
        System.out.println("JunitTest1Test.testFloat");
    }

    // 判断是否为空
    public void testNull(){
        // 断言一个对象为空值
        assertNull("出现空值",null);
        // 判断非空
        assertNotNull("出现空值",new Object());
        System.out.println("JunitTest1Test.testNull");
    }

    // 判断两个对象的引用是否一样
    public void testSame(){

        //assertSame("两个值不一致",new Object(),new Object());
        //assertSame(String message,expected,actual)
        //assertNotSame(String message,expected,actual)
        Object object = new Object();
        assertSame("两个值不一致",object,object);

        assertNotSame("两个值一致",new Object(),new Object());
        System.out.println("JunitTest1Test.testSame");
    }

    // assertTrue(true)
    // assertTrue(String message,boolean condition) 如果为假则返回异常
    public void testTrue(){
        // 判断表达式是否为true
        assertTrue(true);
        assertFalse(false);
        System.out.println("JunitTest1Test.testTrue");
    }

    public void testFaild(){
        try{
            Largest.largest(new int[]{});
            fail();// 会使测试立即失效，其中message参数是可选的，这种断言通常被用于标记某个不应该被达到的分支
        }catch (Exception ex){
            assertTrue(true);
        }
        System.out.println("JunitTest1Test.testFaild");
    }

    // 单元测试的组成：
    //

}