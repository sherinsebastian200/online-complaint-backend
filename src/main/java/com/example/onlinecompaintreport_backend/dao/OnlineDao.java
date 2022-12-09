package com.example.onlinecompaintreport_backend.dao;

import com.example.onlinecompaintreport_backend.model.OnlineUser;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OnlineDao extends CrudRepository <OnlineUser,Integer> {

    @Query(value = "SELECT `id`, `address`, `confirm`, `email`, `name`, `password`, `phone`, `username` FROM `userdetails` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
    List<OnlineUser> UserLogin(@Param("email") String email, @Param("password") String password);


    @Query(value = "SELECT `id`, `address`, `confirm`, `email`, `name`, `password`, `phone`, `username` FROM `userdetails` WHERE `id`=:id",nativeQuery = true)
    List<OnlineUser> UserById(@Param("id") Integer id);
}

