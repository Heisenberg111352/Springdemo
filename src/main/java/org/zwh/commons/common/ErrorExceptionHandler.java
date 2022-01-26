package org.zwh.commons.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zwh.commons.errorenum.ErrorCode;
import org.zwh.commons.exception.BizException;
import org.zwh.configuration.Result;


/**
 * @author zwh
 * @version V1.0
 * @Package commons
 * @date 2022/1/25 16:15
 */
@RestControllerAdvice
@Slf4j
public class ErrorExceptionHandler {

    @ExceptionHandler(BizException.class)
    public Result<?> bizException(BizException e){
        ErrorCode errorCode = e.getErrorCode();
        log.warn(e.getMessage()+errorCode.getCode());
        return Result.error(e.getMessage(),e.getErrorCode().getCode());
    }

}
