package com.ssm.test;

/**
 * @author JinXing
 * @date 2018/1/15 15:05
 */
public class ExtractMethod {

    public static Object getObject() {
        Integer userId=20;
        Integer recruitId=10;
        Integer courseId=2;

        Object obj=null;

        if(userId==null || recruitId==null || courseId==null ){
            obj="缺少必要的参数！";
        }else{
            obj="参数正常！";
        }
        return obj;
    }

}
