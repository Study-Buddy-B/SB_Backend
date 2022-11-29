package com.buddy.study.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
  @Bean
  public GroupedOpenApi accountApi() {
    return GroupedOpenApi.builder()
        .group("계정 관련 API")
        .pathsToMatch("/api/v1/account/**")
        .build();
  }
  @Bean
  public GroupedOpenApi userApi() {
    return GroupedOpenApi.builder()
        .group("사용자 관련 API")
        .pathsToMatch("/api/v1/users/**")
        .build();
  }
  @Bean
  public GroupedOpenApi groupApi() {
    return GroupedOpenApi.builder()
        .group("그룹 관련 API")
        .pathsToMatch("/api/v1/group/**")
        .build();
  }
  @Bean
  public GroupedOpenApi temperatureApi() {
    return GroupedOpenApi.builder()
        .group("온도 관련 API")
        .pathsToMatch("/api/v1/temperature/**")
        .build();
  }
  @Bean
  public GroupedOpenApi timeApi() {
    return GroupedOpenApi.builder()
        .group("시간 관련 API")
        .pathsToMatch("/api/v1/time/**")
        .build();
  }
  @Bean
  public GroupedOpenApi postureApi() {
    return GroupedOpenApi.builder()
        .group("자세 관련 API")
        .pathsToMatch("/api/v1/posture/**")
        .build();
  }
  @Bean
  public OpenAPI springOpenAPI(){
    return new OpenAPI()
        .info(new Info().title("스터디버디 스웨거")
            .description("API 명세서입니다!!!!"));
  }
}