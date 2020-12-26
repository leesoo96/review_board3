<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/res/css/bDetail.css?var=5">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

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
	<button onclick="delConfirm(${data.i_board}, ${data.typ});">
		삭제하기
	</button>
</c:if>

	<div style="margin-top: 10px;">
		<div>
			<form action="cmt/reg" method="post">
				<input type="hidden" name="typ" value="${data.typ }">
				<input type="hidden" name="i_board" value="${data.i_board }">
				댓글 : <input type="text" name="ctnt">
				<input type="submit" value="댓글 쓰기">
			</form>
		</div>
		
			<div style="margin-top: 10px;">
				<strong>[댓글목록]</strong>
				<table class="cmtTable">
					<tr>
						<td>작성자</td>
						<td>댓글</td>
						<td>댓글작성시간</td>
					</tr>
				<c:forEach items="${cmtCtnt }" var="cmt">
					<tr>
						<td>${cmt.user_nm }</td>
						<td>${cmt.ctnt }</td>
						<td>${cmt.r_dt }</td>
						<td>
						<c:if test="${cmt.i_user == loginUser.i_user }">
							<button onclick="cmtMod(${cmt.i_cmt});">수정</button>
							<button onclick="delCmtConfirm(${cmt.i_cmt}, ${data.i_board });">삭제</button>
						</c:if>
						</td>
					</tr>
					
					<c:if test="${cmt.i_user == loginUser.i_user }">
						<tr id="mod_${cmt.i_cmt }" class="cmtFrm">
							<td colspan="4">
								<form action="cmt/mod" method="post">
									<input type="hidden" name="i_board" value="${data.i_board }" />
									<input type="hidden" name="i_cmt" value="${cmt.i_cmt }" /> 
									<input type="text" name="ctnt" value="${cmt.ctnt }" />
									<input type="submit" value="수정" />
									<button type="button" onclick="cmtModClose(${cmt.i_cmt });">닫기</button>
								</form>
							</td>
						</tr>
					</c:if>
				</c:forEach>
				</table>
			</div>
	</div>                            <!-- BoardSEL -->
	<div id="thumbsUp" is_thumbsUp="${data.is_thumbsUp }"
	     onclick="toggle_thumbsUp(${data.i_board});">
		<c:choose>
			<c:when test="${data.is_thumbsUp == 1 }">
				<!-- 좋아요 누름 -->
				<i class="fas fa-thumbs-up"></i>
			</c:when>
			<c:otherwise> <!-- == 0 좋아요 해제 -->
				<i class="far fa-thumbs-up"></i>
			</c:otherwise>
		</c:choose>
	</div>
</div>

