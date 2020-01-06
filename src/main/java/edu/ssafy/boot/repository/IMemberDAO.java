package edu.ssafy.boot.repository;

import java.util.ArrayList;
import java.util.List;

import edu.ssafy.boot.dto.MemVo;

public interface IMemberDAO {
	public int memInsert(MemVo m);

	public List<MemVo> memList();

	public MemVo memInfo(String id);

	public int memUpdate(MemVo m);

//	public boolean isLogin(String id, String password);
	
	public MemVo memFind(MemVo m);
}
