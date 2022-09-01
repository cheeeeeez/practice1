package com.example.demo.util;

import lombok.Data;

@Data
public class Pager {
	
	private String kind;        //
	private String search;      //
	
	
	private Integer perPage;    //페이지당 보여줄 ROW 갯수 (게시물 숫자라 생각하면 됨)
	private Integer startRow;   //시작번호
	private Integer pn;         //page num
	private Long startNum;      //시작  num
	private Long lastNum;       //마지막 num
	private boolean pre;        // 이전
	private boolean next;       // 다음
	
	public void makeNum(Long totalCount) { //11이 들어있음
		
		Long totalPage = totalCount / this.getPerPage(); //1
		
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		
		Long perBlock = 10L; //block이 아래꺼 (한번에 10페이지씩 뜨게)
		
		Long totalBlock = totalPage / perBlock; //0
		if(totalPage % perBlock !=0) {  //totalPage =2, totalBlock = 1
			totalBlock++;
		}
		
		Long curBlock = this.getPn() /perBlock;   // currentblock = 0
		
		if(this.getPn() % perBlock != 0) {  // curblock =1
			curBlock++;
		}
		this.startNum = (curBlock - 1) * perBlock +1; //1
		this.lastNum = curBlock *perBlock;   //10
		
		if(curBlock > 1) {
			this.pre = true;
		}
		
		if(totalBlock > curBlock) {
			this.next = true;
		}
		
		if(curBlock == totalBlock) {
			this.lastNum = totalPage; //lastnum = 2
		}
		if(totalCount == 0) {
			this.lastNum = 0L;
		}
	}
	
	public void makeRow() {
		this.startRow = (this.getPn() -1) * this.getPerPage();
	}
	
	public Integer getPn() {
		if(this.pn == null || this.pn < 1) {
			this.pn = 1;
		}
		return this.pn;
	}
	
	public Integer getPerPage() {
		if(this.perPage == null || this.perPage < 1) {
			this.perPage = 10;
		}
		return this.perPage;
	}
	
	
	
	
	

}
