package com.ucb.parcial2.service;

import com.ucb.parcial2.Command;
import com.ucb.parcial2.IUserRepository;
import com.ucb.parcial2.model.User;
import com.ucb.parcial2.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<UserDTO, String> {
    private final IUserRepository iUserRepository;

    public CreateUserService(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }

    @Override
    public ResponseEntity<String> execute(UserDTO input) {
        User user = input.toUser();
        int id = iUserRepository.save(user).getId();
        return ResponseEntity.ok(String.format("User %d, created", id));
    }
}
