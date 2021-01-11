package com.deneme.demo.Entity

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

import groovy.transform.PackageScope

@Entity
@Table(name = "users")
class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id
	
	@Column(name = "user_name", nullable = false, unique = true, length = 40)
	@PackageScope String userName
	
	@Column(nullable = false, unique = true, length = 45)
	private String email
	
	@Column(nullable = false, length = 64)
	private String password
	
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName
	
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>()

	Set<Role> getRoles() {
		return roles
	}

	void setRoles(Set<Role> roles) {
		this.roles = roles
	}

	long getUser_id() {
		return user_id
	}

	void setUser_id(long user_id) {
		this.user_id = user_id
	}

	String getUserName() {
		return userName
	}

	void setUserName(String userName) {
		this.userName = userName
	}

	String getEmail() {
		return email
	}

	void setEmail(String email) {
		this.email = email
	}

	String getPassword() {
		return password
	}

	void setPassword(String password) {
		this.password = password
	}

	String getFirstName() {
		return firstName
	}

	void setFirstName(String firstName) {
		this.firstName = firstName
	}

	String getLastName() {
		return lastName
	}

	void setLastName(String lastName) {
		this.lastName = lastName
	}
	
	
}