package com.design.hice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.design.hice.mapper")
public class DesignApplication {
	private final static Logger logger = LoggerFactory.getLogger(DesignApplication.class);

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(DesignApplication.class);
		springApplication.run(args);

	}

}
