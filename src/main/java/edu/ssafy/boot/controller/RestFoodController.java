package edu.ssafy.boot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.boot.dto.FoodVo;
import edu.ssafy.boot.handler.FoodSaxParser;
import edu.ssafy.boot.service.IFoodService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController()
@RequestMapping("/api/food")
public class RestFoodController {
	
	@Autowired
	@Qualifier("FoodService")
	IFoodService fSer;
	
	@GetMapping("/searchfoodbykeyword/{keyword}/{selection}")
	@ApiOperation(value="keyword와 selection을 받아 keyword로 시작되는 제품명리스트검색 selection= {name, maker, material}")
	private @ResponseBody ResponseEntity<Map<String, Object>> searchFoodByKeyword(@PathVariable("keyword") String keyword, @PathVariable("selection") String selection) throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		List<FoodVo> list = null;
		if(selection.equals("name")) {
			list = fSer.searchByNameToFirst(keyword);
			msg.put("resmsg", "제품명검색 성공");
			msg.put("list", list);
		}else if(selection.equals("maker")) {
			list = fSer.searchByMakerToFirst(keyword);
			msg.put("resmsg", "제품명검색 성공");
			msg.put("list", list);
		}else if(selection.equals("material")) {
			list = fSer.searchByMaterialToFirst(keyword);
			msg.put("resmsg", "제품명검색 성공");
			msg.put("list", list);
		}
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	@GetMapping("/recommendfood")
	@ApiOperation(value="랜덤함수를 통해 무작위로 음식추천")
	private @ResponseBody ResponseEntity<Map<String, Object>> recommendFood() throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		List<FoodVo> list = fSer.listFood();
		int size = list.size();
		int idx = (int) (Math.random()*size);
		FoodVo food = list.get(idx);
		
		msg.put("resmsg", "무작위 제품추천 성공");
		msg.put("resValue", food);
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	@GetMapping("/listbymaker")
	@ApiOperation(value="제조사순 제품정렬")
	private @ResponseBody ResponseEntity<Map<String, Object>> listByMaker() throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		List<FoodVo> list = fSer.listFood();
		list.sort(new Comparator<FoodVo>() {

			@Override
			public int compare(FoodVo o1, FoodVo o2) {
				// TODO Auto-generated method stub
				String maker1 = o1.getMaker();
				String maker2 = o2.getMaker();
				
				if(maker1.length() < maker2.length()) {
					for (int i = 0; i < maker1.length(); i++) {
						if((int)maker1.charAt(i) > (int)maker2.charAt(i)) {
							return 1;
						}else if((int)maker1.charAt(i) < (int)maker2.charAt(i)) {
							return -1;
						}
					}
					
					return 1;
				}else {
					for (int i = 0; i < maker2.length(); i++) {
						if((int)maker1.charAt(i) > (int)maker2.charAt(i)) {
							return 1;
						}else if((int)maker1.charAt(i) < (int)maker2.charAt(i)) {
							return -1;
						}
					}
					
					return 1;
				}
			}
		});
		
		msg.put("resmsg", "제조사순 제품정렬 성공");
		msg.put("list", list);
		msg.put("sel", "maker");
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		return resEntity;
		
	}
	@GetMapping("/listbyname")
	@ApiOperation(value="제품명순 제품정렬")
	private @ResponseBody ResponseEntity<Map<String, Object>> listByName() throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		List<FoodVo> list = fSer.listFood();
		list.sort(new Comparator<FoodVo>() {

			@Override
			public int compare(FoodVo o1, FoodVo o2) {
				// TODO Auto-generated method stub
				String name1 = o1.getName();
				String name2 = o2.getName();

				if(name1.length() < name2.length()) {
					for (int i = 0; i < name1.length(); i++) {
						if((int)name1.charAt(i) > (int)name2.charAt(i)) {
							return 1;
						}else if((int)name1.charAt(i) < (int)name2.charAt(i)) {
							return -1;
						}
					}

					return 1;
				}else {
					for (int i = 0; i < name2.length(); i++) {
						if((int)name1.charAt(i) > (int)name2.charAt(i)) {
							return 1;
						}else if((int)name1.charAt(i) < (int)name2.charAt(i)) {
							return -1;
						}
					}

					return 1;
				}
			}
		});
		
		msg.put("resmsg", "제품명순 제품정렬 성공");
		msg.put("list", list);
		msg.put("sel", "name");
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	@GetMapping("/mainfood")
	@ApiOperation(value="메인페이지를 위한 제품리스트 중 6개 항목 리스트 출력")
	private @ResponseBody ResponseEntity<Map<String, Object>> mainFood() throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		List<FoodVo> listFood = fSer.listFood();
		List<FoodVo> list = new ArrayList<FoodVo>();
		for (int i = 0; i < 6; i++) {
			list.add(listFood.get(i));
		}
		msg.put("resmsg", "메인페이지 제품리스트출력 성공");
		msg.put("list", list);
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	@GetMapping("/searchfood/{keyword}/{selection}")
	@ApiOperation(value="keyword와 selection을 받아서 selection별 keyword검색 selection= {name, maker, material}")
	private @ResponseBody ResponseEntity<Map<String, Object>> searchFood(@PathVariable("keyword") String keyword, @PathVariable("selection") String selection) throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		List<FoodVo> list = null;
		if(selection.equals("name")) {
			list = fSer.searchFoodByName(keyword);
			msg.put("resmsg", "제품명 검색 성공");
			msg.put("list", list);
		}else if(selection.equals("maker")) {
			list = fSer.searchFoodByMake(keyword);
			msg.put("resmsg", "제조사 검색 성공");
			msg.put("list", list);
		}else if(selection.equals("material")) {
			list = fSer.searchFoodByMaterial(keyword);
			msg.put("resmsg", "재료명 검색 성공");
			msg.put("list", list);
		}
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	
	
	@PostMapping("/registerfood")
	@ApiOperation("제품등록")
	private @ResponseBody ResponseEntity<Map<String, Object>> registerFood(@RequestBody FoodVo dto) throws IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
//		int code = Integer.parseInt(request.getParameter("code"));
//		String name = request.getParameter("name");
//		double supportpereat = Double.parseDouble(request.getParameter("supportpereat"));
//		double calory = Double.parseDouble(request.getParameter("calory"));
//		double carbo = Double.parseDouble(request.getParameter("carbo"));
//		double protein = Double.parseDouble(request.getParameter("protein"));
//		double fat = Double.parseDouble(request.getParameter("fat"));
//		double sugar = Double.parseDouble(request.getParameter("sugar"));
//		double natrium = Double.parseDouble(request.getParameter("natrium"));
//		double chole = Double.parseDouble(request.getParameter("chole"));
//		double fattyacid = Double.parseDouble(request.getParameter("fattyacid"));
//		double transfat = Double.parseDouble(request.getParameter("transfat"));
//		String maker = request.getParameter("maker");
//		String material = request.getParameter("material");
//		String img = request.getParameter("img");
//		String allergy = request.getParameter("allergy");
		
		boolean res = fSer.registerFood(dto);
		
		if(res) {
			msg.put("resmsg", "제품 등록 성공");
		}
		
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		
		return resEntity;
	}
	@GetMapping("/listfood")
	@ApiOperation(value="제품 리스트 출력")
	private @ResponseBody ResponseEntity<Map<String, Object>> listFood() throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		List<FoodVo> list = fSer.listFood();
		msg.put("resmsg", "제품 리스트 출력 성공");
		msg.put("list", list);
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);

		return resEntity;
	}
	
	@GetMapping("/infofood/{code}")
	@ApiOperation(value="제품 상세정보 출력")
	private @ResponseBody ResponseEntity<Map<String, Object>> infoFood(@PathVariable("code") int code) throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		boolean res = fSer.searchCountUp(code);
		if(res) {
			FoodVo food = fSer.infoFood(code);
			msg.put("resmsg", "제품 상세정보 출력 성공");
			msg.put("food", food);
		}else {
			msg.put("resmsg", "제품 상세정보 출력 실패");
		}
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	@PutMapping("/updatefood")
	@ApiOperation(value="제품 정보 수정")
	private @ResponseBody ResponseEntity<Map<String, Object>> updateFood(@RequestBody FoodVo dto) throws IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
//		int code = Integer.parseInt(request.getParameter("code"));
//		String name = request.getParameter("name");
//		double supportpereat = Double.parseDouble(request.getParameter("supportpereat"));
//		double calory = Double.parseDouble(request.getParameter("calory"));
//		double carbo = Double.parseDouble(request.getParameter("carbo"));
//		double protein = Double.parseDouble(request.getParameter("protein"));
//		double fat = Double.parseDouble(request.getParameter("fat"));
//		double sugar = Double.parseDouble(request.getParameter("sugar"));
//		double natrium = Double.parseDouble(request.getParameter("natrium"));
//		double chole = Double.parseDouble(request.getParameter("chole"));
//		double fattyacid = Double.parseDouble(request.getParameter("fattyacid"));
//		double transfat = Double.parseDouble(request.getParameter("transfat"));
//		String maker = request.getParameter("maker");
//		String material = request.getParameter("material");
//		String img = request.getParameter("img");
//		String allergy = request.getParameter("allergy");
		
		boolean res = fSer.updateFood(dto);
		
		if(res) {
			msg.put("resmsg", "제품 정보 수정 성공");
		}else {
			msg.put("resmsg", "제품 정보 수정 실패");
		}
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	@DeleteMapping("/deletefood/{code}")
	@ApiOperation(value="제품 삭제")
	private @ResponseBody ResponseEntity<Map<String, Object>> deleteFood(@PathVariable("code") int code) throws IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		boolean res = fSer.deleteFood(code);
		
		if(res) {
			msg.put("resmsg", "제품 정보 삭제 성공");
		}else {
			msg.put("resmsg", "제품 정보 삭제 실패");
		}
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
//	@RequestMapping("/insertfood")
//	private ModelAndView insertFood(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws IOException {
//		List<FoodVo> foods = (List<FoodVo>) request.getAttribute("foods");
//		System.out.println(foods);
//		boolean res = fSer.ajaxToDb(foods);
//		if(res) {
//			mv.setViewName("redirect:/food.do/mainfood");
//		}
//		return mv;
//	}
	
	@GetMapping("/eatablefood/{id}")
	@ApiOperation(value="제품 리스트 출력")
	private @ResponseBody ResponseEntity<Map<String, Object>> eatableFood(@PathVariable("id") String id) throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		List<FoodVo> foodList = fSer.listFood();
		List<FoodVo> list = new ArrayList<FoodVo>();
		
		String allergy = fSer.allergyinfo(id);
		if(allergy != null) {
			String[] allergyArr = allergy.split(" ");
			System.out.println(Arrays.toString(allergyArr));
			
			for (int i = 0; i < foodList.size(); i++) {
				String foodAllergy = foodList.get(i).getAllergy();
				boolean flag = true;
				for (int j = 0; j < allergyArr.length; j++) {
					if(foodAllergy.contains(allergyArr[j])) {
						flag = false;
						break;
					}
				}
				if(flag) {
					list.add(foodList.get(i));
				}
			}
			
			msg.put("resmsg", "섭취가능 제품 리스트 출력 성공");
			msg.put("list", list);
			msg.put("allergy", allergy);
		}else {
			msg.put("resmsg", "섭취가능 제품 리스트 출력 성공");
			msg.put("list", foodList);
			msg.put("allergy", allergy);
		}
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);

		return resEntity;
	}

	@GetMapping("/countfood")
	@ApiOperation(value="xml파싱 여부")
	private @ResponseBody ResponseEntity<Map<String, Object>> countFood(HttpServletRequest request) throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		int count = fSer.countFood();
		if(count == 0) {
			// 절대경로 처리
			String path = request.getServletContext().getRealPath("/res");
			String foodPath = "file:\\"+path+"\\FoodInfo.xml";
			String nutPath = "file:\\"+path+"\\FoodNutritionInfo.xml";
			
			FoodSaxParser parser = new FoodSaxParser(nutPath, foodPath);
			List<FoodVo> foods = parser.getFoods();
			boolean res = fSer.ajaxToDb(foods);
			if(res) {
				msg.put("resmsg", "xml 파싱 성공");
			}else {
				msg.put("resmsg", "xml 파싱 실패");
			}
		}else {
			
		}
		
		return resEntity;
	}
}
