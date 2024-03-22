package com.solution.product.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class SecurityConfig {

//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
//	@Bean
//    PasswordEncoder passwordEncoder() {
//        // Use SHA-256 algorithm
//        return new StandardPasswordEncoder();
//    }
	
//	@Bean
//    PasswordEncoder passwordEncoder() {
//        // Use SHA-256 algorithm
//        return new MessageDigestPasswordEncoder("SHA-256");
//    }
	
    @Bean
    PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                try {
                    MessageDigest digest = MessageDigest.getInstance("SHA-256");
                    byte[] hashedBytes = digest.digest(rawPassword.toString().getBytes());
                    StringBuilder stringBuilder = new StringBuilder();
                    for (byte b : hashedBytes) {
                        stringBuilder.append(String.format("%02x", b));
                    }
                    return stringBuilder.toString();
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException("SHA-256 algorithm not available", e);
                }
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encode(rawPassword).equals(encodedPassword);
            }
        };
    }
}

