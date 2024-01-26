package com.backend.embackend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeInput {
    
    private long emp_id;
    private String username;
    private String pass;
    private String role;
    private int del_flag;
    private int user_lvl;
}
