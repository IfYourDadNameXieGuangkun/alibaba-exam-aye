package com.alibaba.validator.controller;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.validator.dto.UserDto;
import com.alibaba.validator.exception.dto.CR;
import com.alibaba.validator.exception.dto.ResultDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class ValidatorController {


    @PostMapping("/save")
    public CR<?> saveUser(@RequestBody @Validated UserDto userDto) {
        System.out.println(JSONObject.toJSONString(userDto));
        return ResultDTO.create();

    }
}
