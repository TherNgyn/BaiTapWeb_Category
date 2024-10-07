package vn.iostar.service;

import java.util.List;

import vn.iostar.model.CategoryModel;

public interface CategoryService {
	List<CategoryModel> findAll(); //lấy tất cả category
	CategoryModel findById(int id);
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete(int id);
	List<CategoryModel> findByCategoryName(String categoryname);
}
