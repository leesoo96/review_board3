<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<link rel="stylesheet" href="/res/css/bList.css">
<div>
	<div id="tableWrap">
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list }" var="item">
			<tr class="pointer" onclick="clickCtntUrl(${typ }, ${item.i_board });">
				<td>${item.i_board}</td>
				<td>${item.title}</td>
				<td>${item.r_dt}</td>
				<td>${item.hits }</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	<div>
		<a href="bRegmod?typ=${typ }"><button>WRITE</button></a>
	</div>
	
	<div class="pageContainer">
		<c:forEach begin="1" end="${pageCnt }" var="i">
			<span class="page">
				<a href="/bList?typ=${typ }&page=${i}">${i }</a>
			</span>
		</c:forEach>
	</div>
</div>
