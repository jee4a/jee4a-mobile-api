package com.jee4a.ribbon.consumer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jee4a.common.config.CommonProperties;

/**
 * <p></p> 
 * @author tpeng 2018年1月26日
 * @email 398222836@qq.com
 */
@RestController
public class ConsumerController {

	@Resource
	private RestTemplate restTemplate ;
	
	@Resource
	private CommonProperties commonProperties ;
	
	@RequestMapping(value="/userinfo/{userId}",method = RequestMethod.GET)
	public String userInfo(@PathVariable Integer userId) {
		return restTemplate.getForEntity(commonProperties.getQueryById()+userId,String.class).getBody();
	}
}
