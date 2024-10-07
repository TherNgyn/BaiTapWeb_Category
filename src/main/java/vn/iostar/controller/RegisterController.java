package vn.iostar.controller;

import java.io.IOException;

import org.eclipse.tags.shaded.org.apache.bcel.classfile.Constant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.service.UserService;
import vn.iostar.service.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("name") != null) {
			resp.sendRedirect(req.getContextPath() + "/admin");
			return;
		}
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("name")) {
					session = req.getSession(true);
					session.setAttribute("name", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/admin");
					return;
				}
			}
		}
		req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("name_r");
		String pw = req.getParameter("password_r");
		String fn = req.getParameter("fullname");
		String id_r = req.getParameter("number");
		
		int id = Integer.parseInt(id_r);
		
		UserService service = new UserServiceImpl();
		String alert = "";
		if (service.checkExistUsername(username)) {
			alert = "Tài khoản đã tồn tại";
			req.setAttribute("alert", alert);
			req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
			return;
		}
		if (service.checkExistId(id)) {
			alert = "ID đã tồn tại";
			req.setAttribute("alert", alert);
			req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
			return;
		}
		boolean isSucess = service.register(id, username, pw, fn);
		if (isSucess) {
			req.setAttribute("alert", alert);
			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
			alert = "System error";
			req.setAttribute("alert", alert);
			req.getRequestDispatcher("view/register.jsp");
			}
		}
	}