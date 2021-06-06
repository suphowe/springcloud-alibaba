package cloud.provider.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Consumer 调用生产者
 * @author suphowe
 * FeignServiceFallBack 降级 当服务宕机返回给页面的处理异常
 */
@FeignClient(name="cloud-config", fallbackFactory = FeignServiceFallBack.class)
public interface ProviderFeign {

    /*路径和方法名称必须与生产者一样，不然没有办法调用*/
    @GetMapping("/getConfigInfo")
    String getConfigInfo();
}
