package com.hieupx.springcloudclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class Service2 {

	public static void main(String[] args) {
		SpringApplication.run(Service2.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${msg}")
	private String msg;

	@RequestMapping("/msg")
	String getMsg() {
		return this.msg;
	}

	@RequestMapping("/get/exception")
	public String getHandleException() throws Exception {
		System.out.println("Throws exception for tracing demo");
		throw new Exception();
	}
}
