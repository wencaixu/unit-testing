package com.wencaixu.test;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



// 为Test suite设置setup 和 tearUp,为多个test方法设置suite并初始化setup和teardown
public class JunitTest5Test extends TestCase {

    private static Node node;

    public JunitTest5Test(String name) {
        super(name);
    }

    public void testUsername(){
        assertEquals("姓名不一致","wencai.xu",node.getName());
    }

    public void testAge(){
        assertEquals("年龄不一致","21",node.getAge());
    }

    public void testOut(){
       assertEquals("wencai.xu","wencai.xu");
       System.out.println("JunitTest5Test.testOut");
    }

    public static Test suite(){
        TestSuite testSuite = new TestSuite();
        testSuite.addTest(new JunitTest5Test("testUsername"));
        testSuite.addTest(new JunitTest5Test("testAge"));
        // 核心
        TestSetup swapper = new TestSetup(testSuite){
            protected void setUp(){
                oneTimeSetUp();
            }
            protected  void tearDown(){
                oneTimeTearDown();
            }
        };
        // 证明已经清空
        System.out.println(node);
        return swapper;
    }

    private static void oneTimeSetUp() {
        node = new Node("wencai.xu","21");
    }

    private static void oneTimeTearDown() {
        node = null;
    }

}
