package com.ucb.parcial2.service;


 import com.ucb.parcial2.IUserRepository;
 import com.ucb.parcial2.Query;
 import com.ucb.parcial2.model.User;
 import com.ucb.parcial2.model.UserDTO;
 import org.springframework.http.ResponseEntity;
 import org.springframework.stereotype.Service;

 import java.util.*;

 @Service
public class AllUserService implements Query<Void, List<UserDTO>> {
    private final IUserRepository iUserRepository;
    AllUserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
     public ResponseEntity<List<UserDTO>> execute(Void input) {
        List<User> users = iUserRepository.findAll();
        return ResponseEntity.ok(users.stream().map(UserDTO::new).toList());
    }
}
