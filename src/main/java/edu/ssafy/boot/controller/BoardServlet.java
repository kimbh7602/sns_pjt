package edu.ssafy.boot.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.BoardVo;
import edu.ssafy.boot.service.BoardService;
import edu.ssafy.boot.service.IBoardService;

@Controller
@RequestMapping("/board.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	IBoardDAO dao = new BoardDaoDBImpl();
	@Autowired
	@Qualifier("BoardService")
	IBoardService bSer = new BoardService();

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String action = request.getParameter("action");
//		
//		System.out.println("action : " + action);
//		
//		if(action.equals("registerboard")) {
//			registerBoard(request, response);
//		}else if(action.equals("listboard")) {
//			listBoard(request, response);
//		}else if(action.equals("infoboard")) {
//			infoBoard(request, response);
//		}else if(action.equals("updateboard")) {
//			updateBoard(request, response);
//		}else if(action.equals("deleteboard")) {
//			deleteBoard(request, response);
//		}else if(action.equals("searchboard")) {
//			searchBoard(request, response);
//		}else if(action.equals("updateview")) {
//			updateView(request, response);
//		}
//	}
	@RequestMapping("/updateview")
	private ModelAndView updateView(HttpServletRequest request, ModelAndView mv) throws ServletException, IOException {
		try {
			String user_id = (String) request.getSession().getAttribute("currentId");
			int bid = Integer.parseInt(request.getParameter("bid"));
			String btitle = request.getParameter("btitle");
			String bcontent = request.getParameter("bcontent");
//			mv.addObject("bid", bid);
//			mv.addObject("btitle", btitle);
//			request.setAttribute("bid", bid);
//			request.setAttribute("btitle", btitle);
//			request.setAttribute("bcontent", bcontent);
			mv.addObject("board", new BoardVo(bid, btitle, bcontent, user_id));
			mv.setViewName("board_update");
		} catch (RuntimeException e) {
			
		}
//		request.getRequestDispatcher("board_update.jsp").forward(request, response);
		return mv;
	}
	@RequestMapping("/registerboard")
	private ModelAndView registerBoard(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws IOException {
		String user_id = (String) request.getSession().getAttribute("currentId");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		System.out.println(user_id);
		boolean res = bSer.registerBoard(user_id, btitle, bcontent);
		System.out.println(res);
		if (res) {
			mv.setViewName("redirect:/board.do/listboard");
		}
		return mv;
	}
	@RequestMapping("/listboard")
	private ModelAndView listBoard(HttpServletRequest request, HttpServletResponse response, ModelAndView mv)
			throws ServletException, IOException {
		ArrayList<BoardVo> list = bSer.listBoard();
		request.setAttribute("list", list);
//		System.out.println(list);
//		request.getRequestDispatcher("board_list.jsp").forward(request, response);
		mv.addObject("list", list);
		mv.setViewName("board_list");
		return mv;
	}
	@RequestMapping("/infoboard/{bid}")
	private ModelAndView infoBoard(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @PathVariable("bid") int bid)
			throws ServletException, IOException {
		boolean res = bSer.countUp(bid);
		BoardVo board = bSer.infoBoard(bid);
//		request.setAttribute("board", board);
//		request.getRequestDispatcher("board_view.jsp").forward(request, response);
		mv.addObject("board", board);
		mv.setViewName("board_view");
		return mv;
	}
	@RequestMapping("/updateboard")
	private ModelAndView updateBoard(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws IOException {
		String user_id = request.getParameter("user_id");
		int bid = Integer.parseInt(request.getParameter("bid"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		boolean res = bSer.updateBoard(user_id, bid, btitle, bcontent);
		if (res) {
//			response.sendRedirect("board.do?action=listboard");
			mv.setViewName("redirect:/board.do/listboard");
		}
		return mv;
	}
	@RequestMapping("/deleteboard/{bid}")
	private ModelAndView deleteBoard(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @PathVariable("bid") int bid) throws IOException {
		String user_id = (String) request.getSession().getAttribute("currentId");
		boolean res = bSer.deleteBoard(user_id, bid);
		if (res) {
//			response.sendRedirect("board.do?action=listboard");
			mv.setViewName("redirect:/board.do/listboard");
		}
		return mv;
	}
	@RequestMapping("/searchboard")
	private ModelAndView searchBoard(HttpServletRequest request, HttpServletResponse response, ModelAndView mv)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		ArrayList<BoardVo> list = bSer.searchBoard(keyword);
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("board_list.jsp").forward(request, response);
		mv.addObject("list", list);
		mv.setViewName("board_list");
		return mv;
	}

}
