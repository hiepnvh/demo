package com.example.demo.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.example.demo.model.Demo;


//@Component
//@PropertySource("classpath:application.properties")
//public class DemoConfig {
//	
//
//	@Value("${prop.a}")
//	int a;
//	
//	@Value("${prop.b}")
//	int b;
//
//	
//	@Bean
//	Demo setDemo(){
//		Demo demo = new Demo();
//		demo.setA(a);
//		demo.setB(b);
//		return demo;
//	}
//	
//}

@Component
//@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "prop")
public class DemoConfig{
//	Demo demo = new Demo();
	
	int a,b;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	
	
//	@Bean
//	Demo setDemo(){
//		
//		Demo demo = new Demo();
//		demo.setA(a);
//		demo.setB(b);
//		return demo;
//	}
}