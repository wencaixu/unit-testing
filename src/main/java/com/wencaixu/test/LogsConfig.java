package com.wencaixu.test;


/**
 * @Description: 平台日志配置处理
 * @Author wencai.xu
 * @Date 2020/11/16,0016
 * @Version V1.0
 **/

public class LogsConfig {

    private static String IS_ENABLE_LOGGER = System.getProperty("enable.logger");

    public static boolean isEnableLogger(){
        if(IS_ENABLE_LOGGER == null || IS_ENABLE_LOGGER.length() == 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isEnableLogger());

    }
}
