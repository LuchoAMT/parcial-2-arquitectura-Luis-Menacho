package com.ucb.parcial2.service;

import com.ucb.parcial2.Command;
import com.ucb.parcial2.IUserRepository;
import com.ucb.parcial2.model.UpdateUserDTO;
import com.ucb.parcial2.model.User;
import com.ucb.parcial2.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UpdateUserService implements Command<UpdateUserDTO, UserDTO> {
    private final IUserRepository iUserRepository;

    UpdateUserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserDTO input) {
        Optional<User> user = iUserRepository.findById(input.getId());
        if(user.isPresent()) {
            user.get().setLast_name(input.getUserDTO().getLast_name());
            user.get().setName(input.getUserDTO().getName());
            return ResponseEntity.ok(new UserDTO(iUserRepository.save(user.get())));
        }
        return ResponseEntity.notFound().build();
    }
}
