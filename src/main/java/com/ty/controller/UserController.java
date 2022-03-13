package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.AdminDao;
import com.ty.dao.UserDao;
import com.ty.dto.Admin;
import com.ty.dto.User;

@Controller
public class UserController {

	UserDao dao = new UserDao();

	@RequestMapping(value = "/createuser")
	public ModelAndView createUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createuser.jsp");
		mv.addObject("user", new User());
		return mv;
	}

	@RequestMapping("/edituser")
	public ModelAndView editUser(@RequestParam int id) {
		User user = dao.getUserById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("myuser", user);
		mv.setViewName("edituser.jsp");
		return mv;
	}

	@RequestMapping("/updateuser")
	public ModelAndView updateUser(@ModelAttribute User user) {
		AdminDao dao2 = new AdminDao();
		Admin admin = dao2.getAdminById(user.getAdminId());
		user.setAdmin(admin);
		dao.editUser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewusers");
		return mv;
	}

	@RequestMapping("/deleteuser")
	public ModelAndView deleteUser(@RequestParam int id) {
		dao.deleteUser(id);
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("message", "User is Deleted");
		mv.setViewName("message.jsp");
		return mv;

	}

	@RequestMapping(value = "/saveuser")
	public ModelAndView saveUser(@ModelAttribute User user) {

		AdminDao dao2 = new AdminDao();
		Admin admin = dao2.getAdminById(user.getAdminId());
		user.setAdmin(admin);
		dao.createUser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("message.jsp");
		mv.addObject("message", user.getName() + " is Saved");
		return mv;
	}

	@RequestMapping("/viewusers")
	public ModelAndView getAllUsers() {
		List<User> users = dao.getAllUsers();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displayuser.jsp");
		mv.addObject("users", users);
		return mv;
	}

	@RequestMapping("/userlogin")
	public void loginServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		PrintWriter pout = resp.getWriter();

		UserDao dao = new UserDao();
		User user = dao.validateUser(email, password);

		if (user != null) {

			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("name", user.getName());
			httpSession.setAttribute("id", user.getId());

			RequestDispatcher dispatcher = req.getRequestDispatcher("userhome.jsp");
			dispatcher.forward(req, resp);

		} else {
			pout.print("<h1>Invalid email or password</h1>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);

		}

	}

	
	@RequestMapping("/kitchenlogin")
	public void kitchenLoginServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		PrintWriter pout = resp.getWriter();

		UserDao dao = new UserDao();
		User user = dao.validateUser(email, password);

		if (user != null) {

			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("name", user.getName());
			httpSession.setAttribute("id", user.getId());

			RequestDispatcher dispatcher = req.getRequestDispatcher("vieworder");
			dispatcher.forward(req, resp);

		} else {
			pout.print("<h1>Invalid email or password</h1>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);

		}

	}
	
	@RequestMapping("/userlogout")
	public void logoutServlet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession httpSession = req.getSession();
		httpSession.invalidate();
		resp.sendRedirect("login.jsp");

	}

}