package com.zzm.programmingedu;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.zzm")
@EnableTransactionManagement
@MapperScan("com.zzm.dao")
public class ProgrammingeduApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgrammingeduApplication.class, args);
    }

}
