package com.wencaixu.test;

/**
 * 构建代码：构建单元测试的时候，只需要并验证方法的行为是否跟结果一致
 * 测试代码用户和客户永远是看不到的
 * 条件：
 *   1、准备测试所需要的各种条件，比如必须的对象，分配的资源
 *   2、调用要测试的方法
 *   3、设计测试用例
 *   4、验证被测试的方法的行为和期望是否一致
 *   5、完成后清理各种资源
 */
public class JunitTest1  {

    // 断言，断言是单元测试最基本的组成部分,当发生错误的时候会打印message的信息
    // assertEquals(String message,T expected,T actual)

    public static int isEqual(int a,int b){
        return 1;
    }



}
