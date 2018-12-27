package com.jun.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProjectProperties {
	
	@Value("${com.jun.demo.title}")
	public String title;
	
	@Value("${com.jun.demo.description}")
	public String description;
	
	/*@Value("${spring.redis.port}")
	public String redisPort;*/

}
