package org.zwh.commons.errorenum;



/**
 * @author zwh
 * @version V1.0
 * @Package errorenum
 * @date 2022/1/25 16:33
 */
public enum ErrorCodeEnum implements ErrorCode {
    ERROR(-1, "系统发生错误了，请联系管理员解决")

    // 权限

    ,UNAUTHENTICATED_ERROR(1001, "未登录或会话失效了，请重新登陆")
    ,UNAUTHORIZED_ERROR(1002,"权限不足!")

    // 请求

    ,NOT_SUPPORTED_HTTP_METHOD(2001, "请求方法不支持")
    ,HTTP_REQUEST_ERROR(2002, "请求出错, 请重新尝试")
    ,HTTP_REQUEST_PARAM_ERROR(2003, "请求参数校验失败")
    ,HTTP_REQUEST_TOO_FREQUENT(2004, "请求过于频繁，请稍后再试")
    ,DUPLICATE_REQUEST(2005, "请勿重复提交表单")

    // 数据库

    ,EMPTY_RESULT(3001, "查询结果为空")
    ,NOT_SUCH_DATA(3002, "找不到此数据")
    ,INSERT_ERROR(3003, "数据插入失败")
    ,UPDATE_ERROR(3004, "数据更新失败")
    ,DATA_EXISTS_ERROR(3005, "数据已存在")
    ,BATCH_UPDATE_ERROR(3006, "批量更新失败")

    ;




    ErrorCodeEnum(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }

    private final Integer code;
    private final String message;

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
