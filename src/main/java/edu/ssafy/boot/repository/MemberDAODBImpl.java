package edu.ssafy.boot.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.MemVo;

@Repository
public class MemberDAODBImpl implements IMemberDAO {
//	private Connection conn = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
	@Autowired
	SqlSession session;

//	private void close() {
//			try {
//				if(rs!=null) rs.close();
//				if(conn!=null) conn.close();
//				if(ps!=null) ps.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("DB 닫기 에러");
//			}
//	}
	@Override
	public int memInsert(MemVo m) {
			return session.insert("ssafy.member.insert",m);
	}
	
	@Override
	public List<MemVo> memList() {
		List<MemVo> list = session.selectList("ssafy.memver.selectList");
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "select * from user";
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				list.add(new MemVo(rs.getString("id"), rs.getString("password"), rs.getString("mname"), rs.getString("addr"), rs.getString("tel"), rs.getString("allergy"), rs.getString("question"), rs.getString("answer")));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
		return list;
	}
	@Override
	public MemVo memInfo(String id) {
		MemVo mem = session.selectOne("ssafy.member.selectOne",id);
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "select * from user where id = ?";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, id);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				mem = new MemVo(rs.getString("id"), rs.getString("password"), rs.getString("mname"), rs.getString("addr"), rs.getString("tel"), rs.getString("allergy"), rs.getString("question"), rs.getString("answer"));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		
		return mem;
	}
	@Override
	public int memUpdate(MemVo m) {
//		System.out.println(m);
		
		int res = session.update("ssafy.member.update", m);
		System.out.println("dao=="+res);
//		
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "update user set password=?, mname=?, addr=?, tel=? where id=?";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, password);
//			ps.setString(2, mname);
//			ps.setString(3, addr);
//			ps.setString(4, tel);
//			ps.setString(5, id);
//			System.out.println(id + " " + password);
//			ps.executeUpdate();
//			res = true;
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			res = false;
//		} finally {
//			close();
//		}
//		
		return res;
	}
	
//	
//	@Override
//	public boolean isLogin(String id, String password) {
//		boolean res = session.selectOne(");
////		
////		try {
////			conn = ConnectionProxy.getConnection();
////			String sql = "select * from user where id=? and password=?";
////			ps = conn.prepareStatement(sql);
////			ps.setString(1, id);
////			ps.setString(2, password);
////			rs = ps.executeQuery();
////			rs.last();
////			int row = rs.getRow();
////			if(row >= 1) {
////				res = true;
////			}
////		} catch (SQLException e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			res = false;
////		} finally {
////			close();
////		}
//		
//		return res;
//	}
	@Override
	public MemVo memFind(MemVo mv) {
		MemVo mem = session.selectOne("ssafy.member.findMem",mv);
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "select * from user where id = ? and question = ? and answer = ?";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, id);
//			ps.setString(2, question);
//			ps.setString(3, answer);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				mem = new MemVo(rs.getString("id"), rs.getString("password"), rs.getString("mname"), rs.getString("addr"), rs.getString("tel"), rs.getString("allergy"), rs.getString("question"), rs.getString("answer"));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
		
		return mem;
	}
}
