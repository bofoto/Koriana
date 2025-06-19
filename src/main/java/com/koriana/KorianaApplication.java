package com.koriana;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value ="com.koriana.mapper")
@SpringBootApplication
public class KorianaApplication {

	
	public static void main(String[] args) {
		
		SpringApplication.run(KorianaApplication.class, args);
	}
	

}
