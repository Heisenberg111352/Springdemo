package org.zwh.commons.exception;


import org.zwh.commons.errorenum.ErrorCode;
import org.zwh.commons.errorenum.ErrorCodeEnum;

/**
 * @author zwh
 * @version V1.0
 * @Package exception
 * @date 2022/1/25 16:41
 */
public class BizException extends BaseException {
    protected ErrorCode errorCode;

    public ErrorCode getErrorCode(){
        return errorCode;
    }

    /**最终都调用这里 */
    public BizException(String message, ErrorCode errorCode, Throwable throwable){
            super(message,throwable);
            this.errorCode=errorCode;
    }




    public BizException(String message) {
        this(message, ErrorCodeEnum.ERROR,null);
    }

   public BizException(ErrorCode errorCode){
        this(errorCode.getMessage(),errorCode,null);
   }

   public BizException(String message, ErrorCode errorCode){
        this(message,errorCode,null);
   }

    public BizException(ErrorCode errorCode, Throwable throwable) {
        this(errorCode.getMessage(), errorCode, throwable);
        this.errorCode = errorCode;
    }


}
