package in.saurabhit.service;

import in.saurabhit.payload.UserDto;

public interface UserService {
	
	
	UserDto register(UserDto userDto);
	
	String login(String email,String password);
	
	UserDto updateUser(UserDto userDto,String userId);

}
