package edu.ssafy.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.boot.repository.IScrapDAO;

@Service("ScrapService")
public class ScrapService implements IScrapService {

	@Autowired
	@Qualifier("ScrapDAOImpl")
	IScrapDAO dao;
}
