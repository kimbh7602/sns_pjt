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

import edu.ssafy.boot.dto.BoardVo;
import edu.ssafy.boot.dto.CommVo;

@Repository("BoardDaoDBImpl")
public class BoardDaoDBImpl implements IBoardDAO{
	
	@Autowired
	SqlSession session;
//	private Connection conn = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
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
	public boolean boardInsert(String user_id, String btitle, String bcontent) {
		boolean res = false;

		System.out.println(user_id + " " + btitle + " " + bcontent);
		int insert = session.insert("ssafy.board.insert",new BoardVo(btitle, bcontent, user_id));
		System.out.println(insert);
		if(insert > 0) {
			return true;
		}else {
			return false;
		}
	}	

	@Override
	public List<BoardVo> boardList() {
		List<BoardVo> list = new ArrayList<BoardVo>();
		return session.selectList("ssafy.board.selectList");
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "select * from board";
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				list.add(new BoardVo(rs.getInt("bid"),rs.getString("btitle"),rs.getString("bcontent"),rs.getInt("bcount"), rs.getString("user_id")));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		
//		return list;
	}

	@Override
	public BoardVo boardInfo(int bid) {
		BoardVo board = session.selectOne("ssafy.board.selectOne",bid);
		System.out.println(board.toString());
		
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "select * from board where bid = ?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, bid);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				board = new BoardVo(rs.getInt("bid"),rs.getString("btitle"),rs.getString("bcontent"),rs.getInt("bcount"), rs.getString("user_id"));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		
		return board;
	}

	@Override
	public boolean boardUpdate(String user_id, int bid, String btitle, String bcontent) {
		// TODO Auto-generated method stub
		boolean res = false;
		
		if(session.update("ssafy.board.update",new BoardVo(bid, btitle, bcontent, user_id))>0)res = true;
		
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "update board set btitle=?, bcontent=? where bid=? and user_id=?";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, btitle);
//			ps.setString(2, bcontent);
//			ps.setInt(3, bid);
//			ps.setString(4, user_id);
//			ps.executeUpdate();
//			res = true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			res = false;
//		}

		
		return res;
	}

	@Override
	public boolean boardDelete(String user_id, int bid) {
		boolean res = false;
	
		
		if(	session.delete("ssafy.board.delete",bid)>0) res = true;
//			conn = ConnectionProxy.getConnection();
//			String sql = "delete from board where bid=? and user_id=?";
//			ps = conn.prepareStatement(sql);
//			System.out.println(bid + " " + user_id);
//			ps.setInt(1, bid);
//			ps.setString(2, user_id);
//			ps.executeUpdate();
			
	
		return res;
	}

	@Override
	public ArrayList<BoardVo> boardSearch(String keyword) {
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		session.selectList("ssafy.board.boardSearch",keyword);
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "select * from board where btitle = LIKE %?% ";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, keyword);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				list.add(new BoardVo(rs.getInt("bid"),rs.getString("btitle"),rs.getString("bcontent"),rs.getInt("bcount"), rs.getString("user_id")));
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
	public boolean countUp(int bid) {
		boolean res = false;
		
		if(session.update("ssafy.board.countUp",bid)>0)res = true;
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "update board set bcount=bcount+1 where bid=?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1,bid);
//			ps.executeUpdate();
//			res = true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			res = false;
//		}
//		
		return res;
	}

	@Override
	public List<CommVo> commList(int bid) {
		List<CommVo> list = session.selectList("ssafy.board.commList", bid);
		return list;
	}

	@Override
	public boolean insertComm(int cid, String ccontent, String user_id, int bid) {
		int insert = session.insert("ssafy.board.insertComm", new CommVo(cid, ccontent, user_id, bid));
		if(insert>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteComm(int cid) {
		int delete = session.delete("ssafy.board.deleteComm", cid);
		if(delete>0) {
			return true;
		}else {
			return false;
		}
	}

}
