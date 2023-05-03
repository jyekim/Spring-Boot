package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //이걸 잡아주면...? main클래스 아래에 있는건 알아서 처리가 된다는뜻?
//@Controller //그런데 @RestController가 아니라 Controller로 잡으면 반드시 밑에 responsebody를 써줘야함
public class HelloController {
	
	public HelloController() {
		System.out.println("HelloController 기본 생성자");
	}
	
	@GetMapping(value="/hello")
	//@ResponseBody
	public String hello(String name) { //스트링으로 하면 문자열로 읽기 떄문에 이걸 jsp파일로 찾게 된다 그래서 responsebody를 써서 문자열로 봐달라고 한거였음 
		return "안녕하세요" + name + "님";
	}

}
