package com.ucb.parcial2.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UpdateUserDTO {
    private final Integer id;
    private UserDTO userDTO;
}
