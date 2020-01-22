<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
    <meta charset="UTF-8" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
    <h1>메인 페이지</h1>
    <hr/>
    <ul>
    <c:if test="${empty signinId}">
        <%-- 로그인 정보가 없는 경우(로그인되어 있지 않은 경우) --%>
        <li>
            <a href="user/signin" id="btnSignIn">로그인</a>
        </li>
    </c:if>
    <c:if test="${not empty signinId}">
        <%-- 로그인 정보가 있는 경우(로그인되어 있는 경우) --%>
        <li>${signinId}님, 환영!
            <a href="user/signout">로그아웃</a>
        </li>
    </c:if>
        <li>
            <a href="board/main">게시판 메인 페이지</a>
        </li>
    </ul>
    
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






