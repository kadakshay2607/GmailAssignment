package com.te.assigmenthibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Inbox implements Serializable {
	
	@Id
	@Column (name="message_id")
	private  int id;
	@Column (name="user_id")
	private  int uid;
	@Column (name="message")
	private String mess;
	
	public Inbox() {
		super();
	}
	
	

}
