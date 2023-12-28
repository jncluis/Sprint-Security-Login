package pe.edu.utp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.utp.dto.UserDto;
import pe.edu.utp.model.User;
import pe.edu.utp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	PasswordEncoder passwordEncoder;
	private UserRepository userRepository; 
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getUsername(),
				passwordEncoder.encode(userDto.getPassword()),
				userDto.getFirstName(),userDto.getLastName(),
				userDto.getEmail());
		return userRepository.save(user);
	}
	
}
