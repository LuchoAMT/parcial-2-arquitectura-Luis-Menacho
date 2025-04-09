package com.ucb.parcial2.controller;

import com.ucb.parcial2.model.UpdateUserDTO;
import com.ucb.parcial2.model.UserDTO;
import com.ucb.parcial2.service.AllUserService;
import com.ucb.parcial2.service.CreateUserService;
import com.ucb.parcial2.service.GetUserService;
import com.ucb.parcial2.service.UpdateUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final AllUserService allUserService;
    private final CreateUserService createUserService;
    private final UpdateUserService updateUserService;
    private final GetUserService getUserService;
    UserController(AllUserService allUserService, CreateUserService createUserService, UpdateUserService updateUserService, GetUserService getUserService) {
        this.allUserService = allUserService;
        this.createUserService = createUserService;
        this.updateUserService = updateUserService;
        this.getUserService = getUserService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserDTO userDTO) {
        return this.createUserService.execute(userDTO);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> obtain(@PathVariable Integer id) {
        return this.getUserService.execute(id);
    }
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }
    @PutMapping("{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        return this.updateUserService.execute(new UpdateUserDTO(id, userDTO));
    }

    @GetMapping("all")
    public ResponseEntity<List<UserDTO>> index() {
        return this.allUserService.execute(null);
    }

}