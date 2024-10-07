package vn.iostar.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.model.CategoryModel;
import vn.iostar.service.CategoryService;
import vn.iostar.service.CategoryServiceImpl;
import vn.iostar.utils.Constant;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,

		maxFileSize = 1024 * 1024 * 5,

		maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add", "/admin/category/insert", "/admin/category/edit", "/admin/category/update", "/admin/category/delete", "/admin/category/search"})

public class CategoryController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public CategoryService cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI(); //lấy URL
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		if(url.contains("categories")) {		
		List<CategoryModel> list = cateService.findAll();
		req.setAttribute("listcate", list); // truyền listcate xuống form categorylist.jsp
		req.getRequestDispatcher("/view/categorylist.jsp").forward(req, resp);
		}
		else if(url.contains("add")) {
			req.getRequestDispatcher("/view/categoryadd.jsp").forward(req, resp);
		}
		else if(url.contains("edit")) {
			String id = req.getParameter("id");
			int idInt = Integer.parseInt(id);
			CategoryModel cateModel = cateService.findById(idInt);
			req.setAttribute("cate", cateModel);
			req.getRequestDispatcher("/view/categoryedit.jsp").forward(req, resp);
		}
		else if(url.contains("delete")) {
			String id = req.getParameter("id");
			int idInt = Integer.parseInt(id);
			cateService.delete(idInt);
			resp.sendRedirect(req.getContextPath()+"/admin/categories");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI(); //lấy URL
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if(url.contains("insert")) {
		CategoryModel cateModel = new CategoryModel();
		String categoryname = req.getParameter("categoryname");
		String status = req.getParameter("status");
		int statusInt = Integer.parseInt(status);
		
		cateModel.setCategoryname(categoryname);
		cateModel.setStatus(statusInt);
		
		String fname="";
		String uploadPath = Constant.DIR;
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		try {
			Part part =  req.getPart("images");
			if(part.getSize()>0) {
				String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				// đổi tên file
				int index = filename.lastIndexOf(".");
				String ext = filename.substring(+1);
				// sinh số ngẫu nhiên tạo file mới
				fname = System.currentTimeMillis() + "." + ext;
				// upload file lên thư mục
				part.write(uploadPath+"/"+fname);
				// ghi tên file vào data:
				cateModel.setImages(fname);
			}
			else {
				cateModel.setImages("avata.png");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		cateService.insert(cateModel);
		resp.sendRedirect(req.getContextPath()+"/admin/categories");
		}
		else if(url.contains("update")) {
			CategoryModel cateModel = new CategoryModel();
			String categoryid = req.getParameter("categoryid"); // lấy từ name ở form
			int categoryidInt = Integer.parseInt(categoryid);
			String categoryname = req.getParameter("categoryname");
			String status = req.getParameter("status");
			int statusInt = Integer.parseInt(status);
			//lưu hình cũ:
			CategoryModel cateOld = cateService.findById(categoryidInt);
			String fileOld = cateOld.getImages();
			// xử lý images: 
			String fname="";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part =  req.getPart("images");
				if(part.getSize()>0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// đổi tên file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(+1);
					// sinh số ngẫu nhiên tạo file mới
					fname = System.currentTimeMillis() + "." + ext;
					// upload file lên thư mục
					part.write(uploadPath+"/"+fname);
					// ghi tên file vào data:
					cateModel.setImages(fname);
				}
				else {
					cateModel.setImages(fileOld);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			cateModel.setCategoryid(categoryidInt);
			cateModel.setCategoryname(categoryname);
			cateModel.setStatus(statusInt);
			cateService.update(cateModel);
			resp.sendRedirect(req.getContextPath()+"/admin/categories");
		}
	}
}
