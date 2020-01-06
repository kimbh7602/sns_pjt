package edu.ssafy.boot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.BoardVo;
import edu.ssafy.boot.dto.NoticeVo;
import edu.ssafy.boot.service.INoticeService;

@Controller
@RequestMapping("/notice.do")
public class NoticeController {

	@Autowired
	INoticeService nSer;

	@RequestMapping("/sortrecent")
	private ModelAndView sortRecent(HttpServletRequest request, ModelAndView mv) {
		try {

			ArrayList<NoticeVo> list = nSer.listNotice();
			list.sort(new Comparator<NoticeVo>() {

				@Override
				public int compare(NoticeVo o1, NoticeVo o2) {
					// TODO Auto-generated method stub
					int id1 = o1.getNid();
					int id2 = o2.getNid();

					return id2 - id1;
				}
			});
			mv.addObject("list", list);
			mv.addObject("sel", "recent");
			mv.setViewName("notice_list");
//			request.setAttribute("list", list);
//			request.setAttribute("sel", "recent");
//			request.getRequestDispatcher("notice_list.jsp").forward(request, response);

		} catch (RuntimeException e) {
			mv.setViewName("notice_list");
		}
		return mv;
	}

	@RequestMapping("/sortView")
	private ModelAndView sortView(HttpServletRequest request, ModelAndView mv) {
		// TODO Auto-generated method stub
		ArrayList<NoticeVo> list = nSer.listNotice();
		list.sort(new Comparator<NoticeVo>() {

			@Override
			public int compare(NoticeVo o1, NoticeVo o2) {
				// TODO Auto-generated method stub
				int cnt1 = o1.getNcount();
				int cnt2 = o2.getNcount();

				return cnt2 - cnt1;
			}
		});
		System.out.println(list.toString());
		mv.addObject("list", list);
		mv.addObject("sel", "view");
		mv.setViewName("notice_list");

		return mv;
//		request.setAttribute("list", list);
//		request.setAttribute("sel", "view");
//		request.getRequestDispatcher("notice_list.jsp").forward(request, response);
	}

	@RequestMapping("/sortRegist")
	private ModelAndView sortRegist(HttpServletRequest request, ModelAndView mv) {
		ArrayList<NoticeVo> list = nSer.listNotice();
		list.sort(new Comparator<NoticeVo>() {

			@Override
			public int compare(NoticeVo o1, NoticeVo o2) {
				// TODO Auto-generated method stub
				int id1 = o1.getNid();
				int id2 = o2.getNid();

				return id1 - id2;
			}
		});
		mv.addObject("list", list);
		mv.addObject("sel", "reg");
		mv.setViewName("notice_list");

//		request.setAttribute("sel", "reg");
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("notice_list.jsp").forward(request, response);
		return mv;
	}

	@RequestMapping("/registerNotice")
	private ModelAndView registerNotice(HttpServletRequest request, ModelAndView mv) throws IOException {

		try {
			String ntitle = request.getParameter("ntitle");
			String ncontent = request.getParameter("ncontent");
			boolean res = nSer.registerNotice(ntitle, ncontent);
			mv.setViewName("redirect:/notice.do/listNotice");
		} catch (RuntimeException e) {
			mv.setViewName("redirect:/notice.do/listNotice");
		}
		return mv;
	}

	@RequestMapping("/listNotice")
	private ModelAndView listNotice(HttpServletRequest request, ModelAndView mv) {
		try {
			ArrayList<NoticeVo> list = nSer.listNotice();
			mv.addObject("list", list);
			mv.setViewName("notice_list");
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("notice_list.jsp").forward(request, response);
		} catch (RuntimeException e) {
			mv.setViewName("notice_list");
		}
		return mv;
	}

	@RequestMapping("/infoNotice/{nid}")
	private ModelAndView infoNotice(HttpServletRequest request, ModelAndView mv, @PathVariable("nid") int nid) {
		try {
			boolean res = nSer.countUp(nid);
			NoticeVo notice = nSer.infoNotice(nid);
			mv.addObject("notice", notice);
			mv.setViewName("notice_view");
		} catch (RuntimeException e) {

		}
		return mv;
	}
	
	@RequestMapping("/updateview/{nid}")
	private ModelAndView updateView(HttpServletRequest request, ModelAndView mv, @PathVariable("nid") int nid) throws ServletException, IOException {
		try {
			NoticeVo notice = nSer.infoNotice(nid);
			mv.addObject("notice", notice);
			mv.setViewName("notice_update");
		} catch (RuntimeException e) {
			
		}
//		request.getRequestDispatcher("board_update.jsp").forward(request, response);
		return mv;
	}

	@RequestMapping("/updateNotice")
	private ModelAndView updateNotice(HttpServletRequest request, ModelAndView mv) {
		try {
			int nid = Integer.parseInt(request.getParameter("nid"));
			String ntitle = request.getParameter("ntitle");
			String ncontent = request.getParameter("ncontent");
			System.out.println(nid);
			boolean res = nSer.updateNotice(nid, ntitle, ncontent);
			mv.setViewName("redirect:/notice.do/listNotice");

//				response.sendRedirect("notice.do?action=listnotice");
		} catch (RuntimeException e) {

		}
		return mv;
	}

	@RequestMapping("/deleteNotice/{nid}")
	private ModelAndView deleteNotice(HttpServletRequest request, ModelAndView mv, @PathVariable("nid") int nid) throws IOException {
		try {
			boolean res = nSer.deleteNotice(nid);
			mv.setViewName("redirect:/notice.do/listnotice");
//		if (res) {
//			response.sendRedirect("notice.do?action=listnotice");
//		}
		} catch (RuntimeException e) {
			mv.setViewName("redirect:/notice.do/listnotice");
		}
		return mv;
	}

	@RequestMapping("/searchNotice")
	private ModelAndView searchNotice(HttpServletRequest request, ModelAndView mv){
		try {
		String keyword = request.getParameter("keyword");
		ArrayList<NoticeVo> list = nSer.searchNotice(keyword);
		mv.addObject("list", list);
		mv.setViewName("notice_list");
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("notice_list.jsp").forward(request, response);
		}catch(RuntimeException e) {
			mv.setViewName("redirect:/notice.do/listnotice");
		}
		return mv;
	}

}
