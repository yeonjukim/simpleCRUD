package test.dazayo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Post {
	@Id
	@GeneratedValue
	int id;
	
	@NotEmpty //빈 값x
	String subject;
	
	@Column(length = 100000000)
	String content;
	
	Date regDate;
	
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
@PrePersist
@PreUpdate//수정한 후 날짜
public void setUpdateDate() {
	this.regDate = new Date();
}
	

	
}
