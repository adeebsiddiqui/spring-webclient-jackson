package com.ad.springwebclientjackson.model.reqres;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = User.UserBuilder.class)
public class User {

    private Data data;
    private Support support;

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserBuilder {}
}
