package org.huha.DDDdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "org.huha.DDDdemo", "com.alibaba.cola" })
@MapperScan("org.huha.DDDdemo.gatewayimpl.database")
public class DddDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddDemoApplication.class, args);
    }

}
