package com.example.demo.s1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class dbtestService {
	
	@Autowired
	private dbtestMapper dbTestMapper;
	
	public List<dbtestVO> getList() throws Exception{
		return dbTestMapper.getList();
	}

}
