package edu.ssafy.boot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.NoticeVo;
import edu.ssafy.boot.service.INoticeService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/notice")
public class RestNoticeController {

	@Autowired()
	@Qualifier("NoticeService")
	INoticeService nSer;

	@GetMapping("/sortrecent")
	@ApiOperation(value = "공지사항 최신순 정렬", response = List.class)
	private @ResponseBody ResponseEntity<Map<String, Object>> sortRecent() {
		ResponseEntity<Map<String, Object>> resEntity = null;
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
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "최신순정렬 성공");
			msg.put("resvalue", list);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "최신순정렬 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/sortView")
	@ApiOperation(value = "공지사항 조회수순 정렬", response = List.class)
	private @ResponseBody ResponseEntity<Map<String, Object>> sortView() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
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
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "조회수순 정렬성공");
			msg.put("resvalue", list);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "조회수순 정렬실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/sortRegist")
	@ApiOperation(value = "공지사항 등록순 정렬", response = List.class)
	private @ResponseBody ResponseEntity<Map<String, Object>> sortRegist() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
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

			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "등록순 정렬성공");
			msg.put("resvalue", list);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "등록순 정렬실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@PostMapping("/registerNotice")
	@ApiOperation(value = "공지사항등록")
	private @ResponseBody ResponseEntity<Map<String, Object>> registerNotice(@RequestBody NoticeVo nv) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			boolean res = nSer.registerNotice(nv.getNtitle(), nv.getNcontent());
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "공지사항등록 성공");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "공지사항등록 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/listNotice")
	@ApiOperation(value = "공지사항 리스트 조회 ", response = List.class)
	private @ResponseBody ResponseEntity<Map<String, Object>> listNotice() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			ArrayList<NoticeVo> list = nSer.listNotice();
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "공지사항 List 조회 성공");
			msg.put("resvalue", list);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);

		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "공지사항 List 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/infoNotice/{nid}")
	@ApiOperation(value = "공지사항 조회", response = NoticeVo.class)
	private @ResponseBody ResponseEntity<Map<String, Object>> infoNotice(@PathVariable("nid") int nid) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			boolean res = nSer.countUp(nid);
			NoticeVo notice = nSer.infoNotice(nid);
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "공지사항조회 성공");
			msg.put("resValue", notice);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "공지사항조회 실팬");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@PutMapping("/updateNotice")
	@ApiOperation(value = "공지사항 수정")
	private @ResponseBody ResponseEntity<Map<String, Object>> updateNotice(@RequestBody NoticeVo nv) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {

			boolean res = nSer.updateNotice(nv.getNid(), nv.getNtitle(), nv.getNcontent());
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "공지사항 수정 성공");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "공지사항 수정 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@DeleteMapping("/deleteNotice/{nid}")
	@ApiOperation(value = "공지사항 삭제" )
	private @ResponseBody ResponseEntity<Map<String, Object>> deleteNotice(@PathVariable("nid") int nid) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			boolean res = nSer.deleteNotice(nid);
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg","공지사항삭제 성공");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg","공지사항삭제 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/searchNotice/{keyword}")
	@ApiOperation(value ="공지사항 검색", response = List.class)
	private @ResponseBody ResponseEntity<Map<String,Object>> searchNotice(@PathVariable("keyword")String keyword) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			ArrayList<NoticeVo> list = nSer.searchNotice(keyword);
			Map<String, Object> msg = new HashMap<String, Object>(); 
			msg.put("resmsg", "공지사항검색 성공");
			msg.put("resvalue",list);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>(); 
			msg.put("resmsg", "공지사항검색 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

}
