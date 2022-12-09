package com.example.onlinecompaintreport_backend.controller;

import com.example.onlinecompaintreport_backend.dao.OnlineDao;
import com.example.onlinecompaintreport_backend.model.OnlineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Onlinecomplaintcontroller {

    @Autowired
    private OnlineDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public Map<String,String>AddUser(@RequestBody OnlineUser o)
    {
        System.out.println(o.getName().toString());
        System.out.println(o.getAddress().toString());
        System.out.println(o.getEmail().toString());
        System.out.println(o.getPhone());
        System.out.println(o.getUsername().toString());
        System.out.println(o.getPassword().toString());
        System.out.println(o.getConfirm().toString());
        dao.save(o);
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public Map<String,String> UserLogin(@RequestBody OnlineUser o)
    {
        String email=o.getEmail().toString();
        String password=o.getPassword().toString();
        System.out.println(email);
        System.out.println(password);
        List<OnlineUser> result=(List<OnlineUser>) dao.UserLogin(o.getEmail(),o.getPassword());
        HashMap<String,String> map=new HashMap<>();
        if(result.size()==0)
        {
            map.put("status","failed");
        }
        else{
            int id=result.get(0).getId();
            map.put("userId",String.valueOf(id));
            map.put("status","success");
        }
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/view",consumes = "application/json",produces = "application/json")
    public List<OnlineUser> UserById(@RequestBody OnlineUser o)
    {
        String id=String.valueOf(o.getId());
        System.out.println(id);
        return (List<OnlineUser>) dao.UserById(o.getId());
    }
}
