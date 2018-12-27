package com.jun.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jun.demo.dao.UserRepository;
import com.jun.demo.mapper.UserMapper;
import com.jun.demo.model.User;
import com.jun.demo.properties.ProjectProperties;
import com.jun.demo.rabbitMqSender.HelloSender;
@RestController
public class IndexController {
	
	//private Logger logger = LoggerFactory;
	
	@Autowired
	private ProjectProperties projectProperties;
	
	@Autowired
	private StringRedisTemplate template;
	
	//@Autowired
	//private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private HelloSender helloSender;
	
	@RequestMapping(value="/indexPage")
	public String index() {
		
		return "indexPage";
	}
	
	@RequestMapping(value="/showMainPage")
	public ModelAndView showMainPage() {
		// TODO Auto-generated method stub
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		return mv;
	}
	
	@RequestMapping("/getUserMap")
    public Map getUserMap() {
		Map map=new HashMap();
		map.put("user", "小明");
		map.put("age", 3);
		map.put("title", projectProperties.title);
		map.put("description", projectProperties.description);
		//map.put("redisPort", projectProperties.redisPort);
        return map;
    }
	
	@RequestMapping("/getUser")
    public User getUser() {
		/*Optional<User> findById = userRepository.findById(new Long(1));
		User user= (User)findById.get();
		System.out.println(user);
        return user;*/
		return null;
    }
	
	@RequestMapping("/getUserByMyBatis")
    public User getUserByMyBatis() {
		User user = userMapper.getOne(new Long(1));
		return user;
    }
    
    @RequestMapping("/setValue")
    public String setValue(){
    	if(!template.hasKey("shabao")){
    		template.opsForValue().append("shabao", "我是傻宝");
    		return "使用redis缓存保存数据成功";
    	}else{
    		template.delete("shabao");
    		return "key已存在";
    	}
    }
    
    @RequestMapping("/getValue")
    public String getValue(){
    	
    	if(!template.hasKey("shabao")){
    		return "key不存在，请先保存数据";
    	}else{
    		String shabao = template.opsForValue().get("shabao");//根据key获取缓存中的val 
    		return "获取到缓存中的数据：shabao="+shabao;
    	}
    }
    
    @RequestMapping("/sendHello")
    public void sendHello() {
		// TODO Auto-generated method stub
    	helloSender.send();
	}

}
