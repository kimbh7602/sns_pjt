package edu.ssafy.boot.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.FoodVo;

@Repository("FoodDAODBImpl")
public class FoodDAODBImpl implements IFoodDAO {
	
	@Autowired
	SqlSession session;
	
	@Override
	public boolean foodInsert(FoodVo food) {
		
		int insert = session.insert("ssafy.food.insert", food);
		if(insert > 0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<FoodVo> foodList() {
		
		List<FoodVo> list = session.selectList("ssafy.food.selectList");
		return list;
	}
	@Override
	public FoodVo foodInfo(int code) {
		
		FoodVo food = session.selectOne("ssafy.food.selectOne", code);
		return food;
	}
	@Override
	public boolean foodUpdate(FoodVo food) {
		
		int update = session.update("ssafy.food.update", food);
		if(update > 0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean foodDelete(int code) {
		int delete = session.delete("ssafy.food.delete", code);
		if(delete > 0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<FoodVo> proSearchByName(String keyword) {
		List<FoodVo> list = session.selectList("ssafy.food.proSearchByName", keyword);
		return list;
	}
	@Override
	public List<FoodVo> proSearchByMake(String keyword) {
		List<FoodVo> list = session.selectList("ssafy.food.proSearchByMake", keyword);
		return list;
	}
	@Override
	public List<FoodVo> proSearchByMaterial(String keyword) {
		List<FoodVo> list = session.selectList("ssafy.food.proSearchByMaterial", keyword);
		return list;
	}
	@Override
	public int foodCount() {
		List<FoodVo> list = session.selectList("ssafy.food.selectList");
		int count = list.size();
		return count;
	}
	@Override
	public boolean ajaxToDb(List<FoodVo> foods) {
		boolean res = false;
		
		for (FoodVo vo : foods) {
			int code = vo.getCode();
			String name = vo.getName();
			double supportpereat = vo.getSupportpereat();
			double calory = vo.getCalory();
			double carbo = vo.getCarbo();
			double protein = vo.getProtein();
			double fat = vo.getFat();
			double sugar = vo.getSugar();
			double natrium = vo.getNatrium();
			double chole = vo.getChole();
			double fattyacid = vo.getFattyacid();
			double transfat = vo.getTransfat();
			String maker = vo.getMaker();
			String material = vo.getMaterial();
			String img = vo.getImg();
			String allergy = vo.getAllergy();
			int searchCount = 0;

			session.insert("ssafy.food.insert", new FoodVo(code, name, supportpereat, calory, carbo, protein, fat, sugar, natrium, chole, fattyacid, transfat, maker, material, img, allergy, searchCount));

			res = true;
		}
		
		return res;
	}
	@Override
	public boolean searchCountUp(int code) {
		int update = session.update("ssafy.food.searchCountUp", code);
		if(update > 0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<FoodVo> searchByNameToFirst(String keyword) {
		List<FoodVo> list = session.selectList("ssafy.food.searchByNameToFirst", keyword);
		return list;
	}
	@Override
	public List<FoodVo> searchByMakeToFirst(String keyword) {
		List<FoodVo> list = session.selectList("ssafy.food.searchByMakeToFirst", keyword);
		return list;
	}
	@Override
	public List<FoodVo> searchByMaterialToFirst(String keyword) {
		List<FoodVo> list = session.selectList("ssafy.food.searchByMaterialToFirst", keyword);
		return list;
	}
	@Override
	public String allergyinfo(String id) {
		
		return session.selectOne("ssafy.food.allergyinfo", id);
	}
}
