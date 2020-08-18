package photo.manager.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@SwaggerDefinition(info = @Info(version = "1.0.0", title = "The Photo API."), produces = {"application/json"},
        schemes = {SwaggerDefinition.Scheme.HTTPS})
@Api(produces = "application/json", protocols = "https", tags = "Photo API",
        value = "API for photo fetching")
@RequestMapping(path = "/photo")
public interface PhotoApi {

    @RequestMapping(path = "/images", method = RequestMethod.GET)
    ResponseEntity<Void> getPhoto(@RequestParam(name = "page", required = false) String page, @RequestHeader(name = "Authorization") String token);

    @RequestMapping(path = "/images/{id}", method = RequestMethod.GET)
    ResponseEntity<Void> getPhotoInfo(@PathVariable(name = "id") String id, @RequestHeader(name = "Authorization") String token);


}
