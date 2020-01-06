package edu.ssafy.boot.repository;

import java.util.List;

import edu.ssafy.boot.dto.TakeinFoodVO;
import edu.ssafy.boot.dto.TakeinSumVo;

public interface ITakeinFoodDAO {
	public boolean intakeInsert(int code, String id, int icount);
	public List<TakeinFoodVO> intakeList(String id);
	public TakeinFoodVO intakeInfo(String id,int code);
	public boolean intakeDelete(String id,int code);
	public TakeinSumVo intakeSum(String id);
	public List<TakeinFoodVO> intakeSearch(String id, String keyword);
	
	public List<TakeinFoodVO> yearsort(String selFormat, String id);
	public TakeinSumVo yearsortSum(String selFormat, String id);
	public List<TakeinFoodVO> monthsort(String selFormat, String id);
	public TakeinSumVo monthsortSum(String selFormat, String id);
	public List<TakeinFoodVO> todaysort(String selFormat, String id);
	public TakeinSumVo todaysortSum(String selFormat, String id);
}

