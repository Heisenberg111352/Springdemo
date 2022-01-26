# Springdemo

 ####  全局异常处理

1 定义一个类使用@RestControllerAdvice注解全局捕获spring mvc抛出的异常

2 @ExceptionHandler(value = Exception.class)  此注解的作用是来捕获指定异常

``` java
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
```

3 定义一个ErrorCode接口 用来实现错误信息和错误代码

``` java
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
```

4 定义一个枚举来实现上边的接口

枚举要素  变量, 构造方法 ,get方法

``` java
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

```

 5 定义一个BaseException继承RuntimeException 重写RuntimeException方法

``` java
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
```

6 BizException去继承BaseException。具体内容看下面的实现

``` java
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
```

最后在controller接口层如遇到想要抛出的异常可直接new 这样就返回给前端友好的提示信息也方便问题的排查

``` java
 @GetMapping("/error")
    public Result<?> testError(@RequestParam("id")String id){
        if ("Hello".equals(id)){
            throw new BizException("world", ErrorCodeEnum.DATA_EXISTS_ERROR);
        }

       return Result.ok();
    }
```



