package cloud.provider.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 降级服务处理结果
 *
 * @author suphowe
 */
@Slf4j
@Component
public class FeignServiceFallBack implements FallbackFactory<ProviderFeign> {

    @Override
    public ProviderFeign create(Throwable throwable) {
        return new ProviderFeign() {

            @Override
            public String getConfigInfo() {
                log.info("配置中心cloud-config服务被降级停用了");
                return "配置中心cloud-config服务被降级停用了";
            }

        };
    }
}
