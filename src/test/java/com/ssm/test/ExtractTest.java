package com.ssm.test;

import com.ssm.SpringIntegrationTestBase;
import org.junit.Test;

/**
 * @author JinXing
 * @date 2018/1/15 14:37
 */
public class ExtractTest extends SpringIntegrationTestBase{

    @Test
    public void test1(){

        Object obj = ExtractMethod.getObject();

        System.out.println(obj);

    }

    @Test
    public void test2(){

        Object obj = ExtractMethod.getObject();

        System.out.println(obj);

    }



}
