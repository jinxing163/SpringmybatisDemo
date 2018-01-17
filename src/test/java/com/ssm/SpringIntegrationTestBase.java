package com.ssm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author JinXing
 * @date 2018/1/15 14:28
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit4ClassRunner
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class SpringIntegrationTestBase {

    protected Logger log = LoggerFactory.getLogger(getClass()) ;


    private Long starttime=null;

    @Before
    public void before(){
        starttime=System.currentTimeMillis();
    }

    @After
    public void after(){
        System.out.println("执行方法耗时："+(System.currentTimeMillis()-starttime) +"毫秒");
    }

    @Test
    public void test(){

    	Map<Long,Long> map2=new HashMap<Long,Long>();
    	for (Map.Entry<Long, Long> map : map2.entrySet()) {
			
		}
    	
    	List<Long> list=new ArrayList<Long>();
    	for (Long long1 : list) {
			
		}
    	
    	
        System.out.println("test............");

    }

}
