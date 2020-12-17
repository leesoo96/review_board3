// 글 번호 클릭 시 url로 이동
function clickCtntUrl(typ, i_board){
	var url = `/bDeatil?typ=${typ}&i_board=${i_board}`;
	location.href = url;
}

// 제목 혹은 내용이 비어있을 경우 알림메시지
function chk(){
	if(chkEmptyEle(frm.title, '제목') || chkEmptyEle(frm.ctnt, '내용')){
			return false;
	}
}