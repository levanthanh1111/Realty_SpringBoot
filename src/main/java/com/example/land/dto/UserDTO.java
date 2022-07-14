package com.example.land.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    /*private LocalDateTime createdAt;
    private String password;
    private LocalDateTime updatedAt;
    private String username;
    private Boolean status;*/

}
