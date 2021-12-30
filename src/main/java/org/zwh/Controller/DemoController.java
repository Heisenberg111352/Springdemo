package org.zwh.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwh
 * @version V1.0
 * @Package org.zwh.Controller
 * @date 2021/12/27 10:05
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/a")
    public Object demo(){

        return "Hello";
    }

    @GetMapping("/error")
    public Object errors(){
        return 1 / 0;
    }
}
