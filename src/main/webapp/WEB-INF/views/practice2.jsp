<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../../css/start_page.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="main">
        <h1 class="logo">로그인</h1>
        <div class="container">
            <input type="text" placeholder="ID" id="id" class="account">
            <input type="password" placeholder="Password" id="password" class="account">
            <button id="login" class="account">login</button>
            <p id="alert" class="account"> </p>
            <p>practice</p>
        </div>
    </div>   
    <script src="script.js"></script>
</body>
<form>
    <a href="signup.html" target="_blank" id="register">회원가입</a>
    <a href="findid.html" target="_blank" id="register">아이디 찾기</a>
    <a href="findpassword.html" target="_blank" id="register">비밀번호 찾기</a>
</form>
</html>