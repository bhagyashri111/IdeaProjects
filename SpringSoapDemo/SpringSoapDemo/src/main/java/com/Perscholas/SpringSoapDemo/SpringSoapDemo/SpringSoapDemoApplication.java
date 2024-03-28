package com.Perscholas.SpringSoapDemo.SpringSoapDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringSoapDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapDemoApplication.class, args);
	}

}
