<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
    .container {
        position:relative;
        height: 1002px;
        margin-top:100px;
        padding: 51px 0 0;
        line-height: 170%;
        margin-left:50px;
        margin-right:50px;
        background: yellowgreen;

    }
    .mimage {
        position:relative;
        height: 600px;
        margin-left:80px;
        margin-right:80px;
        background:skyblue;
        line-height: 170%;
        
    }
    .leftinfo {
        position:relative;
        height: 300px;
        width: 350px;
        margin-left:80px;
        margin-top:50px;
        display:inline-block;
        background:violet;

    }
    .middleinfo {
        position:relative;
        height: 300px;
        width: 350px;
        margin-left:80px;
        margin-top:50px;
        display:inline-block;
        background:violet;

    }
    .rightinfo {
        position:relative;
        height: 300px;
        width: 300px;
        margin-left:80px;
        margin-top:50px;
        display:inline-block;
        background:violet;
    }
    .ri1 {
        position:relative;
        height: 200px;
        width: 300px;
        background:red;
    }
    .ri2 {
        position:relative;
        height: 70px;
        margin-top:30px;
        width: 300px;
        background:red;
    }
    
</style>
</head>

<body>
    <c:import url="./temp/header.jsp"></c:import>
    
    <div class="container">
        <div class="mimage">
    


        </div>
        <div class="leftinfo">

        </div>
        <div class="middleinfo">

        </div>
        <div class="rightinfo">
            <div class="ri1">

            </div>
            <div class="ri2">

            </div>

        </div>
    </div>
   



</body>
</html>