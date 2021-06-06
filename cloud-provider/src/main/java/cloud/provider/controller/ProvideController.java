package cloud.provider.controller;

import cloud.provider.feign.ProviderFeign;
import cloud.provider.service.UserService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProvideController {

    @Autowired
    UserService userService;

    @Autowired
    ProviderFeign providerFeign;

    @GetMapping("/getAllUser")
    public String getAllUser(){
        log.info("查询所有用户");
        return new Gson().toJson(userService.getAllUsers());
    }

    @GetMapping("/getSingleUser")
    public String getSingleUser(Integer id){
        log.info("查询用户{}", id);
        return new Gson().toJson(userService.getSingleUser(id));
    }

    @GetMapping("/getSingleUserByName")
    public String getSingleUserByName(String name){
        log.info("查询用户{}", name);
        return new Gson().toJson(userService.getSingleUserByName(name));
    }

    @GetMapping("/getCloudConfig")
    public String getCloudConfig(){
        String cloudConfig = providerFeign.getConfigInfo();
        log.info("获取配置中心配置{}", cloudConfig);
        return cloudConfig;
    }
}
