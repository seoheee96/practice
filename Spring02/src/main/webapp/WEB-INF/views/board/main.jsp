<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
    <h1>게시판 메인 페이지</h1>
    
    <nav>
        <ul>
        <c:if test="${empty signinId}">
            <%-- 로그인되어 있지 않은 경우 --%>
            <li>
                <a href="../user/signin" id="btnSignIn">로그인</a>
            </li>
        </c:if>
        <c:if test="${not empty signinId}">
            <%-- 로그인되어 있는 경우 --%>
            <li>${signinId}님.
                <a href="../user/signout">로그아웃</a>
            </li>
        </c:if>
            <li>
                <a href="../">메인 페이지</a>
            </li>
            <li>
                <a href="insert">새 글 작성하기</a>
            </li>
        </ul>
    </nav>
    
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성시간</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.bno}</td>
                <td>
                    <a href="detail?bno=${board.bno}">${board.title}</a> [${board.reply_cnt}]
                </td>
                <td>${board.userid}</td>
                <fmt:formatDate value="${board.reg_date}"
                    pattern="yyyy-MM-dd HH:mm" var="reg_date"/>
                <td>${reg_date}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

    <script>
    $(document).ready(function () {
    	$('#btnSignIn').click(function (event) {
    		// 로그인 버튼(링크)를 클릭했을 때 페이지가 이동되는 기본 동작을 막음.
    		event.preventDefault();
    		location = encodeURI('/ex02/user/signin?target=' 
    				+ location.href);
    	});
    	
    }); // end $(document).ready()
    </script>
</body>
</html>






