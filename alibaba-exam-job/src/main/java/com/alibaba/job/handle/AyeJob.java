package com.alibaba.job.handle;


import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

@Component
public class AyeJob {


    @XxlJob("fetchOrderHandler")
    public ReturnT<String>fetchOrderHandler(String params) throws Exception{
        XxlJobLogger.log("aye job[{}]", JSONObject.toJSONString(params));
        return ReturnT.SUCCESS;
    }
}
