package hexlet.code.service;

import hexlet.code.dto.UserCreateDTO;
import hexlet.code.dto.UserDTO;
import hexlet.code.dto.UserUpdateDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO findById(Long id);
    void create(UserDetails userData);
    UserDTO create(UserCreateDTO userData);
    UserDTO update(Long id, UserUpdateDTO userUpdateDTO);
    void delete(Long id);
}

