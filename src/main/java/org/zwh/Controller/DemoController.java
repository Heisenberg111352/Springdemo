package org.zwh.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zwh.commons.errorenum.ErrorCodeEnum;
import org.zwh.commons.exception.BizException;
import org.zwh.configuration.Result;

/**
 * @author zwh
 * @version V1.0
 * @Package org.zwh.Controller
 * @date 2021/12/27 10:05
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @GetMapping("/a")
    public Object demo(){
        return "Hello";
    }

    @GetMapping("/error")
    public Result<?> testError(@RequestParam("id")String id){
        if ("Hello".equals(id)){
            throw new BizException("world", ErrorCodeEnum.DATA_EXISTS_ERROR);
        }

       return Result.ok();
    }


}
