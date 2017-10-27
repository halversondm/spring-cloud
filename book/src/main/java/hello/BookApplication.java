package hello;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class BookApplication {

    @Autowired
    EurekaClient discoveryClient;

    @RequestMapping(value = "/available")
    public String available() {
        return "Spring in action";
    }

    @RequestMapping(value = "/checked-out")
    public String checkedOut() {
        return "Spring Boot in Action";
    }

    @RequestMapping(value = "/findGateway")
    public String findGateway() {
        InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("gateway", false);
        return instanceInfo.getHomePageUrl();
    }

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

}
