package edu.ssafy.boot.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.NoticeVo;

@Repository("NoticeDaoDBImpl")
public class NoticeDaoDBImpl implements INoticeDAO{
//	private Connection conn = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
	
	@Autowired
	SqlSession session;
	
//	private void close() {
//		
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
	public int noticeInsert(String ntitle, String ncontent) {
		
		return session.insert("ssafy.notice.insert",new NoticeVo(ntitle, ncontent));
//		boolean res = false;
//		
//		session.
//		
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "insert into notice (ntitle, ncontent) values(?,?)";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, ntitle);
//			ps.setString(2, ncontent);
//			ps.executeUpdate();
//			res = true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			res = false;
//		}finally {
//			close();
//		}
//		
//		return res;
//		
		}

	@Override
	public List<NoticeVo> noticeList() {
		
		return session.selectList("ssafy.notice.selectList");
		
//		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "select * from notice";
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				list.add(new NoticeVo(rs.getInt("nid"),rs.getString("ntitle"),rs.getString("ncontent"),rs.getInt("ncount")));
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
	public NoticeVo noticeInfo(int nid) {
		return session.selectOne("ssafy.notice.selectOne",nid);
		
		
//		NoticeVo notice = null;
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "select * from notice where nid = ?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, nid);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				notice = new NoticeVo(rs.getInt("nid"),rs.getString("ntitle"),rs.getString("ncontent"),rs.getInt("ncount"));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		
//		return notice;
	}

	@Override
	public int noticeUpdate(int nid, String ntitle, String ncontent) {

		NoticeVo nv = new  NoticeVo(nid, ntitle, ncontent);
		return session.update("ssafy.notice.update", nv);
//		boolean res = false;
//		
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "update notice set ntitle=?, ncontent=? where nid=?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1,nid);
//			ps.setString(2, ntitle);
//			ps.setString(3, ncontent);
//			ps.executeUpdate();
//			res = true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			res = false;
//		}
//
//		
//		return res;
	}

	@Override
	public int noticeDelete(int nid) {
		return session.delete("ssafy.notice.delete",nid);
	}

	@Override
	public List<NoticeVo> noticeSearch(String keyword) {
		
		return session.selectList("ssafy.notice.noticeSearch",keyword);
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "select * from notice where ntitle = LIKE %?% ";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, keyword);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				list.add(new NoticeVo(rs.getInt("nid"),rs.getString("ntitle"),rs.getString("ncontent"),rs.getInt("ncount")));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		
	}

	@Override
	public int countUp(int nid) {
		
		return session.update("ssafy.notice.countUp",nid);
//		
//		boolean res = false;
//		
//		try {
//			conn = ConnectionProxy.getConnection();
//			String sql = "update notice set ncount=ncount+1 where nid=?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1,nid);
//			ps.executeUpdate();
//			res = true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			res = false;
//		}
//		
//		return res;
	}

}
