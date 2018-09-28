package com.hieupx.springcloudclient.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="micro-service-2")
public interface Service2Proxy {

    @RequestMapping("/msg")
    public String getService2Msg();
}
