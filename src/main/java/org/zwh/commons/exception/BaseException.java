package org.zwh.commons.exception;

/**
 * @author zwh
 * @version V1.0
 * @Package exception
 * @date 2022/1/25 16:38
 */
public class BaseException extends RuntimeException {

    public BaseException(){
        super();
    }

    public BaseException(String message){
        super(message);
    }

    public BaseException(String message, Throwable cause){
        super(message, cause);
    }

    public BaseException(Throwable cause){
        super(cause);
    }

    protected BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
