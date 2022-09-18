<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:700px;
}
h1 {
   text-align: center;
}
</style>
 
</head>
<body>
  <div class="container">
    <div class="row">
     <h1>수정하기</h1>
     <form method=post action="./update">
      <input type="hidden" name=num size=50 value="${VO.num }"> <!-- hidden은 감춰주고 파라미터로 넘어감, disabled는 수정을 못하게 함, 파라미터로 넘어가지도 않음 -->
      <%-- <input readonly="readonly" name=hit size=50 value="${VO.num }"> -파라미터는 넘어옴
      <input disabled name=num1 size=50 value="${VO.num }"> --%>
     <table class="table">
       
       <tr>
        <th class="text-right danger" width=15%>제목</th>
        <td width=85%>
          <input type=text name=title size=50 value="${VO.title }">
        </td>
       </tr>
       
       <tr>
        <th class="text-right danger" width=15%>내용</th>
        <td width=85%>
          <textarea rows="8" cols="55" name=content id=contents>${VO.content }</textarea>
        </td>
       </tr>
       <tr>
               <td colspan="2" class="text-foot">
                <div class="row mb-4">
                <div>
                    <label for="files" class="col-sm-2 col-form-label">File</label>
                  
               </div>                
                    <div class="col-sm-10">                   
                        <%-- <img src="../resources/upload/notice/${VO.noticeFilesVO.fileName}"> 
                        얘는 이미지를 띄우는 것--%>
                        <input value="${VO.noticeFilesVO.oriName }">
                        <button type="button" class="btn btn-danger" id="fileDelete" data-num="${VO.noticeFilesVO.fileNum}" data-name="${VO.noticeFilesVO.fileName}">삭제</button>
                        <input type="file" name="file" class="form-control" id="files">                                              
                    </div>
                </div>
            </td>
           </tr>
           
       <tr>
        <td colspan="2" class="text-center">
          <input type=submit value="수정">
          <input type=button value="취소" onclick="javascript:history.back()">
        </td>
       </tr>
     </table>
     </form>
    </div>
  </div>
  <c:import url="../temp/summerNote_script.jsp"></c:import>
  <script src="../resources/js/notice_update.js"></script>
</body>
</html>
