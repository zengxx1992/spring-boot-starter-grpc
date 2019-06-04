package com.anoyi.grpc.server.service;

import com.anoyi.grpc.facade.entity.UserEntity;
import com.anoyi.grpc.facade.service.UserServiceBySofaHessian;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class UserServiceBySofaHessianImpl implements UserServiceBySofaHessian {

    /**
     * 模拟数据库存储用户信息
     */
    private Map<Long, UserEntity> userMap = new ConcurrentHashMap<>();

    @Override
    public void insert(UserEntity userEntity) {
        if (userEntity == null){
            log.warn("insert user fail, userEntity is null!");
            return ;
        }
        userMap.putIfAbsent(userEntity.getId(), userEntity);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null){
            log.warn("delete user fail, id is null!");
        }
        userMap.remove(id);
    }

    @Override
    public List<UserEntity> findAll() {
        log.info("load balance....");
        UserEntity userEntity = new UserEntity();
        userEntity.setName("SofaHessian");
        userMap.put(1L, userEntity);
        Collection<UserEntity> values = userMap.values();
        return new ArrayList<>(values);
    }

}
