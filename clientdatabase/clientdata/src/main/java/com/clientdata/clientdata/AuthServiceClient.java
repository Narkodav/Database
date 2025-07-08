package com.clientdata.clientdata;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name = "authentificator", url = "http://localhost:8081")
public interface AuthServiceClient {
    @GetMapping("/auth/user/{username}")
    Long getUserIdByUsername(@PathVariable String username, @RequestHeader("Authorization") String token);
}
