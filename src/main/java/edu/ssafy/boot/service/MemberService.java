package edu.ssafy.boot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.boot.dto.MemVo;
import edu.ssafy.boot.repository.IMemberDAO;
import edu.ssafy.boot.repository.MemberDAODBImpl;

@Service
public class MemberService implements IMemberService {
	@Autowired
	IMemberDAO dao;

	public MemberService() {
	}

	@Override
	public boolean loginMem(String id, String password) {
		MemVo mem = dao.memInfo(id);
		boolean res = false;
		if (mem != null) {
			if (mem.getPassword().equals(password)) {
				res = true;
			}
		}
		return res;
	}

	@Override
	public MemVo findPw(MemVo m) {
		MemVo mem = dao.memFind(m);
		return mem;
	}

	@Override
	public boolean signUpMem(MemVo m) {
		boolean res = false;
		if (dao.memInsert(m) > 0) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean updateMem(MemVo m) {
		boolean res = false; 
		System.out.println(m);
		if( dao.memUpdate(m)>0) {
			res = true;
		};
		return res;
	}

	@Override
	public MemVo infoMem(String id) {
		MemVo mem = dao.memInfo(id);
		return mem;
	}

	@Override
	public ArrayList<MemVo> listMem() {
		ArrayList<MemVo> list = (ArrayList<MemVo>) dao.memList();
		return list;
	};
}
