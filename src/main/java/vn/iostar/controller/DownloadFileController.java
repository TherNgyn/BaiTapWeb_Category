package vn.iostar.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.utils.Constant;
@WebServlet(urlPatterns = {"/image"}) // đặt bên jsp
public class DownloadFileController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* Lấy tham số fname từ form */
		String fileName = req.getParameter("fname");
		/* Đưa đường dẫn file ở máy chủ vào file */
		File file = new File(Constant.DIR + "/" + fileName);
		/* Loại nội dung trả về: jpeg */
		resp.setContentType("image/jpeg");
		/*
		 * Nếu file có trên hệ thống, sao chép từ tệp hình ảnh sang phản hồi cho trình
		 * duyệt
		 */
		if (file.exists()) {
			IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
		}
	}
}
