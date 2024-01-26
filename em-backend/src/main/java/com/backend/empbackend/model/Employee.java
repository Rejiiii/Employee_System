package com.backend.empbackend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private long emp_id;
    private String username;
    private String pass;
    private String role;
    private int del_flag;

}
