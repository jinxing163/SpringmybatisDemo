package com.ssm.quartz.xxl_job;

import com.ssm.baseTools.DateHelper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import org.springframework.stereotype.Component;

/**
 * @author JinXing
 * @date 2018/1/17 9:22
 */

@Component
@JobHander("springQuartzHandler")
public class SpringQuartzHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        ReturnT<String> rt=new ReturnT<>();

        rt.setCode(ReturnT.SUCCESS_CODE);
        rt.setContent("springQuartzHandler.....");
        rt.setMsg("定时器"+ DateHelper.getLocaleString());

        System.out.println("定时器"+ DateHelper.getLocaleString());

        return rt;
    }
}
