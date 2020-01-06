package edu.ssafy.boot.repository;

import java.util.List;

import edu.ssafy.boot.dto.FoodVo;

public interface IFoodDAO {
	public boolean foodInsert(FoodVo food);
	
	public List<FoodVo> foodList();
	
	public FoodVo foodInfo(int code);
	
	public boolean foodUpdate(FoodVo food);
	
	public boolean foodDelete(int code);
	
	public List<FoodVo> proSearchByName(String keyword);
	public List<FoodVo> proSearchByMake(String keyword);
	public List<FoodVo> proSearchByMaterial(String keyword);

	public int foodCount();
	
	public boolean ajaxToDb(List<FoodVo> foods);
	
	public boolean searchCountUp(int code);

	public List<FoodVo> searchByNameToFirst(String keyword);
	public List<FoodVo> searchByMakeToFirst(String keyword);
	public List<FoodVo> searchByMaterialToFirst(String keyword);

	public String allergyinfo(String id);
}
