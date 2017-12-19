package com.xuyh.CrazyRebate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;



@SpringBootApplication
@MapperScan("com.xuyh.CrazyRebate.mapper")

public class CrazyRebateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrazyRebateApplication.class, args);
	}
}
