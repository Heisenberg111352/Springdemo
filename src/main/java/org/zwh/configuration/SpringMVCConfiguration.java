package org.zwh.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zwh.interceptor.FirstInterceptor;

/**
 * @author zwh
 * @version V1.0
 * @Package org.zwh.configuration
 * @date 2021/12/27 12:03
 */

@Configuration
public class SpringMVCConfiguration implements WebMvcConfigurer {

    /** 对该类实现了HandlerInterceptor进行实例化 */
    @Bean
    public FirstInterceptor firstInterceptor(){
        return new FirstInterceptor();
    }

    /**添加该拦截器 并配置路径 */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.firstInterceptor()).addPathPatterns("/**");
    }
}
