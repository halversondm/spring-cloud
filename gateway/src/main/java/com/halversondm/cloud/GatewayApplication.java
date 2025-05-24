package com.halversondm.cloud;

// import com.halversondm.cloud.filters.pre.SimpleFilter; // Commented out Zuul filter
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
// import org.springframework.cloud.netflix.zuul.EnableZuulProxy; // Commented out Zuul annotation
import org.springframework.context.annotation.Bean;

// @EnableZuulProxy // Commented out Zuul annotation
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    // @Bean // Commented out Zuul filter bean
    // public SimpleFilter simpleFilter() {
    //     return new SimpleFilter();
    // }

}
