<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02</title>
</head>
<body>
    <h1>로그인 페이지</h1>
    <form action="signin" method="post">
        <input type="text" name="userid" placeholder="아이디 입력" required />
        <br/>
        <input type="password" name="pwd" placeholder="비밀번호 입력" required />
        <br/>
        <input type="submit" value="로그인" />
        <br/>
        <input type="hidden" name="target" value="${target}" />
    </form>
</body>
</html>




