<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/res/css/bDetail.css">

<div id="ctntWrap">
	<a href="list?typ=${data.typ}">목록으로 돌아가기</a>

	<div>
	번호 : ${data.seq} 조회수 : ${data.hits }<br/>
	작성자 : ${data.nm } 제목 : ${data.title } <br/>
	내용 : ${data.ctnt } <br/>
	작성날짜 : ${data.r_dt } <br/>
	</div>

<c:if test="${data.i_user == loginUser.i_user }">
	<a href="bRegmod?i_board=${data.i_board}">
		<button>수정하기</button>
	</a>
	<button onclick="delConfrim(${data.i_board}, ${data.typ});">
		삭제하기
	</button>
</c:if>

	<div style="margin-top: 10px;">
		<div>
			<form action="/cmt" method="post">
				<input type="hidden" name="typ" value="${data.typ }">
				<input type="hidden" name="i_board" value="${data.i_board }">
				댓글 : <input type="text" name="cmt_ctnt">
				<input type="submit" value="댓글 쓰기">
			</form>
		</div>
	
		<div style="margin-top: 10px;">
		<table>
			<tr>
				<th>[댓글 목록]</th>
			</tr>
			<c:forEach items="${cmtCtnt }" var="cmt">
				<tr>
					<td>${cmt.ctnt }</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
</div>