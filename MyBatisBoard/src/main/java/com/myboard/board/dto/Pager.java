package com.myboard.board.dto;

import lombok.Data;

@Data
public class Pager {
	private int page; //현재 페이지
	private int size; //한페이지에 나오는 게시글 수
	private int bsize; // 한블록당 나오는 페이지 수
	
	private int rows; //모든 게시글 수
	private int pages; // 모든 페이지 수
	private int blocks; //모든 블록 수
	
	private int block; //현재 블록
	private int bspage; // 현재 블록의 시작페이지
	private int bepage; // 현재 블록의 끝 페이지
	public Pager(int page, int size, int bsize, int rows) {
		this.page = page;
		this.size = size;
		this.bsize = bsize;
		this.rows = rows;
		
		pages = (int) Math.ceil((double) this.rows / this.size);
		blocks = (int) Math.ceil((double) pages / this.bsize);
		
		block = (int) Math.ceil((double) this.page / this.bsize);
		bepage = block * this.bsize;
		bspage = bepage - this.bsize + 1;
	}
	
	public static int seekOffset(int page, int size) {
		if (page > 0) {
			return (page - 1) * size;
		}
		return 0;
	}
	
	public static int seekStart(int page, int size) {
		return ((page - 1) * size) + 1;
	}
	
	public static int seekEnd(int page, int size) {
		return page * size;
	}
	
	
	
	
}
