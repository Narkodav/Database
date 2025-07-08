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

    @Autowired
    private AuthServiceClient authServiceClient;    

    @GetMapping
    public List<UserData> getUserData(@RequestHeader("Authorization") String token) {
        String username = jwtUtil.extractUsername(token.replace("Bearer ", ""));
        Long userId = authServiceClient.getUserIdByUsername(username, token);
        return dataRepo.findByUserId(userId);
    }

    @PostMapping
    public UserData addData(@RequestBody UserData data, @RequestHeader("Authorization") String token) {
        String username = jwtUtil.extractUsername(token.replace("Bearer ", ""));
        Long userId = authServiceClient.getUserIdByUsername(username, token);
        data.setUserId(userId);
        return dataRepo.save(data);
    }
}
