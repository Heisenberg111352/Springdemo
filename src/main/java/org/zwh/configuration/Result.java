package org.zwh.configuration;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zwh
 * @version V1.0
 * @Package org.zwh.configuration
 * @date 2021/12/27 10:51
 */

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean success = true;

    private String message = "操作成功！";

    private Integer code = 0;

    private T result;

    private long timestamp = System.currentTimeMillis();

    public Result() {

    }

    public Result<T> success(String message){
        this.message=message;
        this.code=200;
        this.success=true;
        return this;

    }

    public static Result<Object> ok(){
        Result<Object> result = new Result<Object>();
        result.setMessage("成功");
        result.setCode(200);
        result.setSuccess(true);
        return result;

    }

    public static Result<Object> ok(String message){
        Result<Object> result = new Result<Object>();
        result.setMessage(message);
        result.setCode(200);
        result.setSuccess(true);
        return result;
    }

//    public  static Result<Object> ok(Object data){
//        Result<Object> result = new Result<Object>();
//        result.setResult(data);
//        result.setCode(200);
//        result.setSuccess(true);
//        return result;
//
//    }

    public static<T> Result<T> ok(T data){
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(200);
        r.setResult(data);
        return r;
    }

    public static<T> Result<T> ok(String message,T data){
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage(message);
        r.setResult(data);
        return r;
    }

    public static Result<Object> error(String message,Integer code){
        Result<Object> result = new Result<Object>();
        result.setMessage(message);
        result.setCode(code);
        result.setSuccess(false);
        return  result;

    }


}
