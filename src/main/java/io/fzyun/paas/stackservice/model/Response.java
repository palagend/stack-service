package io.fzyun.paas.stackservice.model;

import lombok.Data;

@Data
public class Response {
    int status;
    String message;
    Object data;

    public static Response success(Object obj) {
        Response response = new Response();
        response.setStatus(0);
        response.setMessage("success");
        response.setData(obj);
        return response;
    }
}
