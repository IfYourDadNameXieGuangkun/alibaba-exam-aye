package com.alibaba.validator.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    private Long userId;

    @NotNull
    @Length(min = 2, max = 10)
    private String userName;

    @NotNull
    @Length(min = 6, max = 20)
    private String password;

    @NotNull
    @Length(min = 11,max = 11,message = "phone应必须为11位数字")
    private String phone;


}
