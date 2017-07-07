package com.example.demo;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.apache.catalina.filters.CorsFilter;
//import org.hamcrest.Matcher;
//import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.mockito.Matchers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.conf.DemoConfig;
import com.example.demo.controller.DemoController;
import com.example.demo.model.Demo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	private DemoController demoController;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders
				.standaloneSetup(demoController)
				.addFilters(new CorsFilter())
				.build();
	}

//	@Test
//	public void contextLoads() throws Exception {
//		Demo demo = new Demo();
//		demo.setA(100);
//		demo.setB(200);
//		this.mockMvc.perform(get("/"))
//		.andExpect(status().isOk())
//		.andExpect(view().name("home"))
////		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
////        .andExpect(jsonPath("$", hasSize(2)))
////        .andExpect(jsonPath("$[0].id", is(1)))
////        .andExpect(jsonPath("$[0].username", is("Daenerys Targaryen")))
////        .andExpect(jsonPath("$[1].id", is(2)))
////        .andExpect(jsonPath("$[1].username", is("John Snow"))
////		.andExpect(jsonPath("$.id", is(1)))
////		.andExpect(content().string(Matchers.containsString("sdf")))
//		.andExpect(model().attribute("demo", demo))
//		.andDo(print());
//	}
	
	@Test
	public void testRest() throws Exception{
		Demo demo = new Demo();
		demo.setA(100);
		demo.setB(200);
		
		String jsonString = "{'a':100,'b':200}";
		this.mockMvc.perform(get("/rest"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.a", is(100)))
		.andExpect(content().json(jsonString))
		.andDo(print());
	}
//	
//	@Autowired
//	Demo demo;
	
	
	
//	private DemoConfig demoConfig;
//	
//	@Autowired
//	public void setConfig(DemoConfig dc){
//		this.demoConfig = dc;
//	}
	
//	@Test
//	public void testEC(){
////		assertThat(demo.getA(), equalTo(100));
////		System.out.println(demo.getA());
//		
//		assertThat(demoConfig.getA(), equalTo(100));
//	}

}
