package vn.iostar.service;

import java.util.List;

import vn.iostar.dao.CategoryDaoImpl;
import vn.iostar.dao.ICategoryDao;
import vn.iostar.model.CategoryModel;

public class CategoryServiceImpl implements CategoryService {
	// hàm nào cần xử lý login sẽ viết ở đây
	// ko cần xử lý logic sẽ viết ở DAO
	public ICategoryDao cateDao = new CategoryDaoImpl();
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		// TODO Auto-generated method stub
		return cateDao.findById(id);
	}

	@Override
	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		cateDao.insert(category);
	}

	@Override
	public void update(CategoryModel category) {
		// TODO Auto-generated method stub
		CategoryModel cateModel = new CategoryModel();
		cateModel = cateDao.findById(category.getCategoryid());
		if(cateModel!=null) {
			cateDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		CategoryModel cateModel = new CategoryModel();
		cateModel = cateDao.findById(id);
		if(cateModel!=null) {
			cateDao.delete(id);
		}
	}

	@Override
	public List<CategoryModel> findByCategoryName(String categoryname) {
		// TODO Auto-generated method stub
		return cateDao.findByCategoryName(categoryname);
	}

}
