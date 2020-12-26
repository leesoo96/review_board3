package com.LSJ.board3.model;

public class BoardSEL extends BoardModel{

	private String nm;
	private int is_thumbsUp;
	
	public int getIs_thumbsUp() {
		return is_thumbsUp;
	}

	public void setIs_thumbsUp(int is_thumbsUp) {
		this.is_thumbsUp = is_thumbsUp;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}
}
