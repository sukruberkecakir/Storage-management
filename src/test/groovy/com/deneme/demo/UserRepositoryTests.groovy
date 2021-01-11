package com.deneme.demo

import static org.assertj.core.api.Assertions.assertThat

import com.deneme.demo.Entity.User
import com.deneme.demo.Repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.annotation.Rollback

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserRepositoryTests {
	@Autowired
	private TestEntityManager entityManager
	
	@Autowired
	private UserRepository repos
	
	@Test
	public void testCreateUser() {
		User user = new User()
		user.setUserName("asdw")
		user.setEmail("sukru123@gmail.com")
		user.setPassword("sukru432121")
		user.setFirstName("sukru23")
		user.setLastName("cakirss")
		 
		User savedUser = repos.save(user)
				 
		User existUser = entityManager.find(User.class, savedUser.getUser_id())
		 
		assertThat(user.getEmail()).isEqualTo(existUser.getEmail())
		 
	}
}

