<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
</head>
<body>
	<div>
		<form action="/login" method="post">
			<div><input type="text" name="user_id" placeholder="아이디"></div>
			<div><input type="password" name="user_pw" placeholder="비밀번호"></div>
			<div><input type="submit" value="로그인"></div>
		</form>
		<a href="/join">회원가입</a>
	</div>
</body>
</html>