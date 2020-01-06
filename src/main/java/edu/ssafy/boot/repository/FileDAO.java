package edu.ssafy.boot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.ssafy.boot.dto.UploadFile;

public interface FileDAO {
    public UploadFile findOneByFileName(String fileName);
	public UploadFile findOne(int fileId);
	public List<UploadFile> findAll();
	public List<UploadFile> findAllById(Iterable<Integer> ids);
	public <S extends UploadFile> List<S> saveAll(Iterable<S> entities);
	public void flush();
	public <S extends UploadFile> S saveAndFlush(S entity) ;
	public void deleteInBatch(Iterable<UploadFile> entities) ;
	public void deleteAllInBatch() ;
	public UploadFile getOne(Integer id) ;
	public <S extends UploadFile> List<S> findAll(Example<S> example) ;
	public <S extends UploadFile> List<S> findAll(Example<S> example, Sort sort) ;
	public Page<UploadFile> findAll(Pageable pageable) ;
	public <S extends UploadFile> S save(S entity) ;
	public Optional<UploadFile> findById(Integer id);
	public boolean existsById(Integer id);
	public long count();
	public void deleteById(Integer id);
	public void delete(UploadFile entity);
	public void deleteAll(Iterable<? extends UploadFile> entities);
	public void deleteAll();
	public <S extends UploadFile> Optional<S> findOne(Example<S> example);
	public <S extends UploadFile> Page<S> findAll(Example<S> example, Pageable pageable) ;
	public <S extends UploadFile> long count(Example<S> example) ;
	public <S extends UploadFile> boolean exists(Example<S> example) ;

}
