package com.example.petstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
// 여러 설정을 제공하는 WebMvcConfigurer를 implements한 클래스 WebConfig 생성
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/pets")
        .allowedOrigins("http://localhost:8081");
  }
}