package com.jee4a.mobile.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jee4a.common.config.CommonProperties;
import com.jee4a.mobile.api.service.UserInfoService;

/**
 * <p></p> 
 * @author tpeng 2018年1月26日
 * @email 398222836@qq.com
 */
@RestController
public class UserInfoController {

	@Resource
	private RestTemplate restTemplate ;
	
	@Resource
	private CommonProperties commonProperties ;
	
	
	@Resource
	private UserInfoService userInfoService ;
	
	/**
	 * 负载均衡示例
	 * 描述     : 
	 * @author tpeng 2018年1月29日
	 * @email 398222836@qq.com
	 */
	@RequestMapping(value="/userinfo/{userId}",method = RequestMethod.GET)
	public String userInfo(@PathVariable Integer userId) {
		return restTemplate.getForEntity(commonProperties.getUserServiceUrl()+"user/"+userId,String.class).getBody();
	}
	
	
	/**
	 * 
	 * 描述     : 断熔器
	 * @author tpeng 2018年1月29日
	 * @email 398222836@qq.com
	 */
	@RequestMapping(value="/userinfo-1/{userId}",method = RequestMethod.GET)
	public String userInfo1(@PathVariable Integer userId) {
		return userInfoService.getUserInfo(userId) ;
	} 
}
