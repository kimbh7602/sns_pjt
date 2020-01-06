package edu.ssafy.boot.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.TakeinFoodVO;
import edu.ssafy.boot.dto.TakeinSumVo;

@Repository("TakeinFoodDAOImpl")
public class TakeinFoodDAOImpl implements ITakeinFoodDAO {
	@Autowired
	SqlSession session;
	
	@Override
	public boolean intakeInsert(int code, String id, int icount) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("id", id);
		map.put("icount", icount);
		int ex = 0;
		List<TakeinFoodVO> list = session.selectList("ssafy.intake.selectIcount", map);
		if(list.size() == 0) {
			ex = session.insert("ssafy.intake.insert", map);
		}else {
			ex = session.insert("ssafy.intake.updateIcountUp", map);
		}
			
		if(ex > 0) {
			return true;
		}else {
			return false;
		}
			
	}

	@Override
	public List<TakeinFoodVO> intakeList(String id) {
		List<TakeinFoodVO> list = session.selectList("ssafy.intake.selectList", id);
//		List<TakeinFoodVO> list = new List<TakeinFoodVO>();
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "select f.*, i.id, i.idate, i.icount from food as f join intake as i on (f.code = i.code) where i.id=? and icount>0";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1,id);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				list.add(new TakeinFoodVO(rs.getInt("code"), rs.getString("id"), rs.getString("idate"), rs.getInt("icount"), rs.getString("name"), rs.getDouble("supportpereat"), rs.getDouble("calory"), rs.getDouble("carbo"), rs.getDouble("protein")
//						, rs.getDouble("fat"), rs.getDouble("sugar"), rs.getDouble("natrium"), rs.getDouble("chole"), rs.getDouble("fattyacid"), rs.getDouble("transfat")
//						, rs.getString("maker"), rs.getString("material"), rs.getString("img"), rs.getString("allergy"), rs.getInt("searchCount")));	
//		}
//			} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
		
		return list;
	}

	@Override
	public TakeinFoodVO intakeInfo(String id,int code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("id", id);
		TakeinFoodVO ifood = session.selectOne("ssafy.intake.selectOne", map);
		return ifood;
	}

	
	@Override
	public boolean intakeDelete(String id,int code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("id", id);
		TakeinFoodVO food = session.selectOne("ssafy.intake.selectDeleteIcount", map);
		int ex = 0;
		if(food.getIcount() > 0) {
			ex = session.update("ssafy.intake.updateIcountDown", map);
		}
		if(ex > 0) {
			return true;
		}else {
			return false;
		}

			
	}
	@Override
	public TakeinSumVo intakeSum(String id) {
		TakeinSumVo sum = session.selectOne("ssafy.intake.selectIntakeSum", id);
		return sum;
	}
	@Override
	public List<TakeinFoodVO> intakeSearch(String id, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("keyword", keyword);
		List<TakeinFoodVO> list = session.selectList("ssafy.intake.selectSearch", map);
		
		return list;
	}

	@Override
	public List<TakeinFoodVO> yearsort(String selFormat, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selFormat", selFormat);
		map.put("id", id);
		List<TakeinFoodVO> list = session.selectList("ssafy.intake.yearsort", map);
		return list;
	}

	@Override
	public TakeinSumVo yearsortSum(String selFormat, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selFormat", selFormat);
		map.put("id", id);
		TakeinSumVo sum = session.selectOne("yearsortSum", map);
		return sum;
	}

	@Override
	public List<TakeinFoodVO> monthsort(String selFormat, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selFormat", selFormat);
		map.put("id", id);
		List<TakeinFoodVO> list = session.selectList("ssafy.intake.monthsort", map);
		return list;
	}

	@Override
	public TakeinSumVo monthsortSum(String selFormat, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selFormat", selFormat);
		map.put("id", id);
		TakeinSumVo sum = session.selectOne("monthsortSum", map);
		return sum;
	}

	@Override
	public List<TakeinFoodVO> todaysort(String selFormat, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selFormat", selFormat);
		map.put("id", id);
		List<TakeinFoodVO> list = session.selectList("ssafy.intake.todaysort", map);
		return list;
	}

	@Override
	public TakeinSumVo todaysortSum(String selFormat, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selFormat", selFormat);
		map.put("id", id);
		TakeinSumVo sum = session.selectOne("todaysortSum", map);
		return sum;
	}

	
	
}
