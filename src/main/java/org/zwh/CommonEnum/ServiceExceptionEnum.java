package org.zwh.CommonEnum;

import lombok.Data;

/**
 * @author zwh
 * @version V1.0
 * @Package org.zwh.CommonEnum
 * @date 2021/12/27 11:38
 */


public enum  ServiceExceptionEnum {
    SUCCESS(0,"成功"),
    ERROR(500,"服务器错误"),
    OTHER(600,"未知错误")
    ;

    private  Integer code;

    private  String message;

    ServiceExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
