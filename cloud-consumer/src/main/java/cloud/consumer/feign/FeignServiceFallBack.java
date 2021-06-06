package cloud.consumer.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 降级服务处理结果
 * @author suphowe
 */
@Slf4j
@Component
public class FeignServiceFallBack implements FallbackFactory<ConsumerFeign> {

    @Override
    public ConsumerFeign create(Throwable throwable) {
        return new ConsumerFeign() {

            @Override
            public String getAllUser() {
                return "生产者cloud-provider服务被降级停用了";
            }

            @Override
            public String getSingleUser(Integer id) {
                return "生产者cloud-provider服务被降级停用了";
            }

            @Override
            public String getSingleUserByName(String name) {
                return "生产者cloud-provider服务被降级停用了";
            }

            @Override
            public String getCloudConfig() {
                return "生产者cloud-provider服务被降级停用了";
            }
        };
    }
}
