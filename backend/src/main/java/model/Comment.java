package model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// some common fields which are identical with Post.java
// can be extracted to a super class which they can inherit from
// but I did not do it here as I do not have much time

@Entity
@Table(name = "comments")
public class Comment {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	Long id;
	
	@Column(name="post_id")
	Long postId;
	
	@Column(name="content")
	String content;
	
	@Column(name="create_date")
	ZonedDateTime createdDate;
	
	@Column(name="create_by")
	String createdBy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
