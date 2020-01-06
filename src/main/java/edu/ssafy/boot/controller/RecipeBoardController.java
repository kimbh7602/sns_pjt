package edu.ssafy.boot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.ui.Model;
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

import edu.ssafy.boot.dto.BoardVo;
import edu.ssafy.boot.dto.RecipeBoardVo;
import edu.ssafy.boot.repository.BoardDaoDBImpl;
import edu.ssafy.boot.repository.RecipeBoardDAO;
import edu.ssafy.boot.repository.RecipeBoardDAOImpl;
import edu.ssafy.boot.service.IRecipeBoardService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/recipeboard")
public class RecipeBoardController {

	@Autowired
	@Qualifier("RecipeBoardService")
	IRecipeBoardService ser;

	

	@PostMapping("/registerboard")
	@ApiOperation(value = "레시피 등록")
	private @ResponseBody ResponseEntity<Map<String, Object>> registerBoard(@RequestBody RecipeBoardVo rbvo) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		boolean res = ser.registerRecipeBoard(rbvo);
		if (res) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "레시피 등록 성공");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} else {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "게시판 등록 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;

	}

	@GetMapping("/recipeboardlist")
	@ApiOperation(value ="레시피리스트 조회 ", response = List.class)
	private @ResponseBody ResponseEntity<Map<String,Object>> listBoard(){
		ResponseEntity<Map<String,Object>> resEntity = null;
		try {
			List<RecipeBoardVo> list = ser.listRecipeBoard();
			Map<String,Object> msg = new HashMap<String,Object>();
			msg.put("resmsg", "레시피리스트 조회 성공");
			msg.put("list", list);
			resEntity = new ResponseEntity<Map<String,Object>>(msg,HttpStatus.OK);
		}catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "레시피리스트 조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
		
	}

	@GetMapping("/infoboard/{rbid}")
	@ApiOperation(value="레시피 조회", response = RecipeBoardVo.class)
	private @ResponseBody ResponseEntity<Map<String,Object>>infoBoard(@PathVariable("rbid") int rbid) {
		System.out.println("1221");
		ResponseEntity<Map<String,Object>> resEntity = null ;
		try {
			boolean res = ser.countUp(rbid);
			RecipeBoardVo rboard = ser.infoRecipeBoard(rbid);
			Map<String,Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "레시피 조회 성공");
			msg.put("resValue", rboard);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}catch (RuntimeException e) {
			System.out.println("123123");
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "게시판 조회 실팬");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
		
	}

	@PutMapping("/updateboard")
	@ApiOperation(value = "레시피 업데이트")
	private @ResponseBody ResponseEntity<Map<String, Object>> updateBoard(@RequestBody RecipeBoardVo rbvo) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			boolean res = ser.updateRecipeBoard(rbvo);
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "레시피수정 성공");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg", "레시피 수정 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}
	
	@DeleteMapping("/deleteboard/{rbid}/{user_id}")
	@ApiOperation(value ="레시피 삭제 ")
	private @ResponseBody ResponseEntity<Map<String,Object>> deleteBoard(@PathVariable("user_id") String user_id, @PathVariable("rbid") int rbid) {
		ResponseEntity<Map<String,Object>> resEntity = null; 
		try {
			boolean res = ser.deleteRecipeBoard(user_id, rbid);
			Map<String,Object> msg = new HashMap<String, Object>();
			if (res) {
				msg.put("resmsg", "레시피 삭제 성공");
			}else {
				msg.put("resmsg", "레시피 삭제 실패");
			}
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}catch (RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resmsg","게시글 삭제 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@GetMapping("/searchboard/{keyword}")
	@ApiOperation(value ="레시피 검색 ", response = List.class)
	private @ResponseBody ResponseEntity<Map<String,Object>> searchBoard(@PathVariable("keyword") String keyword) {
		ResponseEntity<Map<String,Object>> resEntity = null; 
		try {
			List<RecipeBoardVo> list = ser.searchRecipeBoard(keyword);
			Map<String,Object> msg = new HashMap<String,Object>();
			msg.put("resmsg", "레시피 검색 성공 ");
			msg.put("resValue", list);
			resEntity = new ResponseEntity<Map<String,Object>>(msg,HttpStatus.OK);
		}catch(RuntimeException e) {
			Map<String, Object> msg = new HashMap<String, Object>(); 
			msg.put("resmsg", "게시판 검색 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
		
	}

}