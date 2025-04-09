package com.ucb.parcial2.service;

import com.ucb.parcial2.IUserRepository;
import com.ucb.parcial2.Query;
import com.ucb.parcial2.model.User;
import com.ucb.parcial2.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GetUserService implements Query<Integer, UserDTO> {
    private final IUserRepository iUserRepository;

    public GetUserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(Integer id) {
        Optional<User> user = this.iUserRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user.map(UserDTO::new).get());
        }
        return null;
    }
}
