package edu.ssafy.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.boot.service.IScrapService;

@CrossOrigin(origins="*")
@RestController()
@RequestMapping("/api/scrap")
public class ScrapController {

	@Autowired
	@Qualifier("ScrapService")
	IScrapService ser;
}
