<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="/bDetail" method="post" onsubmit="return delConfirm();">
	<div>
	번호 : ${data.i_board} / 조회수 : ${data.hits }<br/>
	제목 : ${data.title } <br/>
	내용 : ${data.ctnt } <br/>
	작성날짜 : ${data.r_dt } <br/>
	
	<input type="hidden" name="typ" value="${data.typ }">
	<input type="hidden" name="i_board" value="${data.i_board }">
	<input type="submit" value="삭제하기">
	</div>
</form>
<a href="/bRegmod?typ=${data.typ}&i_board=${data.i_board}">
	<button>수정하기</button>
</a>
<a href="/bList?typ=${data.typ}">돌아가기</a>


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