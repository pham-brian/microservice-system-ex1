package com.hieupx.springcloudclient;

import com.hieupx.springcloudclient.proxy.Service2Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class Service1 {

	public static void main(String[] args) {
		SpringApplication.run(Service1.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {

	@Autowired
	Service2Proxy service2Proxy;

	@Value("${msg}")
	private String msg;

	@RequestMapping("/msg")
	String getMsg() {
		return this.msg;
	}

	@RequestMapping("/get/service2/msg")
	String getService2Msg() {
		System.out.println("Connect to service1 to get message .....");
		return service2Proxy.getService2Msg();
	}

	@RequestMapping("/get/service2/exception")
	public String getException() {
		System.out.println("Connect to service1 to get exception ..... ");
		return service2Proxy.getHandleException();
	}

}
