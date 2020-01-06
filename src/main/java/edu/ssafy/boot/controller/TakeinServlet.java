package edu.ssafy.boot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.TakeinFoodVO;
import edu.ssafy.boot.dto.TakeinSumVo;
import edu.ssafy.boot.service.ITakeinFoodService;

/**
 * Servlet implementation class IntakeServlet
 */
@Controller
@RequestMapping("/intake.do")
public class TakeinServlet extends HttpServlet {
	@Autowired
	@Qualifier("TakeinFoodService")
	ITakeinFoodService tSer;
	
	@RequestMapping("/searchintake")
	private ModelAndView searchintake(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("currentId");
		String keyword = request.getParameter("keyword");
		List<TakeinFoodVO> list = tSer.intakeSearch(id, keyword);
		TakeinSumVo sum = tSer.intakeSum(id);
//		request.setAttribute("sum", sum);
//		request.setAttribute("list", list);
//		System.out.println(list);
//		request.getRequestDispatcher("myintakeinfo.jsp").forward(request, response);
		mv.addObject("sum", sum);
		mv.addObject("list", list);
		mv.setViewName("myintakeinfo");
		return mv;
	}
	@RequestMapping("/selectallintake")
	private ModelAndView selectallIntake(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("currentId");
		List<TakeinFoodVO> list = tSer.intakeList(id);
		TakeinSumVo sum = tSer.intakeSum(id);
//		request.setAttribute("sum", sum);
//		request.setAttribute("list", list);
//		System.out.println(list);
//		request.getRequestDispatcher("myintakeinfo.jsp").forward(request, response);
		mv.addObject("sum", sum);
		mv.addObject("list", list);
		mv.setViewName("myintakeinfo");
		return mv;
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

	@RequestMapping("/insertintake/{code}")
	private ModelAndView insertIntake(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @PathVariable("code") int code) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("currentId");
		String msg = "";
		System.out.println(code);
		if(id != null) {
			int icount = 1;
			tSer.intakeInsert(code, id, icount);
			msg = "섭취정보 등록 완료";
		}else {
			msg = "섭취정보 등록 오류";
		}
//		request.setAttribute("msg", msg);
//		request.getRequestDispatcher("message.jsp").forward(request, response);
		mv.addObject("msg", msg);
		mv.setViewName("message");
		return mv;
	}

}
