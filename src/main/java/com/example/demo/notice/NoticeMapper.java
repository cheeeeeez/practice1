package com.example.demo.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.s1.dbtestVO;
import com.example.demo.util.Pager;

@Mapper
public interface NoticeMapper {
	
	public List<NoticeVO> getList(Pager pager) throws Exception; //dbtestVO는 리턴자리다. 뜻을 의미하는 것이 아니고 DBMapper.xml에서 들고오는 것이다.
    public Long getTotalCount(Pager pager) throws Exception;
    public List<NoticeVO> getAdd() throws Exception;
    public int setAdd(NoticeVO noticeVO) throws Exception;
    public NoticeVO getUpdate(NoticeVO noticeVO) throws Exception;
    public int setUpdate(NoticeVO noticeVO) throws Exception;
    public int getDelete(NoticeVO noticeVO) throws Exception;
    public NoticeVO getDetail(NoticeVO noticeVO) throws Exception;
    public int getGtl(NoticeVO noticeVO) throws Exception;
}
