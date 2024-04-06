package in.saurabhit.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.saurabhit.entity.User;
import in.saurabhit.exception.ResourceNotFoundException;
import in.saurabhit.payload.UserDto;
import in.saurabhit.repository.UserRepository;
import in.saurabhit.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto register(UserDto userDto) {
	User user =this.modelMapper.map(userDto, User.class);
	  User savedUser = this.userRepository.save(user);
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public String login(String email, String password) {
	Optional<User> user	=this.userRepository.findByEmailAndPassword(email, password);
	
	if(user!=null) {
		return "Login Success";
	}else
		return "Login Failed";
	}

	
	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
		 User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

	        user.setUserName(userDto.getUserName());
	        user.setEmail(userDto.getEmail());
	        user.setPassword(userDto.getPassword());

	        User savedUser = this.userRepository.save(user);

	        return this.modelMapper.map(savedUser,UserDto.class);
	    
	

	}
}


