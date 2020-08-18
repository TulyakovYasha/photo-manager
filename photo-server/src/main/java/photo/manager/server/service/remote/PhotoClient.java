package photo.manager.server.service.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import photo.manager.server.config.FeignConfig;
import photo.manager.server.dto.PhotoDto;


@Primary
@FeignClient(value = "photoService", configuration = FeignConfig.class, url = "${agile.server.url}")
public interface PhotoClient {

    @RequestMapping(path = "/images", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    PhotoDto getAllPhoto(@RequestParam(name = "page", required = false) String page, @RequestHeader(value = "Authorization", required = true) String authorizationHeader);
}
