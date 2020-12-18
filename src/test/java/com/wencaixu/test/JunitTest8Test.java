package com.wencaixu.test;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JunitTest8Test extends TestCase {

    public JunitTest8Test(String name) {
        super(name);
    }

    // Right - 结果是否正确
    // B - 是否所有边界条件都是正确的
    // I - 能查一下反向关联吗
    // C - 能用其他手段交叉检查结果吗
    // E - 你是否可以强制错误条件发生
    // P - 是否满足性能要求


    // 1. 验证结果的正确性，即结果是否跟期望值一致
        // 1. 一般根据用户的反馈进行设置测试用例
        // 2. 足够多的测试用例

    private int[] values;

    private String file = "D:\\ideaProject\\unit-testing\\src\\test\\java\\com\\wencaixu\\test\\log\\testdata.txt";

    public void setUp(){
        List<Integer> integerList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String temp;
            while((temp =reader.readLine())!=null) {
                String[] number = temp.split(",");
                for(int i = 0; i < number.length - 1; i++){
                    integerList.add(Integer.valueOf(number[i]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        values = new int[integerList.size()];
        int i = 0;
        for(Integer integer : integerList){
            values[i++] = integer;
        }
    }

    // 一个原则，如果对于验证被测方法是正确的这件事情，如果某些做法能够是她变得更加容易，南无就采纳它吧
    public void testRighet(){
        Assert.assertEquals(2147480276,Largest.largest(values));
    }


    // 测试边界条件，bug一般出现再边界上
    // 1、完全伪造的不一致的输入数据
    // 2、格式错误的数据
    // 3、空值或这不完整的值
    // 4、一些与意料中的合理值相去甚远的数值，如人的岁数
    // 5、不能重复的list,传入含重复值的list
    // 6、事情到达次序是错误的，或碰巧和期望的次序不一致
       // 规则：
         // 1、Conformance 一致性 - 值是否和预期值一致
         // 2、Ordering 顺序性 - 值是否如应该的纳昂，是有序或无序
         // 3、Range 区间性 - 值是否位于合理的最小值和最大值之间
         // 4、Reference 依赖性 - 代码是否引用了一些不在代码本身空值范围之内的外部资源
         // 5、Existence 存在性 - 值是否存在，例如是否非null，非0，再一个集合中等等
         // 6、Cardinatity 基数性-是否有足够的值，也被称为集合的势，指集合中的元素的个数
         // 7、Time 相对或绝对的时间性 - 所有的事情发生是否是有序的，是否子啊正确的时刻，是否恰好及时

    // 关于一致性的要求： 如果是数据结构验证，必须要考虑到所有不合法的情况

    // 测试一致性
    public void testB(){
        // wencai.xu@163.com或wencai.xu@gmail.com
        // 不合法的情况： 1、不包括@
        //             2、@前面必须是wencai.xu这种格式
        //             3、@后是163.com后缀
        //             4、@后com前不是逗号
        Pattern pattern = Pattern.compile("^[a-z]+\\.[a-z]{1,3}@(163|gmail)+\\.com$");
        assertTrue("与要求的格式不匹配",pattern.matcher("wencai.xu@163.com").find());
        assertFalse("不包括@",pattern.matcher("wencai.xu163.com").find());
        assertFalse("@前不包括.",pattern.matcher("wencaixu@163.com").find());
        assertFalse("@后不是163|gmail.com", pattern.matcher("wencai.xu@gmailaa.com").find());
        assertFalse("@后com前不是逗号",pattern.matcher("wencai.xu@gmailaa,sscom").find());
    }

    // 测试顺序性
    public void testOrder(){
        Integer[] bubble = new Integer[]{3,2,1,5,6};
        new BubbleSort<Integer>().bubbleSort(bubble);
        int[] result = new int[]{1,2,3,5,6};
        for(int i = 0; i < bubble.length; i++){
            assertEquals("不相同", Integer.valueOf(result[i]),bubble[i]);
        }
    }

    // 检查反向检查

    // 关于索引测试
    //    1. 开始索引和结束索引有相同值
    //    2. 第一个索引大于最后一个索引
    //    3. 索引为负值
    //    4. Count不能匹配确切的索引个数
    public void testI(){

    }


}
