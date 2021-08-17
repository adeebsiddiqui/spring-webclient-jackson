package com.ad.springwebclientjackson.service;

import com.ad.springwebclientjackson.model.User;
import org.springframework.stereotype.Service;

@Service
public class ReqResService {

    private final ReqResClient reqResClient;

    public ReqResService(ReqResClient reqResClient) {
        this.reqResClient = reqResClient;
    }


    public User getUser(String userId) {
        return reqResClient.sendRequest(userId);
    }
}
