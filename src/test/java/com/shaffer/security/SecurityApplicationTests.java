package com.shaffer.security;

import com.shaffer.security.config.SaltedPasswordEncoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityApplicationTests {
	@Test
	public void contextLoads() {
	}

	@Test
	public void testEncoder() {
		String password = "password";
		SaltedPasswordEncoder encoder = new SaltedPasswordEncoder();
		String encodedPassword = encoder.encode("password");

		System.out.println("Encoded password " + encodedPassword);
	}
}
