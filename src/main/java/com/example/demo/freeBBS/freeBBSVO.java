package com.example.demo.freeBBS;

import java.sql.Date;

import lombok.Data;

@Data
public class freeBBSVO {
	private int num;
	private String title;
	private String content;
	private int hit;
	private Date regDate;
	
}

