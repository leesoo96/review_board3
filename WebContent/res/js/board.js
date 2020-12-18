// 글 번호 클릭 시 url로 이동
function clickCtntUrl(i_board){
	var url = `/bDeatil?i_board=${i_board}`;
	location.href = url;
}

// 글 작성 시 비속어 유무 체크 -> 현재 사용X
function chk(){
	if(chkEmptyEle(frm.title, '제목') || chkEmptyEle(frm.ctnt, '내용')){
			return false;
	}
}