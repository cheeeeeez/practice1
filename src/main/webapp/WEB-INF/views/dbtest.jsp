<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 반복문을 넣어주는거, uri안에는 3번쨰 거 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    rel="stylesheet">
<title>창민갓</title>
</head>
<body>
<div class="row mt-4">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>salary</th>
                    <th>office_worker</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="vo">
                <tr>
                    <td>${vo.id}</td>
                    <td>${vo.name}</td>
                    <td>${vo.salary}</td>
                    <td>${vo.office_worker}</td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</body>

</html>
