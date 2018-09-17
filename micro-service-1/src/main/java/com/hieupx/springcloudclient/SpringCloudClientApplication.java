package com.hieupx.springcloudclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringCloudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudClientApplication.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${branch}")
	private String msg;

	@RequestMapping("/msg")
	String getMsg() {
		return this.msg;
	}
}
