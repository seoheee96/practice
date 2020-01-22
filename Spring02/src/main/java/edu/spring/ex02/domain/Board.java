package edu.spring.ex02.domain;

import java.util.Date;

public class Board {
	// 멤버 변수, 필드(field), 프로퍼티(property)
	// 멤버 변수 이름들을 DB의 컬럼 이름들과 일치 
	// -> MyBatis 프레임워크에서 getter/setter를 찾을 수 있도록 하기 위해서
	private int bno;
	private String title;
	private String content;
	private String userid;
	private Date reg_date;
	private int reply_cnt;
	private String attachment;
	
	public Board() {}

	public Board(int bno, String title, String content, String userid, Date reg_date, int reply_cnt,
			String attachment) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.reg_date = reg_date;
		this.reply_cnt = reply_cnt;
		this.attachment = attachment;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getReply_cnt() {
		return reply_cnt;
	}

	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", userid=" + userid + ", reg_date="
				+ reg_date + ", reply_cnt=" + reply_cnt + ", attachment=" + attachment + "]";
	}

} // end class Board


