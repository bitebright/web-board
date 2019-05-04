package model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

// some common fields which are identical with Comment.java
// can be extracted to a super class which they can inherit from
// but I did not do it here as I do not have much time

@Entity
@Table(name = "posts")
public class Post {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
		
	@Transient
	int numberOfComments;
	
	@Column(name="create_date")
	ZonedDateTime createdDate;
	
	@Column(name="create_by")
	String createdBy;
	
	@Column(name="content")
	String content;
	
	@Transient
	ZonedDateTime lastCommentDate;
	
	public ZonedDateTime getLastCommentDate() {
		return lastCommentDate;
	}
	public void setLastCommentDate(ZonedDateTime lastCommentDate) {
		this.lastCommentDate = lastCommentDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumberOfComments() {
		return numberOfComments;
	}
	public void setNumberOfComments(int numberOfComments) {
		this.numberOfComments = numberOfComments;
	}
	public ZonedDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(ZonedDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
