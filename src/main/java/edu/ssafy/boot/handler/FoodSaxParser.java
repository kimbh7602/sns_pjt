package edu.ssafy.boot.handler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import edu.ssafy.boot.dto.FoodVo;
import edu.ssafy.boot.dto.allergyVo;


/**
 * FoodNutritionSAXHandler와 FoodSAXHandler를 이용해서 식품 정보를 load하는 SAX Parser 프로 그램  
 *
 */
public class FoodSaxParser {
	//private String nutritionFilePath = "res/FoodNutritionInfo.xml";
	//private String foodFilePath = "res/FoodInfo.xml";
	private StringBuilder xml ;
	private List<FoodVo> foods;
 	public FoodSaxParser(String url, String url2) {
 		System.out.println("parse로 들어왔습니다.");
		loadData(url, url2);
	}
 	
 	/**
 	 * FoodNutritionSAXHandler와 FoodSAXHandler를 이용 파싱한 식품 정보와 식품 영양 정보를  Food에 병합한다. 
 	 */
	private void loadData(String nutritionFilePath, String foodFilePath) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try{
			SAXParser parser = factory.newSAXParser();
			FoodSAXHandler handler = new FoodSAXHandler();
			FoodNutritionSAXHandler nHandler = new FoodNutritionSAXHandler();
			parser.parse(foodFilePath,handler);
			parser.parse(nutritionFilePath,nHandler);
			Map<String, FoodVo> foodMap = handler.getFoods();
			foods = nHandler.getList();
			FoodVo find;
			String allergySample = new allergyVo().getAllergy();
			HashSet<String> allergySet = new HashSet<String>();
			for (FoodVo food : foods) {
				find = foodMap.get(food.getName());
				if(find!=null) {
					String allergy = "";
					allergySet.clear();
					food.setCode(find.getCode());
					food.setName(find.getName());
					food.setMaker(find.getMaker());
					food.setMaterial(find.getMaterial());
					String material = find.getMaterial();
					StringTokenizer st = new StringTokenizer(allergySample);
					while(st.hasMoreTokens()) {
						String next = st.nextToken();
						if(material.contains(next)) {
							allergySet.add(next);
						}
					}
					for (String s : allergySet) {
						allergy += s + " ";
					}
					food.setAllergy(allergy.trim());
					food.setImg(find.getImg());
				}
			}
			System.out.println(foods);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List<FoodVo> getFoods() {
		return foods;
	}
	public void setFoods(List<FoodVo> foods) {
		this.foods = foods;
	}
	
}
