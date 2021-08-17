package com.ad.springwebclientjackson.service.reqres;

import com.ad.springwebclientjackson.model.reqres.User;
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
