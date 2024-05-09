//package com.laigeoffer.pmhub.file.config;
//
//import com.laigeoffer.pmhub.base.core.config.PmhubConfig;
//import com.laigeoffer.pmhub.base.core.constant.Constants;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.CacheControl;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * 通用配置
// *
// * @author canghe
// */
//@Configuration
//public class ResourcesConfig implements WebMvcConfigurer {
//    // TODO: 2024.04.28 暂时注释
////    @Resource
////    private RepeatSubmitInterceptor repeatSubmitInterceptor;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        /** 本地文件上传路径 */
//        registry.addResourceHandler(Constants.RESOURCE_PREFIX + "/**")
//                .addResourceLocations("file:" + PmhubConfig.getProfile() + "/");
//
//        /** swagger配置 */
//        registry.addResourceHandler("/swagger-ui/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
//                .setCacheControl(CacheControl.maxAge(5, TimeUnit.HOURS).cachePublic());
//        ;
//    }
//
//    /**
//     * 自定义拦截规则
//     */
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(repeatSubmitInterceptor).addPathPatterns("/**");
////    }
//
////    /**
////     * 跨域配置
////     */
////    @Bean
////    public CorsFilter corsFilter() {
////        CorsConfiguration config = new CorsConfiguration();
////        config.setAllowCredentials(true);
////        // 设置访问源地址
////        config.addAllowedOriginPattern("*");
////        // 设置访问源请求头
////        config.addAllowedHeader("*");
////        // 设置访问源请求方法
////        config.addAllowedMethod("*");
////        // 有效期 1800秒
////        config.setMaxAge(1800L);
////        // 添加映射路径，拦截一切请求
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        source.registerCorsConfiguration("/**", config);
////        // 返回新的CorsFilter
////        return new CorsFilter(source);
////    }
//}