package com.muslim.prayer.pro.dto;

import com.muslim.prayer.pro.constants.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author : XXX
 * @description : XXX
 * @date : 2022/7/20 16:54
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Response<T> {
    private int code;
    private String msg;
    private T data;

    public Response<T> getSuccess(T data) {
        Response<T> response = new Response<T>();
        response.setData(data);
        response.setCode(ResponseCode.SUCCESS);
        return response;
    }

    public Response<T> getInvalidParam() {
        Response<T> response = new Response<T>();
        response.setMsg("Invalid param.");
        response.setCode(ResponseCode.INVALID_PARAM);
        return response;
    }

    public Response<T> getFail() {
        Response<T> response = new Response<T>();
        response.setMsg("System error.");
        response.setCode(ResponseCode.SYSTEM_ERROR);
        return response;
    }

    public Response<T> getNotExistFail(String msg){
        Response<T> response = new Response<T>();
        response.setMsg(msg);
        response.setCode(ResponseCode.RESOURCE_NOT_EXIST);
        return response;
    }
}
