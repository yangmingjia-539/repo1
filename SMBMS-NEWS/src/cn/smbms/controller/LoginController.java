package cn.smbms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.bcel.internal.Constants;

import cn.smbms.pojo.User;


import services.UserService;

public class LoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login.html")
	public String login( ){
		return "login";
	}
	
	@RequestMapping(value="/login.html",method=RequestMethod.POST)
		
	public String dologin(@RequestParam String userCode,
						@RequestParam String userPassword,
						HttpServletRequest request,
						HttpSession session)throws Exception{
		User user = userService.login(userCode,userPassword);
		if(null != user){//登录成功
			session.setAttribute(Constants.USER_SESSION, user);
			return "redirct:/sys/main.html";
		}else{
			request.setAttribute("err", "用户名不正确");
			return "login";
		}
	}
	@RequestMapping(value="login.html")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.USER_SESSION);
		return "login";
	}
	
	
	@RequestMapping(value="/sys/main.html")
	public String main(){
		return "frame";
	}
	
}



