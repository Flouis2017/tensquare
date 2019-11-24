package com.tensquare.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import util.IdWorker;
import util.SqlUtil;

@Configuration
public class BaseConfig {

	@Bean
	public IdWorker idWorker(){
		return new IdWorker();
	}

	@Bean
	public SqlUtil sqlUtil(){
		return new SqlUtil();
	}

}
