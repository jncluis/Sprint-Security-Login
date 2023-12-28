package pe.edu.utp.service;

import pe.edu.utp.dto.UserDto;
import pe.edu.utp.model.User;

public interface UserService {
	User findByUsername(String username);
	User save(UserDto userDto);
}
