package vn.iostar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.mysql.cj.xdevapi.DatabaseObjectDescription;

import vn.iostar.config.DBConnection;
import vn.iostar.model.CategoryModel;
import vn.iostar.model.User;

public class CategoryDaoImpl implements ICategoryDao{

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> lis = new ArrayList<>();
		String sql = "SELECT * FROM category";
		try
		{
			conn = new DBConnection().getDatabaseConnection();
			ps = conn.prepareStatement(sql); // tạo đối tượng.
			rs = ps.executeQuery();
				while (rs.next()) {
					CategoryModel cate = new CategoryModel();
					cate.setCategoryid(rs.getInt("categoryid")); // Lấy từ tên cột.
					cate.setCategoryname(rs.getString("categoryname"));
					cate.setImages(rs.getString("images"));
					cate.setStatus(rs.getInt("status"));
					lis.add(cate);
				}
				conn.close();
				ps.close();
				rs.close();
				return lis;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel findById(int id) {
		String sql = "SELECT * FROM category WHERE categoryid = ? ";
		try {
			conn = new DBConnection().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id); // ở form;
			rs = ps.executeQuery();
				while (rs.next()) {
					CategoryModel cate = new CategoryModel();
					cate.setCategoryid(rs.getInt("categoryid"));
					cate.setCategoryname(rs.getString("categoryname"));
					cate.setImages(rs.getString("images"));
					cate.setStatus(rs.getInt("status"));
					return cate;
				}
				conn.close();
				ps.close();
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO category(categoryname, images, status) VALUES (?, ? ,?)";
		try {
			conn = new DBConnection().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname()); // ở form;
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel category) {
		String sql = "UPDATE category SET categoryname = ?, images = ?, status=? WHERE categoryid = ?";
		try {
			conn = new DBConnection().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname()); 
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM category WHERE categoryid = ? ";
		try {
			conn = new DBConnection().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CategoryModel> findByCategoryName(String categoryname) {
		String sql = "SELECT * FROM category WHERE categoryname LIKE ? ";
		List<CategoryModel> lis = new ArrayList<>();
		try {
			conn = new DBConnection().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+categoryname+"%");
			rs = ps.executeQuery();
				while (rs.next()) {
					CategoryModel cate = new CategoryModel();
					cate.setCategoryid(rs.getInt("categoryid"));
					cate.setCategoryname(rs.getString("categoryname"));
					cate.setImages(rs.getString("images"));
					cate.setStatus(rs.getInt("status"));
					lis.add(cate);
				}
				conn.close();
				ps.close();
				rs.close();
				return lis;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
	