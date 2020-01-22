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
    <h1>게시글 상세보기 페이지</h1>
    
    <nav>
        <ul>
            <li>
                <a href="../">메인 페이지</a>
            </li>
            <li>
                <a href="main">게시판 메인 페이지</a>
            </li>
            <li>
                <a href="update?bno=${board.bno}">수정하기</a>
            </li>
        </ul>
    </nav>
    
    <form>
        <div>
            <label for="bno">글 번호</label>
            <input type="number" id="bno" name="bno"
                value="${board.bno}" readonly />
        </div>
        <div>
            <label for="title">글 제목</label>
            <input type="text" id="title" name="title"
                value="${board.title}" readonly />
        </div>
        <div>
            <label for="content">내용</label>
            <textarea rows="5" id="content" 
                    name="content" readonly>${board.content}</textarea>
        </div>
        <div>
            <label for="userid">작성자</label>
            <input type="text" id="userid" name="userid"
                value="${board.userid}" readonly />
        </div>
        <div>
            <label for="reply_cnt">댓글 갯수</label>
            <input type="number" id="reply_cnt" name="reply_cnt"
                value="${board.reply_cnt}" readonly />
        </div>
        <div>
            <label for="reg_date">작성 시간</label>
            <input type="text" id="reg_date" name="reg_date"
                value="${board.reg_date}" readonly />
        </div>
    </form>
    
    <hr/>
    
    <div>
        <input type="text" name="rtext" id="rtext" placeholder="댓글 입력" />
        <input type="text" name="userid" id="replier" placeholder="아이디 입력" />
        <button id="btnCreateReply">댓글 작성 완료</button>
    </div> <!-- 댓글 입력 폼 -->
    
    <hr/>
    
    <div id="replies">
    </div> <!-- 댓글 리스트 -->
    
    <script>
    $(document).ready(function () {
    	// input[id='bno']에 있는 글번호(bno)를 읽음
    	var bno = $('#bno').val();
    	
    	// 서버에서 해당 게시글 번호(bno)에 달린 모든 댓글 목록을 읽어오는 Ajax 함수 정의
    	function getAllReplies() {
    		$.getJSON('/ex02/replies/all/' + bno, function (data) {
    			//console.log(data);
    			// div[id="replies"] 안에 있는 모든 하위 요소들을 삭제
    			$('#replies').empty();
    			var list = ''; // div의 하위 요소가 될 HTML 코드들
    			
    			// 자바스크립트 배열 data의 원소 갯수만큼 콜백 함수의 내용을 반복
    			$(data).each(function () {
    				// 콜백 함수 내부에서 this: 배열 data의 원소
    				var date = new Date(this.regdate);
    			    var dateString = date.toLocaleDateString() 
    			            + ' ' + date.toLocaleTimeString();
    			    list += '<div class="reply-item">'
    			            + '<input type="text" id="rno" value="'
    			            + this.rno
    			            + '" readonly />'
    			            + '<input type="text" id="rtext" value="'
    			            + this.rtext
    			            + '" />'
    			            + '<input type="text" id="replier" value="'
    			            + this.userid
    			            + '" readonly />'
    			            + '<button class="btnModify">수정</button>'
    			            + '<button class="btnDelete">삭제</button>'
    			            + '</div>';
    			}); // end $.each();
    			
    			$('#replies').html(list);
    		}); // end $.getJSON()
    	} // end getAllReplies()
    	
    	getAllReplies(); // 함수 호출
    	
    	// 버튼에 이벤트 핸들러 등록
    	$('#btnCreateReply').click(function () {
    		// 댓글 내용(input[id="rtext"]의 value)을 읽음
    		var rtext = $('#rtext').val();
    		if (rtext === '') { // 입력된 댓글 내용이 없을 때
    			alert('댓글 내용은 반드시 입력해야 합니다.');
    			$('#rtext').focus(); // input에 포커스를 줌
    			return; // 이벤트 핸들러 종료
    		}
    		
    		var replier = $('#replier').val();
    		if (replier === '') {
    			alert('댓글 작성자 아이디는 반드시 입력해야 합니다.');
    			$('#replier').focus();
    			return;
    		}
    		
    		$.ajax({
    			url: '/ex02/replies',
    			type: 'POST',
    			headers: {
    				'Content-Type': 'application/json',
    				'X-HTTP-Method-Override': 'POST' 
    			},
    			// JSON.stringify({}): JavaScript 객체를 JSON 형식의 문자열로 변환
    			data: JSON.stringify({
    				'bno': bno,
    				'rtext': rtext,
    				'userid': replier
    			}),
    			success: function (result) {
    				console.log(result);
    				getAllReplies();
    			}
    		}); // end $.ajax()
    		
    	}); // end $('#btnCreateReply').click()
    	
    	$('#replies').on('click', '.reply-item .btnModify', function () {
    		// 수정 버튼이 포함된 div 요소에 있는 rno와 rtext를 찾아서 ajax 요청을 보냄
    		// $(this): 수정 버튼
    		// prevAll(): 같은 부모 요소 밑에 있는 HTML 요소들 중에서 자신보다 먼저 나오는 모든 요소
    		var rno = $(this).prevAll('#rno').val();
    		var rtext = $(this).prevAll('#rtext').val();
    		
    		$.ajax({
    			url: '/ex02/replies/'+ rno,
    			type: 'PUT',
    			headers: {
    				'Content-Type': 'application/json',
    				'X-HTTP-Method-Override': 'PUT'
    			},
    			data: JSON.stringify({ 'rtext': rtext }),
    			success: function (data) {
    				console.log(data);
    				if (data === 's') {
    					alert('댓글 수정 성공');
    				    getAllReplies();
    				}
    			}
    		}); // end $.ajax()
    		
    	}); // end $('#replies').on()
    	
    	$('#replies').on('click', '.reply-item .btnDelete', function () {
    		var rno = $(this).prevAll('#rno').val();
    		var result = confirm(rno + '번 댓글을 정말 삭제할까요?');
    		if (result) {
        		$.ajax({
        			url: '/ex02/replies/' + rno,
        			type: 'DELETE',
        			headers: {
        				'Content-Type': 'application/json',
        				'X-HTTP-Method-Override': 'DELETE'
        			},
        			success: function (data) {
        				if (data === 1) {
        					alert('댓글 삭제 성공');
        					getAllReplies();
        				}
        			}
        		}); // end $.ajax();
    		} // end if
    	}); // end $('#replies').on()
    	
    }); // end $(document).ready()
    </script>
    
</body>
</html>





