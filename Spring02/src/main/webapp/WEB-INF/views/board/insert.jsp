<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02</title>
</head>
<body>
    <h1>새 글 작성 페이지</h1>
    
    <form action="insert" method="post">
        <input type="text" name="title" placeholder="제목 입력" required />
        <br/>
        <textarea rows="5" name="content" placeholder="내용 입력" required></textarea>
        <br/>
        <input type="text" name="userid" placeholder="${signinId}" readonly />
        <br/>
        <input type="submit" value="작성 완료" />
    </form>
    
</body>
</html>





