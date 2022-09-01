package com.example.demo.notice;
 
import java.util.List; 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository; 
import com.example.demo.notice.NoticeVO;
import com.fasterxml.jackson.annotation.JacksonInject;
@Repository    // 현재 클래스를 dao bean으로 등록
public class NoticeDAOImpl implements NoticeDAO {
    @JacksonInject
    SqlSession SqlSession;
    // 01. 게시글 작성
    @Override
    public void create(NoticeVO vo) throws Exception {
        SqlSession.insert("notice.insert", vo);
    }
    // 02. 게시글 상세보기
    @Override
    public NoticeVO read(int num) throws Exception {
        return SqlSession.selectOne("notice.view", num);
    }
    // 03. 게시글 수정
    @Override
    public void update(NoticeVO vo) throws Exception {
        SqlSession.update("notice.updateArticle", vo);
 
    }
    // 04. 게시글 삭제
    @Override
    public void delete(int num) throws Exception {
        SqlSession.delete("notice.deleteArticle",num);
 
    }
    // 05. 게시글 전체 목록
    @Override
    public List<NoticeVO> listAll() throws Exception {
        return SqlSession.selectList("notice.listAll");
    }
    // 게시글 조회수 증가
    @Override
    public void increasehit(int num) throws Exception {
        SqlSession.update("notice.increasehit", num);
    }
 
}
