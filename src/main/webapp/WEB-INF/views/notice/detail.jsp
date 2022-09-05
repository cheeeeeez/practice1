<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:1000px;
}
h1 {
   text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
$(function(){
    $('.upBtn').click(function(){
        $('.update').hide();
        let no=$(this).attr("data-no");
        if(i==0)
        {
            $(this).text("취소");
            $('#reply_up'+no).show();
            i=1;
        }
        else
        {
            $(this).text("수정");
            $('#reply_up'+no).hide();
            i=0;
        }
    });
});
</script>
</head>
<body>
   <div class="container">
     <div class="row">
      <h1>내용보기</h1>
      <table class="table table-striped">
        <tr>
          <th width=20% class="text-center danger">번호</th>
          <td width=30% class="text-center">${VO.num}</td>
          <th width=20% class="text-center danger">작성일</th>
          <td width=30% class="text-center"> 
            <fmt:formatDate value="${VO.regDate }" pattern="yyyy-MM-dd"/>
          </td>
        </tr>
        <tr>
          <th width=20% class="text-center danger">제목</th>
          <td width=30% class="text-center">${VO.title }</td>
          <th width=20% class="text-center danger">조회수</th>
          <td width=30% class="text-center">${VO.hit }</td>
        </tr>
        
        <tr>
          <td colspan="4" class="text-left" valign="top" height=200>
            ${VO.content} 
          </td>
          <td>
          <c:if test="${VO.noticeFilesVO.fileName !=null}">  <!-- 조건문을 걸어서 이미지가 없더라도 이미지 없다고 창이 안뜬다. -->
          <img src="../resources/upload/notice/${VO.noticeFilesVO.fileName}"> <!-- webinf view가 없어져서 1번만 뒤로가면 된다. -->
          </c:if>
          </td>
        </tr>
        
        <tr>
          <td colspan="4" class="text-right">
            <a href="./update?num=${VO.num}" class="btn btn-sm btn-success">수정</a>
            <a href="./delete?num=${VO.num}" class="btn btn-sm btn-info">삭제</a> <!-- 현재의 폴더에서가 점 슬래시다. -->
            <a href="./gtl?num=${VO.num}" class="btn btn-sm btn-warning">목록</a>
          </td>
        </tr>
      </table>
     </div>
     <div class="row">
       <%-- 분석 결과 출력  --%>
       <div class="col-sm-6">
       </div>
       <div class="col-sm-6"></div>
     </div>
   </div>
</body>
</html>
