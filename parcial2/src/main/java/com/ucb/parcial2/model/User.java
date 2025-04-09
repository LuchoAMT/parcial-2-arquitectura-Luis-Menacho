package com.ucb.parcial2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table( name = "user" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Integer id;

    @Column( name = "name" )
    private String name;

    @Column( name = "last_name" )
    private String last_name;


}
