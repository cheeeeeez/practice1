package com.example.demo.freeBBS;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.util.Pager;

@Mapper
public interface freeBBSMapper {
	
	public List<freeBBSVO> getList(Pager pager) throws Exception; 
    public Long getTotalCount(Pager pager) throws Exception;
    public List<freeBBSVO> getAdd() throws Exception;
    public int setAdd(freeBBSVO freeBBSVO) throws Exception;
    public freeBBSVO getUpdate(freeBBSVO freeBBSVO) throws Exception;
    public int setUpdate(freeBBSVO freeBBSVO) throws Exception;
    public int getDelete(freeBBSVO freeBBSVO) throws Exception;
    public freeBBSVO getDetail(freeBBSVO freeBBSVO) throws Exception;
}
