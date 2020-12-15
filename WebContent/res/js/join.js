function joinConfirm(){
	var frm = document.querySelector('#joinFrm');
	var userId = frm.user_id;
	
	var regExpUserId =  /^[A-Za-z0-9+]*$/;
	if(!regExpUserId.test(userId.value)){
		alert('아이디에 한글은 사용할 수 없습니다.');
		userId.focus();
		return false;
	}
	
	var pw = frm.user_pw;
	var pw_Confirm = frm.user_pw_chk;
	if(pw.value !== pw_Confirm.value){
		alert('비밀번호가 다릅니다.');
		pw_Confirm.focus();
		return false;
	}
	
	var name = frm.nm;
	var nameConfirm = /^[가-힣]*$/;
	if(!nameConfirm.test(name.value)){
		alert('성함에는 한글만 사용할 수 있습니다.');
		name.focus();
		return false;
	}
}