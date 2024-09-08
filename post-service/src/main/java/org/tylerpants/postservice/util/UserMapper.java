package org.tylerpants.postservice.util;

import org.springframework.stereotype.Component;
import org.tylerpants.postservice.dto.UserDTO;
import org.tylerpants.postservice.model.User;

import java.time.LocalDateTime;

@Component
public class UserMapper implements DtoMapper<UserDTO, User> {
    @Override
    public UserDTO toDto(User model) {
        return new UserDTO(model.getUsername(), model.getPassword());
    }

    @Override
    public User toModel(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        // Пароль должен быть зашифрованным здесь!!!
        user.setPassword(dto.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}
