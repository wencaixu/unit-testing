package com.wencaixu.test;

import junit.framework.TestCase;

// 自定义断言
// 可以将所有信息设置到一个基类中，然后继承集类即可
public class JunitTest6Test extends TestCase {

    public void assertEvenDollars(String message,Money money){
        assertTrue(message,(int) money.getMoney() % 2 == 0);
    }

    public void testEvenDollars(){
        assertEvenDollars("不是偶数",new Money(200));
    }

    static class Money{
        float money;

        public Money(float money) {
            this.money = money;
        }

        public float getMoney() {
            return money;
        }

        public void setMoney(float money) {
            this.money = money;
        }
    }
}


