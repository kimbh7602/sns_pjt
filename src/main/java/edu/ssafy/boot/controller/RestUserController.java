package edu.ssafy.boot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.boot.dto.MemVo;
import edu.ssafy.boot.repository.IMemberDAO;
import edu.ssafy.boot.repository.MemberDAODBImpl;
import edu.ssafy.boot.service.IMemberService;
import edu.ssafy.boot.service.MemberService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/user")
public class RestUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	IMemberService mSer;

	@PostMapping("/loginmem")
	@ApiOperation(value = "로그인서비스")
	private @ResponseBody ResponseEntity<Map<String, Object>> loginMem(@RequestBody MemVo mem) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		
		try {
			boolean res = mSer.loginMem(mem.getId(), mem.getPassword());
			Map<String, Object> map = new HashMap<String, Object>();
			if (res) {
				map.put("resmsg", "로그인");
			} else {
				map.put("resmsg", "아이디와 비밀번호가 일치하지 않음");
			}
			System.out.println(mem.getId()+" "+mem.getPassword());
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "로그인 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}

		return resEntity;
	}

	@PostMapping("/findpw")
	@ApiOperation(value = "비밀번호 찾기")
	private @ResponseBody ResponseEntity<Map<String, Object>> findPw(@RequestBody MemVo mem) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = null;
//		System.out.println(mem.getId()+" "+mem.getQuestion()+" "+mem.getAnswer());
		try {
			MemVo searchMem = mSer.findPw(mem);
			msg = new HashMap<String, Object>();
			if (searchMem != null) {
				msg.put("resmsg", "비밀번호찾기 성공");
				msg.put("mem", searchMem);
			} else {
				msg.put("resmsg", "입력 정보와 일치하는 회원이 없음");
			}
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		} catch (RuntimeException e) {
			msg = new HashMap<String, Object>();
			msg.put("resmsg", "비밀번호찾기 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}

	@PutMapping("/updatemem")
	@ApiOperation(value = "회원정보 수정")
	private ResponseEntity<Map<String, Object>> updateMem(@RequestBody MemVo m) {
//		System.out.println(m);
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			boolean res = mSer.updateMem(m);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "수정성공");
			map.put("resvalue", res);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("resmsg", "수정실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		}
		return resEntity;
//		response.sendRedirect("index.jsp");

	}

//	@RequestMapping("/infomem")
	@GetMapping("/infomem/{currentId}")
	@ApiOperation(value = "회원정보조회", response=MemVo.class)
	private @ResponseBody ResponseEntity<Map<String, Object>> infoMem(@PathVariable("currentId") String id) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		MemVo mem = null;
		try {
			mem = mSer.infoMem(id);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조회성공");
			map.put("resvalue", mem);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조회실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;

	}

	@PostMapping("/signup")
	@ApiOperation(value = "회원가입")
	private @ResponseBody ResponseEntity<Map<String, Object>> signUpMem(@RequestBody MemVo m) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			System.out.println(m);
			boolean signUpMem = mSer.signUpMem(m);
			Map<String, Object> map = new HashMap<String, Object>();
			if (signUpMem)
				map.put("resmsg", "등록성공");
			else
				map.put("resmsg", "1등록실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "등록실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}

}
