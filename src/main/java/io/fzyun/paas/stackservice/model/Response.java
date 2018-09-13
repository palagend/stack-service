package io.fzyun.paas.stackservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
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

    public static Response fail(int i, String msg) {
        Response response = new Response();
        response.setStatus(i);
        response.setMessage(msg);
        return response;
    }
}
