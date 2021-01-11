package com.deneme.demo.Entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "roles")
class Role {
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long role_id
	
	@Column(name = "role_name")
	private String name
	
	long getRole_id() {
		return role_id
	}
	void setRole_id(long role_id) {
		this.role_id = role_id
	}
	String getName() {
		return name
	}
	void setName(String name) {
		this.name = name
	}

}
