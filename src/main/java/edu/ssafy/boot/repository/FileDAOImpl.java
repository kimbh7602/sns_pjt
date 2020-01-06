package edu.ssafy.boot.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.UploadFile;

@Repository("FileDAOImpl")
public class FileDAOImpl implements FileDAO {

	@Autowired
	SqlSession session;
	
	@Override
	public UploadFile findOneByFileName(String fileName) {
		UploadFile file = session.selectOne("ssafy.uploadfile.selectOneByFileName",fileName);
//		System.out.println("findOneByFileName  ===="+ file.getFileid());
		return file;
	}

	@Override
	public UploadFile findOne(int fileId) {
		UploadFile file = session.selectOne("ssafy.uploadfile.selectOne",fileId);
		return file;
	}

	@Override
	public List<UploadFile> findAll() {
		
		return session.selectList("ssafy.uploadfile.selectList");
	}

	@Override
	public List<UploadFile> findAllById(Iterable<Integer> ids) {
		
		return null;
	}

	@Override
	public <S extends UploadFile> List<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public void flush() {
		
	}

	@Override
	public <S extends UploadFile> S saveAndFlush(S entity) {
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<UploadFile> entities) {
		
	}

	@Override
	public void deleteAllInBatch() {
		
	}

	@Override
	public UploadFile getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UploadFile> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UploadFile> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UploadFile> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UploadFile save(UploadFile entity) {	
		System.out.println(entity);
		int insert = session.insert("ssafy.uploadfile.insert",entity);
		if(insert>0) {
			return findOneByFileName(entity.getFileName());
		}
		else return null;
	}

	@Override
	public Optional<UploadFile> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UploadFile entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends UploadFile> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends UploadFile> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UploadFile> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UploadFile> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends UploadFile> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}


}
