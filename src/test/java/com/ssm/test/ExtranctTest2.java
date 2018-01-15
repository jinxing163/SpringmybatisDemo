package com.ssm.test;

import com.ssm.SpringIntegrationTestBase;
import org.junit.Test;

/**
 * @author JinXing
 * @date 2018/1/15 14:54
 */
public class ExtranctTest2 extends SpringIntegrationTestBase{

    @Test
    public void test(){

        Object obj = ExtractMethod.getObject();

        System.out.println(obj);



    }




}
