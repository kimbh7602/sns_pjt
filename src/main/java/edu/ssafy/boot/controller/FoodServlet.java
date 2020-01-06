package edu.ssafy.boot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.FoodVo;
import edu.ssafy.boot.handler.FoodSaxParser;
import edu.ssafy.boot.service.IFoodService;

@Controller()
@RequestMapping("/food.do")
public class FoodServlet {
	
	@Autowired
	@Qualifier("FoodService")
	IFoodService fSer;
	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { doPost(request, response); }
	 * 
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * request.setCharacterEncoding("utf-8"); String action =
	 * request.getParameter("action");
	 * 
	 * System.out.println("action : " + action);
	 * 
	 * if(action.equals("registerfood")) { registerFood(request, response); }else
	 * if(action.equals("listfood")) { listFood(request, response); }else
	 * if(action.equals("infofood")) { infoFood(request, response); }else
	 * if(action.equals("updatefood")) { updateFood(request, response); }else
	 * if(action.equals("deletefood")) { deleteFood(request, response); }else
	 * if(action.equals("insertfood")) { insertFood(request, response); }else
	 * if(action.equals("searchfood")) { searchFood(request, response); }else
	 * if(action.equals("countfood")) { countFood(request, response); }else
	 * if(action.equals("mainfood")) { mainFood(request, response); }else
	 * if(action.equals("listbyname")) { listByName(request, response); }else
	 * if(action.equals("listbymaker")) { listByMaker(request, response); }else
	 * if(action.equals("recommendfood")) { recommendFood(request, response); }else
	 * if(action.equals("searchfoodbykeyword")) { searchFoodByKeyword(request,
	 * response); } }
	 */

	@RequestMapping("/searchfoodbykeyword/{keyword}/{selection}")
	private ModelAndView searchFoodByKeyword(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @PathVariable("keyword") String keyword, @PathVariable("selection") String selection) throws ServletException, IOException {
		List<FoodVo> list = null;
		if(selection.equals("name")) {
			list = fSer.searchByNameToFirst(keyword);
		}else if(selection.equals("maker")) {
			list = fSer.searchByMakerToFirst(keyword);
		}else if(selection.equals("material")) {
			list = fSer.searchByMaterialToFirst(keyword);
		}
		System.out.println(list.size());
		
		mv.addObject("list", list);
		mv.setViewName("product_list");
		return mv;
	}
	@RequestMapping("/recommendfood")
	private ModelAndView recommendFood(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws ServletException, IOException {
//		String href = request.getParameter("href");
		List<FoodVo> list = fSer.listFood();
		int size = list.size();
		int idx = (int) (Math.random()*size);
		FoodVo food = list.get(idx);
		
		mv.addObject("recommend", food);
		mv.setViewName("modal");
		return mv;
	}
	@RequestMapping("/listbymaker")
	private ModelAndView listByMaker(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws ServletException, IOException {
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
		
		mv.addObject("list", list);
		mv.addObject("sel", "maker");
		mv.setViewName("productinfo");
		
		return mv;
		
	}
	@RequestMapping("/listbyname")
	private ModelAndView listByName(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws ServletException, IOException {
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
		
		mv.addObject("list", list);
		mv.addObject("sel", "name");
		mv.setViewName("productinfo");
		
		return mv;
	}
	@RequestMapping("/mainfood")
	private ModelAndView mainFood(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws ServletException, IOException {
		List<FoodVo> listFood = fSer.listFood();
		List<FoodVo> list = new ArrayList<FoodVo>();
		for (int i = 0; i < 6; i++) {
			list.add(listFood.get(i));
		}
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("main.jsp").forward(request, response);
		mv.addObject("list", list);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/searchfood/{keyword}/{selection}")
	private ModelAndView searchFood(@PathVariable("keyword") String keyword, @PathVariable("selection") String selection, ModelAndView mv) throws ServletException, IOException {
		List<FoodVo> list = null;
		if(selection.equals("name")) {
			list = fSer.searchFoodByName(keyword);
		}else if(selection.equals("maker")) {
			list = fSer.searchFoodByMake(keyword);
		}else if(selection.equals("material")) {
			list = fSer.searchFoodByMaterial(keyword);
		}
		mv.addObject("list", list);
		mv.setViewName("productinfo");
		return mv;
	}
	
	
	@RequestMapping("/registerfood")
	private void registerFood(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		double supportpereat = Double.parseDouble(request.getParameter("supportpereat"));
		double calory = Double.parseDouble(request.getParameter("calory"));
		double carbo = Double.parseDouble(request.getParameter("carbo"));
		double protein = Double.parseDouble(request.getParameter("protein"));
		double fat = Double.parseDouble(request.getParameter("fat"));
		double sugar = Double.parseDouble(request.getParameter("sugar"));
		double natrium = Double.parseDouble(request.getParameter("natrium"));
		double chole = Double.parseDouble(request.getParameter("chole"));
		double fattyacid = Double.parseDouble(request.getParameter("fattyacid"));
		double transfat = Double.parseDouble(request.getParameter("transfat"));
		String maker = request.getParameter("maker");
		String material = request.getParameter("material");
		String img = request.getParameter("img");
		String allergy = request.getParameter("allergy");
		
		boolean res = fSer.registerFood(new FoodVo(code, name, supportpereat, calory, carbo, protein, fat, sugar, natrium, chole, fattyacid, transfat, maker, material, img, allergy));
		
		if(res) {
			response.sendRedirect("food.do/listFood");
		}else {
			//
		}
		
	}
	@RequestMapping("/listfood")
	private ModelAndView listFood(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws ServletException, IOException {
		List<FoodVo> list = fSer.listFood();
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("productinfo.jsp").forward(request, response);
		
		mv.addObject("list", list);
		mv.setViewName("productinfo");
		return mv;
	}
	@RequestMapping("/infofood/{code}")
	private ModelAndView infoFood(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @PathVariable("code") int code) throws ServletException, IOException {
//		int code = Integer.parseInt(request.getParameter("code"));
		System.out.println(code);
		boolean res = fSer.searchCountUp(code);
		if(res) {
			FoodVo food = fSer.infoFood(code);
//			request.setAttribute("food", food);
//			request.getRequestDispatcher("productdetail.jsp").forward(request, response);
			mv.addObject("food", food);
			mv.setViewName("productdetail");
		}
		
		return mv;
	}
	@RequestMapping("/updatefood")
	private void updateFood(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		double supportpereat = Double.parseDouble(request.getParameter("supportpereat"));
		double calory = Double.parseDouble(request.getParameter("calory"));
		double carbo = Double.parseDouble(request.getParameter("carbo"));
		double protein = Double.parseDouble(request.getParameter("protein"));
		double fat = Double.parseDouble(request.getParameter("fat"));
		double sugar = Double.parseDouble(request.getParameter("sugar"));
		double natrium = Double.parseDouble(request.getParameter("natrium"));
		double chole = Double.parseDouble(request.getParameter("chole"));
		double fattyacid = Double.parseDouble(request.getParameter("fattyacid"));
		double transfat = Double.parseDouble(request.getParameter("transfat"));
		String maker = request.getParameter("maker");
		String material = request.getParameter("material");
		String img = request.getParameter("img");
		String allergy = request.getParameter("allergy");
		
		boolean res = fSer.updateFood(new FoodVo(code, name, supportpereat, calory, carbo, protein, fat, sugar, natrium, chole, fattyacid, transfat, maker, material, img, allergy));
		
		if(res) {
			response.sendRedirect("food.do/listFood");
		}else {
			//
		}
	}
	@RequestMapping("/deletefood")
	private void deleteFood(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		boolean res = fSer.deleteFood(code);
		
		if(res) {
			response.sendRedirect("food.do/listFood");
		}else {
			//
		}
		
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

	@RequestMapping("/countfood")
	private ModelAndView countFood(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws ServletException, IOException {
		System.out.println(1);
		int count = fSer.countFood();
		if(count == 0) {
			// 절대경로 처리
			String path = request.getServletContext().getRealPath("/res");
			String foodPath = "file:\\"+path+"\\FoodInfo.xml";
			String nutPath = "file:\\"+path+"\\FoodNutritionInfo.xml";
			
			FoodSaxParser parser = new FoodSaxParser(nutPath, foodPath);
			List<FoodVo> foods = parser.getFoods();
			System.out.println(foods);
			
//			request.setAttribute("foods", foods);
//			request.getRequestDispatcher("food.do/insertfood").forward(request, response);;
			mv.addObject("foods", foods);
			boolean res = fSer.ajaxToDb(foods);
			if(res) {
				mv.setViewName("redirect:/food.do/mainfood");
			}
		}else {
			mv.setViewName("redirect:/food.do/mainfood");
		}
		
		return mv;
	}
	
}
