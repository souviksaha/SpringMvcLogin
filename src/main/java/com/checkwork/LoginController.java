package com.checkwork;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView checkUser(HttpServletRequest req, HttpServletResponse res)
	{

		ModelAndView mv=new ModelAndView();

		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
     
		/*
		if(uname.equals("abc") && pass.equals("123"))
		{
			System.out.println("Inside success");
			mv.setViewName("success.jsp");				
		}//end of if
		else
		{
			System.out.println("Inside else");
			mv.setViewName("index.jsp");
		}
         */				
		
		LoginService ls=new LoginService();
		
		if(ls.check(uname,pass))
		{
			//System.out.println("Inside success");
			mv.setViewName("success.jsp");
		}
		else
		{
			//System.out.println("Inside fail");
			mv.setViewName("index.jsp");
		}
		
		return mv;

	}//end of ModelAndView

}//end of class LoginController