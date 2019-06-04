package com.anoyi.grpc.client.controller;

import com.anoyi.grpc.facade.entity.UserEntity;
import com.anoyi.grpc.facade.service.UserServiceBySofaHessian;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/grpc/hessian")
public class V1UserController {

    private final UserServiceBySofaHessian userServiceBySofaHessian;

    @PostMapping("/add")
    public UserEntity insertUser(@RequestBody UserEntity userEntity){
        userServiceBySofaHessian.insert(userEntity);
        return userEntity;
    }

    @GetMapping("/list")
    public List<UserEntity> findAllUser(){
        return userServiceBySofaHessian.findAll();
    }

    @PostMapping("/remove")
    public String removeUser(@RequestParam("id") Long id){
        userServiceBySofaHessian.deleteById(id);
        return "success";
    }

}
