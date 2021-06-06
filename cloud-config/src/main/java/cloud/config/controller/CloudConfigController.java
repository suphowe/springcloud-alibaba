package cloud.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置中心配置获取 @RefreshScope含义为实现配置的热加载
 *
 * @author suphowe
 */
@RestController
@RefreshScope
@Slf4j
public class CloudConfigController {

    @Value("${username:frank}")
    private String username;

    @Value("${address:china}")
    private String address;

    @RequestMapping("/getConfigInfo")
    public String getConfigInfo() {
        return address + ":"+ username;
    }

}
