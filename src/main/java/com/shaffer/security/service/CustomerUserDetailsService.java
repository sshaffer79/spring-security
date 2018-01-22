package com.shaffer.security.service;

import com.shaffer.security.model.CustomerUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class CustomerUserDetailsService implements UserDetailsService {
    @Value("${security.userByUsername.sql}")
    private String sql;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<CustomerUserDetails> userList = jdbcTemplate.query(sql,
                new Object[] { username },
                (rs, rownumber) -> {
                    CustomerUserDetails details = new CustomerUserDetails();
                    details.setUserName(rs.getString("user_name"));
                    details.setPassword(rs.getString("password"));
                    details.setEnabled(rs.getInt("active") == 1 ? true : false);
                    return details;
                });

        if (userList.isEmpty()) {
            throw new UsernameNotFoundException("User not found for " + username);
        }

        return userList.get(0);
    }
}
