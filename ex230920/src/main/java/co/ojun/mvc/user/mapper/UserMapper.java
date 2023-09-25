package co.ojun.mvc.user.mapper;

import co.ojun.mvc.user.service.UserVO;

public interface UserMapper {
	public UserVO getUser(String username);
}
