package com.jee4a.mobile.api.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jee4a.common.config.CommonProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * <p></p> 
 * @author tpeng 2018年1月29日
 * @email 398222836@qq.com
 */
@Service
public class UserInfoService {

	private final static  Logger  logger = LoggerFactory.getLogger(UserInfoService.class) ;
	
	@Resource
	private CommonProperties commonProperties ;
	
	@Resource
	private RestTemplate  restTemplate ;
	
	/**
	 * 
	 * 描述     :断熔器 
	 * @author tpeng 2018年1月29日
	 * @email 398222836@qq.com
	 */
	@HystrixCommand(fallbackMethod="userFallback")
	public String getUserInfo(Integer userId) {
		String info = null ;
		long start  = System.currentTimeMillis()  ;
		info = restTemplate.getForEntity(commonProperties.getUserServiceUrl()+"user-1/"+userId,String.class).getBody();
		long end   = System.currentTimeMillis() ;
		logger.info("spend time  : {}" , (end  - start ));
		return info ;
	}
	
	public String userFallback(Integer userId) {
		return  "error : " + userId ;
	}
	
}
