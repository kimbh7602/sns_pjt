package edu.ssafy.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.boot.dto.TakeinFoodVO;
import edu.ssafy.boot.dto.TakeinSumVo;
import edu.ssafy.boot.repository.ITakeinFoodDAO;

@Service("TakeinFoodService")
public class TakeinFoodService implements ITakeinFoodService {
	@Autowired
	@Qualifier("TakeinFoodDAOImpl")
	ITakeinFoodDAO dao;
	
	public TakeinFoodService() {}
	@Override
	public List<TakeinFoodVO> intakeList(String id) {
		List<TakeinFoodVO> list = dao.intakeList(id);
		return list;
	}
	
	@Override
	public boolean intakeInsert(int code, String id, int icount) {
		boolean res = dao.intakeInsert(code, id, icount);
		return res;
	}
	
	@Override
	public TakeinFoodVO intakeInfo(String id, int code) {
		TakeinFoodVO ifood = dao.intakeInfo(id, code);
		return ifood;
	}
	
	@Override
	public boolean intakeDelete(String id, int code) {
		boolean res = dao.intakeDelete(id, code);
		return res;
	}
	@Override
	public TakeinSumVo intakeSum(String id) {
		TakeinSumVo sum = dao.intakeSum(id);
		return sum;
	}
	@Override
	public List<TakeinFoodVO> intakeSearch(String id, String keyword) {
		List<TakeinFoodVO> list = dao.intakeSearch(id, keyword);
		return list;
	}
	@Override
	public List<TakeinFoodVO> yearsort(String selFormat, String id) {
		
		return dao.yearsort(selFormat, id);
	}
	@Override
	public TakeinSumVo yearsortSum(String selFormat, String id) {
		// TODO Auto-generated method stub
		return dao.yearsortSum(selFormat, id);
	}
	@Override
	public List<TakeinFoodVO> monthsort(String selFormat, String id) {
		// TODO Auto-generated method stub
		return dao.monthsort(selFormat, id);
	}
	@Override
	public TakeinSumVo monthsortSum(String selFormat, String id) {
		// TODO Auto-generated method stub
		return dao.monthsortSum(selFormat, id);
	}
	@Override
	public List<TakeinFoodVO> todaysort(String selFormat, String id) {
		// TODO Auto-generated method stub
		return dao.todaysort(selFormat, id);
	}
	@Override
	public TakeinSumVo todaysortSum(String selFormat, String id) {
		// TODO Auto-generated method stub
		return dao.todaysortSum(selFormat, id);
	}
}
