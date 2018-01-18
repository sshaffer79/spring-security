package com.shaffer.security.config;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SaltedPasswordEncoder implements PasswordEncoder{
    @Override
    public String encode(CharSequence rawPassword) {
        return BCrypt.hashpw(String.valueOf(rawPassword), generateSalt());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        Boolean doesMatch = BCrypt.checkpw(String.valueOf(rawPassword), encodedPassword);
        return doesMatch;
    }

    private String generateSalt() {
        return BCrypt.gensalt(12);
    }
}
