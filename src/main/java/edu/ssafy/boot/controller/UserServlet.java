package edu.ssafy.boot.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.MemVo;
import edu.ssafy.boot.service.IMemberService;

//@WebServlet("/user.do")
@Controller
@RequestMapping("/user.do")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Autowired
	IMemberService mSer;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		request.setCharacterEncoding("utf-8");
//		String action = request.getParameter("action");
//		
//		System.out.println("action : " + action);
//		
//		if(action.equals("signup")) {
//			signUpMem(request, response);
//		}else if(action.equals("loginmem")) {
//			loginMem(request, response);
//		}else if(action.equals("infomem")) {
//			infoMem(request, response);
//		}else if(action.equals("updatemem")) {
//			updateMem(request, response);
//		}else if(action.equals("findpw")) {
//			findPw(request, response);
//		}else if(action.equals("logoutmem")) {
//			logoutMem(request, response);
//		}
//	}
	
	@RequestMapping("/signUpPage")
	private ModelAndView signUpPage(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("signUp");
		return mv;
	}
	
	@RequestMapping("/loginmem")
	private ModelAndView loginMem(HttpServletRequest request, ModelAndView mv) {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
			boolean res = mSer.loginMem(id, password);
			if(res) {
			request.getSession().setAttribute("currentId", id);
			}
			mv.setViewName("redirect:/food.do/mainfood");
		} catch (RuntimeException e) {

		}
		return mv;
	}

	@RequestMapping("/logoutmem")
	private ModelAndView logoutMem(HttpServletRequest request, ModelAndView mv) throws IOException {
		request.getSession().invalidate();
		mv.setViewName("redirect:/food.do/mainfood");
		return mv;

	}

	@RequestMapping("/findpw")
	private ModelAndView findPw(HttpServletRequest request, ModelAndView mv) throws ServletException, IOException {

		String id = request.getParameter("id");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		try {
			MemVo mem = mSer.findPw(new MemVo(id, question, answer));
			mv.addObject("mem", mem);
			mv.setViewName("updatepersonalinfo.jsp");
//			request.getRequestDispatcher("updatepersonalinfo.jsp").forward(request, response);
		} catch (RuntimeException e) {

		}
		return mv;

	}

	@RequestMapping("/updatemem")
	private ModelAndView updateMem(HttpServletRequest request, ModelAndView mv) throws IOException {
	
		try {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String mname = request.getParameter("mname");
			String addr = request.getParameter("addr");
			String tel = request.getParameter("tel");
			String allergy = "";
			String[] allergyArr = request.getParameterValues("allergy");
			for (String str : allergyArr)
				allergy += str + " ";
			
			System.out.println(Arrays.toString(allergyArr));
			System.out.println(id);
			boolean updateMem = mSer.updateMem(new MemVo(id, password, mname, addr, tel,allergy.substring(0, allergy.length() - 1), "",
					""));
			System.out.println("updateMem = "+updateMem);
			mv.setViewName("redirect:/food.do/mainfood");
			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		return mv;
//        boolean res = mSer.updateMem(id,password,mname,addr,tel,"");
//        if(res) {
//			response.sendRedirect("index.jsp");
//        }else {
//        	
//        }		

	}

	@RequestMapping("/infomem")
	private ModelAndView infoMem(HttpServletRequest request, ModelAndView mv) {
		System.out.println("info ======");
		try {
			String id = request.getParameter("currentId");
			MemVo mem = mSer.infoMem(id);
			System.out.println(mem);
			mv.addObject("mem", mem);
			mv.setViewName("infoMem");
		} catch (RuntimeException e) {

		}
		return mv;

	}

	@RequestMapping("/signup")
	private ModelAndView signUpMem(HttpServletRequest request, HttpServletResponse response, ModelAndView mv){
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String mname = request.getParameter("mname");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		String[] allergyArr = request.getParameterValues("allergy");
		String allergy = "";
		for (String str : allergyArr)
			allergy += str + " ";
		boolean res = mSer.signUpMem(new MemVo(id, password, mname, addr, tel, allergy.substring(0, allergy.length() - 1), "",
				""));
		if (res) {
			mv.setViewName("redirect:/food.do/mainfood");
//			response.sendRedirect("index.jsp");
		} else {
			mv.setViewName("redirect:/food.do/mainfood");
		}
		
		return mv;
	}

}
