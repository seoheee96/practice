<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
    <h1>게시글 수정 페이지</h1>
    
    <nav>
        <ul>
            <li>
                <a href="../">메인 페이지</a>
            </li>
            <li>
                <a href="main">게시판 메인 페이지</a>
            </li>
            <li>
                <a href="detail?bno=${board.bno}">게시글 상세보기 페이지</a>
            </li>
            <li>
                <a id="menuDelete" href="delete?bno=${board.bno}">삭제</a>
            </li>
        </ul>
    </nav>
    
    <form action="update" method="post">
        <div>
            <label for="bno">글 번호</label>
            <input type="number" id="bno" name="bno"
                value="${board.bno}" readonly />
        </div>
        <div>
            <label for="title">글 제목</label>
            <input type="text" id="title" name="title"
                value="${board.title}" required />
        </div>
        <div>
            <label for="content">내용</label>
            <textarea rows="5" id="content" 
                name="content" required>${board.content}</textarea>
        </div>
        <div>
            <label for="userid">작성자</label>
            <input type="text" id="userid"
                value="${board.userid}" readonly />
        </div>
        <div>
            <label for="reply_cnt">댓글 갯수</label>
            <input type="number" id="reply_cnt"
                value="${board.reply_cnt}" readonly />
        </div>
        <div>
            <label for="reg_date">작성 시간</label>
            <input type="text" id="reg_date"
                value="${board.reg_date}" readonly />
        </div>
        <div>
            <input type="submit" value="수정 완료" />
        </div>
    </form>

    <script>
    $(document).ready(function () {
    	$('#menuDelete').click(function (event) {
    		event.preventDefault();
    		var result = confirm('정말 삭제할까요?');
    		if (result) {
    			location = $(this).attr("href");
    		}
    	});
    	
    });
    </script>
</body>
</html>





