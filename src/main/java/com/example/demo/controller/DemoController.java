package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.conf.DemoConfig;
import com.example.demo.model.Demo;

//@Controller
@RestController
public class DemoController {
//	@Autowired
//	Demo demo;
	
	private DemoConfig demoConfig;
	
	@Autowired
	public void setConf(DemoConfig dc){
		this.demoConfig = dc;
//		System.out.println(dc);
	}
	@RequestMapping(value = "/")
	public String goHome(Model model){
		System.out.println(demoConfig.getA());
		Demo demo = new Demo();
		demo.setA(demoConfig.getA());
		demo.setB(demoConfig.getB());
		model.addAttribute("demo", demo);
		return "home edited";
	}
	
	@RequestMapping(value = "/rest")
	public Demo goRest(){
		System.out.println(demoConfig.getA());
		Demo demo = new Demo();
		demo.setA(demoConfig.getA());
		demo.setB(demoConfig.getB());
		return demo;
	}
}
