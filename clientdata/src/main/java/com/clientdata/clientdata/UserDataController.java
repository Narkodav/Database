package com.clientdata.clientdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class UserDataController {
    @Autowired
    private UserDataRepository dataRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public List<UserData> getUserData(@RequestHeader("Authorization") String token) {
        Long userId = jwtUtil.extractId(token.replace("Bearer ", ""));
        return dataRepo.findByUserId(userId);
    }

    @PostMapping
    public UserData addData(@RequestBody UserData data, @RequestHeader("Authorization") String token) {
        Long userId = jwtUtil.extractId(token.replace("Bearer ", ""));
        data.setUserId(userId);
        return dataRepo.save(data);
    }
}
