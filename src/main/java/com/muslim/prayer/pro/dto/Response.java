package com.muslim.prayer.pro.dto;

import com.muslim.prayer.pro.constants.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : pinghongju
 * @description : response
 * @date : 2022/7/20 16:54
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response<T> {
    private int code;
    private String msg;
    private T data;

    public Response<T> getSuccess(T data) {
        this.setData(data);
        this.setCode(ResponseCode.SUCCESS);
        return this;
    }

    public Response<T> getFail() {
        this.setMsg("System error.");
        this.setCode(ResponseCode.SYSTEM_ERROR);
        return this;
    }

    public Response<T> getNotExistFail(String msg){
        this.setMsg(msg);
        this.setCode(ResponseCode.RESOURCE_NOT_EXIST);
        return this;
    }
}
