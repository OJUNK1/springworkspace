package co.ojun.mvc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.ojun.mvc.user.mapper.UserMapper;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserVO userVO = userMapper.getUser(username);

		if (userVO == null) {
			throw new UsernameNotFoundException("No User");
		}
		return userVO;
	}

}
