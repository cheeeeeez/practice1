package com.example.demo.notice;
 
import java.util.List;
 
import com.example.demo.notice.NoticeVO;
 
public interface NoticeDAO {
    // 01. 게시글 작성
    public void create(NoticeVO vo) throws Exception;
    // 02. 게시글 상세보기
    public NoticeVO read(int num) throws Exception;
    // 03. 게시글 수정
    public void update(NoticeVO vo) throws Exception;
    // 04. 게시글 삭제
    public void delete(int num) throws Exception;
    // 05. 게시글 전체 목록
    public List<NoticeVO> listAll() throws Exception;
    // 06. 게시글 조회 증가
    public void increasehit(int num) throws Exception;
}
