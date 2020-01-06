package edu.ssafy.boot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.boot.dto.NoticeVo;
import edu.ssafy.boot.repository.INoticeDAO;
import edu.ssafy.boot.repository.NoticeDaoDBImpl;
import edu.ssafy.boot.service.INoticeService;
import edu.ssafy.boot.service.NoticeService;

@WebServlet("/notice.do")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	INoticeDAO dao = new NoticeDaoDBImpl();
	INoticeService nSer = new NoticeService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		System.out.println("action : " + action);
		
		if(action.equals("registernotice")) {
			registerNotice(request, response);
		}else if(action.equals("listnotice")) {
			listNotice(request, response);
		}else if(action.equals("infonotice")) {
			infoNotice(request, response);
		}else if(action.equals("updatenotice")) {
			updateNotice(request, response);
		}else if(action.equals("deletenotice")) {
			deleteNotice(request, response);
		}else if(action.equals("searchnotice")) {
			searchNotice(request, response);
		}else if(action.equals("sortregist")) {
			sortRegist(request, response);
		}else if(action.equals("sortview")) {
			sortView(request, response);
		}else if(action.equals("sortrecent")) {
			sortRecent(request, response);
		}
	}

	private void sortRecent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<NoticeVo> list = nSer.listNotice();
		list.sort(new Comparator<NoticeVo>() {

			@Override
			public int compare(NoticeVo o1, NoticeVo o2) {
				// TODO Auto-generated method stub
				int id1 = o1.getNid();
				int id2 = o2.getNid();
				
				return id2-id1;
			}
		});
		request.setAttribute("list", list);
		request.setAttribute("sel", "recent");
		request.getRequestDispatcher("notice_list.jsp").forward(request, response);
	}

	private void sortView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<NoticeVo> list = nSer.listNotice();
		list.sort(new Comparator<NoticeVo>() {

			@Override
			public int compare(NoticeVo o1, NoticeVo o2) {
				// TODO Auto-generated method stub
				int cnt1 = o1.getNcount();
				int cnt2 = o2.getNcount();
				
				return cnt2-cnt1;
			}
		});
		System.out.println(list.toString());
		request.setAttribute("list", list);
		request.setAttribute("sel", "view");
		request.getRequestDispatcher("notice_list.jsp").forward(request, response);
	}

	private void sortRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<NoticeVo> list = nSer.listNotice();
		list.sort(new Comparator<NoticeVo>() {

			@Override
			public int compare(NoticeVo o1, NoticeVo o2) {
				// TODO Auto-generated method stub
				int id1 = o1.getNid();
				int id2 = o2.getNid();
				
				return id1-id2;
			}
		});
		request.setAttribute("sel", "reg");
		request.setAttribute("list", list);
		request.getRequestDispatcher("notice_list.jsp").forward(request, response);
		
	}

	private void registerNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ntitle = request.getParameter("ntitle");
		String ncontent = request.getParameter("ncontent");
		boolean res = nSer.registerNotice(ntitle, ncontent);
		if(res) {
			response.sendRedirect("notice.do?action=listnotice");
		}
	}

	private void listNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<NoticeVo> list = nSer.listNotice();
		request.setAttribute("list", list);
		System.out.println(list);
		request.getRequestDispatcher("notice_list.jsp").forward(request, response);
	}

	private void infoNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nid = Integer.parseInt(request.getParameter("nid"));
		boolean res = nSer.countUp(nid);
		NoticeVo notice = nSer.infoNotice(nid);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("notice_view.jsp").forward(request, response);
	}

	private void updateNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int nid = Integer.parseInt(request.getParameter("nid"));
		String ntitle = request.getParameter("ntitle");
		String ncontent = request.getParameter("ncontent");
		boolean res = nSer.updateNotice(nid, ntitle, ncontent);
		if(res) {
			response.sendRedirect("notice.do?action=listnotice");
		}
		
	}

	private void deleteNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int nid = Integer.parseInt(request.getParameter("nid"));
		boolean res = nSer.deleteNotice(nid);
		if(res) {
			response.sendRedirect("notice.do?action=listnotice");
		}
	}

	private void searchNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		ArrayList<NoticeVo> list = nSer.searchNotice(keyword);
		request.setAttribute("list", list);
		request.getRequestDispatcher("notice_list.jsp").forward(request, response);
	}

}
