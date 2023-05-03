package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@SpringBootApplication
//@ComponentScan(basePackages = {"main.controller", "user.bean", "user.controller", "user.dao", "user.service"}) // .xml에 설정하던 controller scan을 annotation 처리
@ComponentScan(basePackages = {"main.controller", "user.*"}) //*이걸 쓰면 나머지 다 들어가는거!
public class Chapter02MySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter02MySqlApplication.class, args);
	}

}
