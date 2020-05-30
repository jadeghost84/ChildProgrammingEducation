package com.zzm.config;



import com.zzm.interceptor.SessionInterceptor;
import com.zzm.interceptor.AdminIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class MvcConfiguration implements WebMvcConfigurer {
    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**").excludePathPatterns("/js/**","/css/**","/images/**","/*.html","/","/error");
        registry.addInterceptor(new AdminIntercepter()).addPathPatterns("/admin/**").excludePathPatterns("/admin/login.html","/admin");
    }
    //视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("classpath:static/index.html");
        registry.addViewController("/login").setViewName("classpath:static/login.html");
        registry.addViewController("/register").setViewName("classpath:static/register.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    //跨域设置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//配置允许跨域的路径
                .allowedOrigins("*")//配置允许访问的跨域资源的请求域名
                .allowedMethods("PUT","POST","GET","DELETE","OPTIONS")//配置允许访问该跨域资源服务器的请求方法，如：POST、GET、PUT、DELETE等
                .allowedHeaders("*"); //配置允许请求header的访问，如 ：X-TOKEN

    }



}