package edu.ssafy.boot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.TakeinFoodVO;
import edu.ssafy.boot.dto.TakeinSumVo;
import edu.ssafy.boot.service.ITakeinFoodService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/intake")
public class RestTakeinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	@Qualifier("TakeinFoodService")
	ITakeinFoodService tSer;
	
	@GetMapping("/searchintake/{id}")
	private @ResponseBody ResponseEntity<Map<String, Object>> searchintake(@PathVariable("id") String id) throws ServletException, IOException {
//		String keyword = request.getParameter("keyword");
//		List<TakeinFoodVO> list = tSer.intakeSearch(id, keyword);
//		TakeinSumVo sum = tSer.intakeSum(id);
////		request.setAttribute("sum", sum);
////		request.setAttribute("list", list);
////		System.out.println(list);
////		request.getRequestDispatcher("myintakeinfo.jsp").forward(request, response);
//		mv.addObject("sum", sum);
//		mv.addObject("list", list);
//		mv.setViewName("myintakeinfo");
//		return mv;
		return null;
	}
	@GetMapping("/selectallintake/{id}")
	private @ResponseBody ResponseEntity<Map<String, Object>> selectallIntake(@PathVariable("id") String id) throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		
		List<TakeinFoodVO> list = tSer.intakeList(id);
		TakeinSumVo sum = tSer.intakeSum(id);
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("resmsg", "섭취식품 리스트 성공");
		msg.put("list", list);
		msg.put("sum", sum);
	
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		
		return resEntity;
	}
	
	@RequestMapping("/selectoneintake")
	private ModelAndView selectOneIntake(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("currentId");
		int code = Integer.parseInt(request.getParameter("code"));
		TakeinFoodVO food = tSer.intakeInfo(id, code);
//		request.getRequestDispatcher("myintakeinfo.jsp").forward(request, response);
		
		mv.addObject("food", food);
		mv.setViewName("myintakeinfo");
		return mv;
	}
	@RequestMapping("/deleteintake")
	private ModelAndView deleteIntake(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("currentId");
		int code = Integer.parseInt(request.getParameter("code"));
		tSer.intakeDelete(id, code);
//		request.getRequestDispatcher("myintakeinfo.jsp").forward(request, response);
		mv.setViewName("myintakeinfo");
		return mv;
	}

	@RequestMapping("/insertintake/{code}/{id}")
	private @ResponseBody ResponseEntity<Map<String, Object>> insertIntake(@PathVariable("code") int code, @PathVariable("id") String id) throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		if(id != null) {
			int icount = 1;
			tSer.intakeInsert(code, id, icount);
			msg.put("resmsg", "섭취정보 등록 완료");
		}else {
			msg.put("resmsg", "섭취정보 등록 실패");
		}
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		
		return resEntity;
	}
	
	@GetMapping("/sortintake/{selected}/{selFormat}/{id}")
	private @ResponseBody ResponseEntity<Map<String, Object>> sortintake(@PathVariable("selected") String selected, @PathVariable("selFormat") String selFormat, @PathVariable("id") String id) throws ServletException, IOException {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		if(selected.equals("year")) {
			List<TakeinFoodVO> list = tSer.yearsort(selFormat, id);
			TakeinSumVo sum = tSer.yearsortSum(selFormat, id);
			msg.put("resmsg", "올해 섭취정보 갱신 성공");
			msg.put("list", list);
			msg.put("sum", sum);
		}else if(selected.equals("month")) {
			List<TakeinFoodVO> list = tSer.monthsort(selFormat, id);
			TakeinSumVo sum = tSer.monthsortSum(selFormat, id);
			msg.put("resmsg", "이번 달 섭취정보 갱신 성공");
			msg.put("list", list);
			msg.put("sum", sum);
		}else if(selected.equals("today")) {
			List<TakeinFoodVO> list = tSer.todaysort(selFormat, id);
			TakeinSumVo sum = tSer.todaysortSum(selFormat, id);
			msg.put("resmsg", "오늘 섭취정보 갱신 성공");
			msg.put("list", list);
			msg.put("sum", sum);
		}
		resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		return resEntity;
	}

}
