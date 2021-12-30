package org.zwh.Exception;

import org.zwh.CommonEnum.ServiceExceptionEnum;

/**
 * @author zwh
 * @version V1.0
 * @Package org.zwh.Exception
 * @date 2021/12/27 11:42
 */
public final class ServiceException extends RuntimeException {
    private final Integer code;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        super(serviceExceptionEnum.getMessage());
        this.code=serviceExceptionEnum.getCode();

    }



}
