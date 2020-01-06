package edu.ssafy.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.boot.dto.FoodVo;
import edu.ssafy.boot.repository.IFoodDAO;

@Service("FoodService")
public class FoodService implements IFoodService {
	public FoodService() {}
	
	@Autowired
	@Qualifier("FoodDAODBImpl")
	IFoodDAO dao;
	
	@Override
	public boolean deleteFood(int code) {
		boolean res = dao.foodDelete(code);
		return res;
	}

	@Override
	public boolean updateFood(FoodVo food) {
		boolean res = dao.foodUpdate(food);
		return res;
	}

	@Override
	public FoodVo infoFood(int code) {
		// TODO Auto-generated method stub
		FoodVo food = dao.foodInfo(code);
		return food;
	}

	@Override
	public List<FoodVo> listFood() {
		List<FoodVo> list = dao.foodList();
		return list;
	}

	@Override
	public boolean registerFood(FoodVo food) {
		boolean res = dao.foodInsert(food);
		return res;
	}

	@Override
	public List<FoodVo> searchFoodByName(String keyword) {
		List<FoodVo> list = dao.proSearchByName(keyword);
		return list;
	}
	@Override
	public List<FoodVo> searchFoodByMake(String keyword) {
		List<FoodVo> list = dao.proSearchByMake(keyword);
		return list;
	}
	@Override
	public List<FoodVo> searchFoodByMaterial(String keyword) {
		List<FoodVo> list = dao.proSearchByMaterial(keyword);
		return list;
	}

	@Override
	public int countFood() {
		int count = dao.foodCount();
		return count;
	}

	@Override
	public boolean ajaxToDb(List<FoodVo> foods) {
		boolean res = dao.ajaxToDb(foods);
		return res;
	}

	@Override
	public boolean searchCountUp(int code) {
		boolean res = dao.searchCountUp(code);
		return res;
	}

	@Override
	public List<FoodVo> searchByNameToFirst(String keyword) {
		List<FoodVo> list = dao.searchByNameToFirst(keyword);
		return list;
	}

	@Override
	public List<FoodVo> searchByMakerToFirst(String keyword) {
		List<FoodVo> list = dao.searchByMakeToFirst(keyword);
		return list;
	}

	@Override
	public List<FoodVo> searchByMaterialToFirst(String keyword) {
		List<FoodVo> list = dao.searchByMaterialToFirst(keyword);
		return list;
	}

	@Override
	public String allergyinfo(String id) {
		
		return dao.allergyinfo(id);
	}

}
