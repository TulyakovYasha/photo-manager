package photo.manager.server.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import photo.manager.api.PhotoApi;
import photo.manager.server.service.PhotoService;


@RestController
public class PhotoEndpoint implements PhotoApi {

    private PhotoService photoService;

    @Autowired
    public void setPhotoService(PhotoService photoService) {
        this.photoService = photoService;
    }

    @Override
    public ResponseEntity<Void> getPhoto(String page, String token) {
         photoService.savePhoto(page, token);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> getPhotoInfo(String id, String token) {
        photoService.savePhotoInfo(id, token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
