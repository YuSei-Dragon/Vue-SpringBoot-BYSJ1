package com.springboot.form;

import lombok.Data;

@Data
public class ChangepasswordForm {
    private String username;
    private String oldpassword;
    private String newpassword;
}
