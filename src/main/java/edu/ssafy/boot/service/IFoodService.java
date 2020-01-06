package edu.ssafy.boot.service;

import java.util.ArrayList;
import java.util.List;

import edu.ssafy.boot.dto.FoodVo;

public interface IFoodService {
	public boolean deleteFood(int code);

	public boolean updateFood(FoodVo food);

	public FoodVo infoFood(int code);

	public List<FoodVo> listFood();

	public boolean registerFood(FoodVo food);
	
	public List<FoodVo> searchFoodByName(String keyword);
	public List<FoodVo> searchFoodByMake(String keyword);
	public List<FoodVo> searchFoodByMaterial(String keyword);

	public int countFood();
	
	public boolean ajaxToDb(List<FoodVo> foods);
	public boolean searchCountUp(int code);
	
	public List<FoodVo> searchByNameToFirst(String keyword);
	public List<FoodVo> searchByMakerToFirst(String keyword);
	public List<FoodVo> searchByMaterialToFirst(String keyword);

	public String allergyinfo(String id);
}
