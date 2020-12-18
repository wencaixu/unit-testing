package com.wencaixu.test;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @Description: TODO
 * @Author wencai.xu
 * @Date 2020/11/16,0016
 * @Version V1.0
 **/
public class Main {

    enum Macro{
        timestamp,
        exchange
    }

    private static String nvl(Supplier<String> supplier,String replacement){
        String ret = supplier.get();
        if(ret == null || ret.length() == 0){
            return replacement;
        }
        return ret;
    }

    private static String nvl(Supplier<String> supplier){
        return nvl(supplier,"Na");
    }

    private static String[] macroValues(Map<String,String> map){
        String[] macroValues = new String[10];
        macroValues[Macro.timestamp.ordinal()] = nvl(()-> map.get("timestamp"));
        macroValues[Macro.exchange.ordinal()] = nvl(()->map.get(""));
        return new String[]{"0"};
    }


    public static String[] replace(String[] candidates,String[] replacements){
        return Optional.ofNullable(candidates).map(cs->{
            for(int i = 0; i < candidates.length; i++){
                String c = cs[i];
                if(c != null){
                    System.out.println(i+""+candidates[i]);
                    cs[i] = "test";
                }
            }
            return new String[]{null};
        }).orElse(candidates);
    }

    public static void main(String[] args) {
        String[] replace = replace(new String[]{"aaa", "bbb", "ccc"}, new String[]{"ddd", "eee", "a"});
        for(int i = 0; i < replace.length; i++){
            System.out.println(replace[i]);
        }
    }
}
