package com.wencaixu.test;

import junit.framework.*;


// 使用Test suit进行同时测试多个类
public class JunitTest3Test extends TestCase {

    public JunitTest3Test(String name) {
        super(name);
    }

    // 注意此处名称suite必须为suite
    static public Test suite() {
        // 此处使用suite仅仅处理了JunitTest1Test中的全部以及JunitTest2Test中的testSum和testShortest，此处完全可以使用@Ignore来忽略执行某一个测试函数
        TestSuite testSuite = new TestSuite();
        testSuite.addTestSuite(JunitTest1Test.class);
        testSuite.addTest(JunitTest2Test.suite());
        assertEquals("结果与期望值一致",2,new JunitTest2().sum(1,1));
        return testSuite;
    }
}