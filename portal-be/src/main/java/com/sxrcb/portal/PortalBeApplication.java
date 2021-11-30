package com.sxrcb.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@MapperScan("com.sxrcb.portal.mapper")
@EnableOpenApi
public class PortalBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalBeApplication.class, args);
    }

}
