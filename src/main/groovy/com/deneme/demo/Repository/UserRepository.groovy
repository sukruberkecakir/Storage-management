package com.deneme.demo.Repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

import com.deneme.demo.Entity.User

interface UserRepository extends JpaRepository<User, Long>{
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email)
	@Query("SELECT u FROM User u WHERE u.userName = :username")
	User getUserByUsername(@Param("username")String userName)
}

