package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.AdminDao;
import com.ty.dao.UserDao;
import com.ty.dto.Admin;



@Controller
public class AdminController {

     AdminDao dao=new AdminDao();
	
	@RequestMapping("/adminlogin")
	public void loginServlet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("controller");
		String email = req.getParameter("email");
		String password = req.getParameter("Pass");
		
		PrintWriter pout = resp.getWriter();
		
		AdminDao dao = new AdminDao();
		Admin admin = dao.validateAdmin(email, password);
		
		if(admin!= null) {
			
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("name", admin.getName());
			httpSession.setAttribute("id", admin.getId());
			
			System.out.println(httpSession.getAttribute("id"));
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("adminhome.jsp");
			dispatcher.forward(req, resp);
			
			
		} else {
			pout.print("<h1>Invalid email or password</h1>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
			
		}
		
	
	}
		@RequestMapping("/adminlogout")
	public void logoutServlet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
	
		HttpSession httpSession = req.getSession();
		httpSession.invalidate();
		
		resp.sendRedirect("login.jsp");
	
		
	}
	
	
}