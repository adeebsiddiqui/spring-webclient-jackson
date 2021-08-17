package com.ad.springwebclientjackson.controller;

import com.ad.springwebclientjackson.model.User;
import com.ad.springwebclientjackson.service.ReqResService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/req-res")
public class ReqResController {

    private final ReqResService reqResService;

    public ReqResController(ReqResService reqResService) {
        this.reqResService = reqResService;
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> retrieveUser(@PathVariable String userId) {
        return ResponseEntity.ok(reqResService.getUser(userId));
    }
}
