package vn.iostar.controller;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.dao.UserDao;
import vn.iostar.dao.UserDaoImpl;
import vn.iostar.model.User;
import vn.iostar.utils.Constant;
import vn.iostar.service.UserService;
import vn.iostar.service.UserServiceImpl;
@WebServlet(urlPatterns = {"/fogotpassword"})
public class FogetPasswordController extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/view/forgetPW.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("name");
		String pw = req.getParameter("password");
		String alert = "";
		UserService user = new UserServiceImpl();
		
		boolean isSuccess = user.forgotPassWord(username, pw);
		
		if(isSuccess) {
			alert = "Đổi mật khẩu thành công";
			req.setAttribute("alert", alert);
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		}
		else
			alert ="User không tồn tại";
			req.setAttribute("alert", alert);
			req.getRequestDispatcher("/view/forgetPW.jsp").forward(req, resp);
	}
}
