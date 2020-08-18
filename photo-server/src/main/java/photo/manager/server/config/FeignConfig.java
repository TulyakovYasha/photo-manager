package photo.manager.server.config;

import feign.Logger;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@RefreshScope
@Configuration
@EnableFeignClients(basePackages = {"photo.manager.server"})
@ImportAutoConfiguration(FeignAutoConfiguration.class)
public class FeignConfig {
    @Profile("TraceHttpCalls")
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
