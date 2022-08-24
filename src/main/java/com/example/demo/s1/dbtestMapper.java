package com.example.demo.s1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface dbtestMapper {
	
	public List<dbtestVO> getList() throws Exception; //dbtestVO는 리턴자리다. 뜻을 의미하는 것이 아니고 DBMapper.xml에서 들고오는 것이다.

}
