//package org.zwh.configuration;
//
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
///**
// * @author zwh
// * @version V1.0
// * @Package org.zwh.configuration
// * @date 2021/12/27 11:24
// */
//@ControllerAdvice(basePackages = "org.zwh.configuration.Result")
//public class GlobalResponseBodyHandler implements ResponseBodyAdvice {
//    public boolean supports(MethodParameter methodParameter, Class aClass) {
//        return true;
//    }
//
//    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        if (o instanceof Result){
//            return o;
//        }
//    return Result.ok();
//    }
//}
