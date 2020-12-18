package com.wencaixu.test;

public class TestStack {

    private String[] bucket;

    private int top;

    private int base;

    private int size=0;

    /**
     * 默认构造方法
     */
    public TestStack() {
        bucket = new String[5];
        top = base = 0;
    }

    public void push(String element) throws Exception {
        if(top - base > 5){
            throw new Exception("抛出异常");
        }
        this.bucket[top++] = element;
        this.size ++;
    }

    public String pop() throws Exception {
        if(top-base == 0){
            throw  new Exception("栈为空");
        }
        this.size --;
        return this.bucket[--top];
    }

    public String top() throws Exception {
        if(top - base == 0 || top == 0){
            throw new Exception("栈为空");
        }
        return this.bucket[top--];
    }

    public boolean isEmpty(){
        return top - base == 0 && this.size == 0;
    }
}
