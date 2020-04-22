package com.learning.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private String status;
    private String message;

    public Response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response() {

    }
    public Response(String message) {
        this.message = message;
    }

    public Response successResponse() {
        return new Response("202","SUCCESS");
    }
    public Response failResponse() {
        Response response = new Response("402","ERROR at " + this.message);
        return response;
    }
}
