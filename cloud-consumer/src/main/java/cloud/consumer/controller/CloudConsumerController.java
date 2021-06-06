package cloud.consumer.controller;

import cloud.consumer.feign.ConsumerFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CloudConsumerController {

    @Autowired
    ConsumerFeign consumerFeign;

    @GetMapping("/getAllUser")
    public String getAllUser(){
        log.info("消费者查找所有用户");
        return consumerFeign.getAllUser();
    }

    @GetMapping("/getSingleUser")
    public String getSingleUser(Integer id){
        log.info("消费者查找用户id:{}", id);
        return consumerFeign.getSingleUser(id);
    }

    @GetMapping("/getSingleUserByName")
    public String getSingleUserByName(String name){
        log.info("消费者查找用户name:{}", name);
        return consumerFeign.getSingleUserByName(name);
    }

    @GetMapping("/getCloudConfig")
    public String getCloudConfig(){
        String config = consumerFeign.getCloudConfig();
        log.info("获取配置中心配置:{}", config);
        return config;
    }


}
