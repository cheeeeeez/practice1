package com.example.demo.notice;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.Pager;
import com.example.demo.util.fileManager;
import com.example.demo.notice.NoticeVO;
import com.example.demo.s1.dbtestVO;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private fileManager fileManager;
	
	public List<NoticeVO> getList(Pager pager) throws Exception{
		pager.makeRow();
		pager.makeNum(noticeMapper.getTotalCount(pager)); //여기에 줄 개수 넣어주는거
		return noticeMapper.getList(pager);
	}
	public List<NoticeVO> getAdd() throws Exception{
		return noticeMapper.getAdd();
	}
	public int setAdd(NoticeVO noticeVO, MultipartFile file) throws Exception{
		
		int result = noticeMapper.setAdd(noticeVO); //multi 파일 추가
		
		if(file != null && result >0) {  //file이 null이아니고 결과가 0이 아니어야 한다. 그래서 파일을 하나이상 추가할때! 조건문임
			//1. File을 HDD에 저장
			String fileName = fileManager.fileSave(file, "resources/upload/notice/"); //이 파일 주소로 사진을 업데이트 한다.
			System.out.println(fileName);
			//2. 저장된 정보를 DB에 저장
			NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
			Long num = Long.valueOf(noticeVO.getNum());   //타입 같게 만들면 쓸필요없음
			noticeFilesVO.setNoticeNum(num);
			noticeFilesVO.setFileName(fileName);  //파일이름 넣어주기
			noticeFilesVO.setOriName(file.getOriginalFilename()); //오리지널파일이름 꺼내오기
			result = noticeMapper.setFileAdd(noticeFilesVO);  //형식 그대로 들고가서 add하기
			
			if(result < 1) {
				//notice table insert한 것도 rollback
				throw new SQLException();
			}
			
		}
		
		return result;
	}
	public NoticeVO getDetail(NoticeVO chang) throws Exception{  //받아오는 값은 변수타입과 변수명을 적어줘야된다. 변수명은 아무거나 해줘도 된다.
		return noticeMapper.getDetail(chang);                    //여기 2개는 일치시켜줘야 함!
	}
	public NoticeVO getUpdate(NoticeVO lee) throws Exception{
		return noticeMapper.getUpdate(lee);  //여기걸 getDetail로 쓰고 xml 파일의 38부터 54라인까지 지워도 된다.(라인절약)
	}
	public int getGtl(NoticeVO noticeVO) throws Exception{
		int result = noticeMapper.getGtl(noticeVO); //java에서 페이지 처리를 한 방법
		result = result / 10 +1;
		System.out.println(result);
		return result;				
	}
	public int setUpdate(NoticeVO noticeVO) throws Exception{
		return noticeMapper.setUpdate(noticeVO);
	}
	public int getDelete(NoticeVO noticeVO) throws Exception{
		return noticeMapper.getDelete(noticeVO);
	}

}
