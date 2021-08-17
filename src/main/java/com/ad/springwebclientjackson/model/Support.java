package com.ad.springwebclientjackson.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Support.SupportBuilder.class)
public class Support {

    private String url;
    private String text;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SupportBuilder {}
}
