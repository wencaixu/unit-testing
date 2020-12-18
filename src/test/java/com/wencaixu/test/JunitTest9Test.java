package com.wencaixu.test;

import junit.framework.*;

import java.util.concurrent.Semaphore;


public class JunitTest9Test extends TestCase {

    public JunitTest9Test(String name) {
        super(name);
    }

    private TestStack testStack;

    public void setUp() throws Exception {
        testStack = new TestStack();
        testStack.push("aaa");
        testStack.push("bbb");
    }

    public void testPush() throws Exception {
        testStack.push("ccc");
        testStack.push("ddd");
        testStack.push("eee");
        try{
            testStack.push("fff");
            fail();
        } catch (Exception ex){
            assertTrue(true);
        }
    }

    public void testPop() throws Exception {
        assertEquals("bbb",testStack.pop());
        assertEquals("aaa",testStack.pop());
        try{
            testStack.pop();
            fail();
        } catch (Exception ex){
            assertTrue("栈不为空",true);
        }

    }

    public void testIsEmpty() {
        assertFalse("栈不为空",testStack.isEmpty());
    }

    public void tearDown(){
        testStack = null;
    }

    public static Test suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(JunitTest9Test.class);
        return suite;
    }


    public void testString(){
        Semaphore semaphore;
    }


}