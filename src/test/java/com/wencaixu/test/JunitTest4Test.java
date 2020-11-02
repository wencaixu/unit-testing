package com.wencaixu.test;

import junit.framework.TestCase;

import java.io.*;

public class JunitTest4Test extends TestCase {

    private BufferedInputStream inputStream;

    // 该函数类似与@Before函数，用于资源的创建
    public void setUp(){
        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File("D:\\ideaProject\\unit-testing\\src\\test\\java\\com\\wencaixu\\test\\LargestTest.java")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void testReader() throws IOException {
        int sum = 0;
        if(inputStream != null){
            int read;
            while((read = inputStream.read()) != -1){
                sum += read;
            }
        }
        assertEquals("实际值和预期值不一致",104615,sum);
    }

    // 该函数类似于@After注解，用于资源的销毁
    public void tearDown(){
        if(inputStream != null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
