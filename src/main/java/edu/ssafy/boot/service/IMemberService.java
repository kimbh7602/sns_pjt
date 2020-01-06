package edu.ssafy.boot.service;

import java.util.ArrayList;

import edu.ssafy.boot.dto.MemVo;

public interface IMemberService {
	public boolean loginMem(String id, String password);

	public MemVo findPw(MemVo m);
	
	public boolean signUpMem(MemVo m);
	
	public boolean updateMem(MemVo m);

	public MemVo infoMem(String id);

	public ArrayList<MemVo> listMem();


}
