package com.ucb.parcial2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private final int id;
    private final String name;
    private final String last_name;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.last_name = user.getLast_name();
    }

    public User toUser() {
        var user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setLast_name(this.last_name);
        return user;
    }
}
