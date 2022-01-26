package org.zwh.commons.errorenum;

import java.io.Serializable;

/**
 * @author zwh
 * @version V1.0
 * @Package errorenum
 * @date 2022/1/25 16:30
 */
public interface ErrorCode extends Serializable {

    /**
     * 错误代码
     * @return
     * */
    Integer getCode();

    /**
     * 友好提醒
     * @return
     * */
    String getMessage();
}
