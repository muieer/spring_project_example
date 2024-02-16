package org.muieer.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Set;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public static final Set<String> ADMIN_USER = Set.of("test", "admin");

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/swagger", "/swagger-ui/index.html");
        registry.addRedirectViewController("/", "/swagger-ui/index.html");
//        registry.addViewController("/").setViewName("index"); todo
    }

    /*
    *  要前端页面后需要对 /swagger-ui.html 路径访问拦截
    * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (true /*|| ADMIN_USER.contains(todo)*/) {
                    return true;
                }
                throw new RuntimeException("无权限访问");
            }
        };
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/swagger-ui.html*");
    }
}
