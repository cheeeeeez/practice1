package com.example.demo.notice;

import java.sql.Date;

import lombok.Data;

@Data
public class NoticeVO {
	private int num;
	private String title;
	private String content;
	private int hit;
	private Date regDate;
	private NoticeFilesVO noticeFilesVO; // join한걸 속성처럼 받아준다.
}

