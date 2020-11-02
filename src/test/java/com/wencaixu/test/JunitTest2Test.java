package com.wencaixu.test;

import junit.framework.TestCase;
import junit.framework.TestSuite;


// 使用Test suit进行同时测试多个类
public class JunitTest2Test extends TestCase {

    public JunitTest2Test(String name) {
        super(name);
    }

    public void testSum() {
        assertEquals("结果与期望值一致",2,new JunitTest2().sum(1,1));
        System.out.println("JunitTest2Test.testSum");
    }

    public void testLongest(){
        assertEquals(1,1);
        System.out.println("JunitTest2Test.testLongest");
    }

    public void testShortest(){
        assertEquals(1,1);
        System.out.println("JunitTest2Test.testShortest");
    }

    public static junit.framework.Test suite(){
        TestSuite suite = new TestSuite();
        suite.addTest(new JunitTest2Test("testSum"));
        suite.addTest(new JunitTest2Test("testShortest"));
        return suite;
    }
}