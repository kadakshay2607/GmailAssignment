package com.te.assigmenthibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Account implements Serializable {

	@Id
	@Column (name="user_id")
	private  int uid;
	@Column (name="user_name")
	private String name;
	@Column (name="password")
	private String pass;
	@Column (name="email")
	private String mail;
	
	public Account() {
		super();
	}
	
}
