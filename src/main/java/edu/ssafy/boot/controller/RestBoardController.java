package edu.ssafy.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import edu.ssafy.boot.dto.BoardVo;
import edu.ssafy.boot.dto.CommVo;
import edu.ssafy.boot.dto.NoticeVo;
import edu.ssafy.boot.service.IBoardService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/board")
public class RestBoardController {

	@Autowired()
	@Qualifier("BoardService")
	IBoardService bSer;

	@PostMapping("/registerBoard")
	@ApiOperation(value = "게시판 등록")
	private @ResponseBody ResponseEntity<Map<String, Object>> registerBoard(@RequestBody BoardVo bv) {
		ResponseEntity<Map<String, Object>> resEntity = null;
			boolean res = bSer.registerBoard(bv.getUser_id(),bv.getBtitle(), bv.getBcontent());
			if(res) {
				Map<String, Object> msg = new HashMap<String, Object>();
				msg.put("resmsg", "게시판 등록 성공");
				resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
			}else {
				Map<String, Object> msg = new HashMap<String, Object>();
				msg.put("resmsg", "게시판 등록 실패");
				resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
			}
		return resEntity;
	}

	@GetMapping("/listBoard")
	@ApiOperation(value = "게시판 리스트 조회 ", response = List.class)
	private @ResponseBody ResponseEntity<Map<String, Object>> listBoard() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			ArrayList<BoardVo> list = bSer.listBoard();
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "게시판 List 조회 성공");
			msg.put("resValue", list);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);

		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "게시판 List 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/infoBoard/{bid}")
	@ApiOperation(value = "게시판 조회", response = BoardVo.class)
	private @ResponseBody ResponseEntity<Map<String, Object>> infoBoard(@PathVariable("bid") int bid) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			boolean res = bSer.countUp(bid);
			BoardVo board = bSer.infoBoard(bid);
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "게시판 조회 성공");
			msg.put("resValue", board);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "게시판 조회 실팬");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@PutMapping("/updateBoard")
	@ApiOperation(value = "게시판 수정")
	private @ResponseBody ResponseEntity<Map<String, Object>> updateBoard(@RequestBody BoardVo bv) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {

			boolean res = bSer.updateBoard(bv.getUser_id(), bv.getBid(), bv.getBtitle(), bv.getBcontent());
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "게시판 수정 성공");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "게시판 수정 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@DeleteMapping("/deleteBoard/{user_id}/{bid}")
	@ApiOperation(value = "게시판 삭제" )
	private @ResponseBody ResponseEntity<Map<String, Object>> deleteBoard(@PathVariable("user_id") String user_id, @PathVariable("bid") int bid) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			boolean res = bSer.deleteBoard(user_id, bid);
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg","게시글 삭제 성공");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg","게시글 삭제 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/searchBoard/{keyword}")
	@ApiOperation(value ="게시판 검색", response = List.class)
	private @ResponseBody ResponseEntity<Map<String,Object>> searchBoard(@PathVariable("keyword")String keyword) {
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			ArrayList<BoardVo> list = bSer.searchBoard(keyword);
			Map<String, Object> msg = new HashMap<String, Object>(); 
			msg.put("resmsg", "게시판 검색 성공");
			msg.put("resValue",list);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>(); 
			msg.put("resmsg", "게시판 검색 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}
	
	@GetMapping("/commlist/{bid}")
	@ApiOperation(value ="댓글 리스트", response = List.class)
	private @ResponseBody ResponseEntity<Map<String,Object>> commList(@PathVariable("bid") int bid){
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			List<CommVo> list = bSer.commList(bid);
			Map<String, Object> msg = new HashMap<String, Object>(); 
			msg.put("resmsg", "댓글 리스트 성공");
			msg.put("resValue",list);
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>(); 
			msg.put("resmsg", "댓글 리스트 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@PostMapping("/comminsert")
	private @ResponseBody ResponseEntity<Map<String,Object>> insertComm(@RequestBody CommVo vo){
		ResponseEntity<Map<String,Object>> resEntity = null;
		System.out.println(vo.toString());
		try {
			
			boolean res = bSer.insertComm(vo.getCid(), vo.getCcontent(), vo.getUser_id(), vo.getBid());
			System.out.println(res);
			if(res) {
				Map<String, Object> msg = new HashMap<String, Object>(); 
				msg.put("resmsg", "댓글 달기 성공");
				resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>(); 
			msg.put("resmsg", "댓글 달기 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
	@DeleteMapping("/commdelete/{cid}")
	private @ResponseBody ResponseEntity<Map<String,Object>> deleteComm(@PathVariable("cid") int cid){
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			boolean res = bSer.deleteComm(cid);
			if(res) {
				Map<String, Object> msg = new HashMap<String, Object>(); 
				msg.put("resmsg", "댓글 제거 성공");
				resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
			}
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>(); 
			msg.put("resmsg", "댓글 제거 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		
		return resEntity;
	}

}
