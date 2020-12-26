// 글 번호 클릭 시 url로 이동
function clickCtntUrl(i_board){
	var url = `bDetail?i_board=${i_board}`;
	location.href = url;
}

// 글 작성 시 비속어 유무 체크 -> 현재 사용X
function chk(){
	if(chkEmptyEle(frm.title, '제목') || chkEmptyEle(frm.ctnt, '내용')){
			return false;
	}
}

// 글 삭제
function delConfirm(i_board, typ){
	if(confirm('정말 삭제하시겠습니까?')){
		location.href = `bDel?i_board=${i_board}&typ=${typ}`;	
	}
}

// 댓글 삭제
function delCmtConfirm(i_cmt, i_board) {
	if(confirm('정말 삭제하시겠습니까?')){
		location.href = `cmt/del?i_cmt=${i_cmt}&i_board=${i_board}`;	
	}
}

// 댓글 수정버튼 이벤트
function cmtMod(i_cmt){
	var modFrm = document.querySelector('#mod_'+i_cmt);
	modFrm.classList.remove('cmtFrm');	
}
function cmtModClose(i_cmt){
	var modFrm = document.querySelector('#mod_'+i_cmt);
	modFrm.classList.add('cmtFrm');
}

// 좋아요
function toggle_thumbsUp(i_board){
	var thumbs = document.querySelector('#thumbsUp');
	var state = thumbs.getAttribute('is_thumbsUp');
	console.log('state = ' + state);
	// 좋아요X - 0 / 좋아요O - 1
	
	state = 1 - state;
	
	// get 방식으로 ajax 통신
	axios.get('/board/ajax_thumbsUp', {
		params : {
			state: state,
			i_board : i_board
		}
	}).then(function(res){
		console.log('res = ' + res);
		
		if(res.data.result == 1){
			var thumbsUp = state == 1 ? 'fas' : 'far';
			
			thumbs.innerHTML = `<i class="${thumbsUp} fa-thumbs-up"></i>`;
			thumbs.setAttribute('is_thumbsUp', state);
		}else {
			alert('에러 발생');
		}
	}).catch(function(err){
		console.log('에러 발생 : ' + err);
	})
}