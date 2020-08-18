package photo.manager.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import photo.manager.server.dao.PhotoInfoRepository;
import photo.manager.server.dao.PhotoRepository;
import photo.manager.server.service.remote.PhotoClient;
import photo.manager.server.util.Mapper;


@Service
public class PhotoService {

    @Value("${agile.server.url}")
    private String agileUrl;

    private PhotoClient photoClient;

    private PhotoRepository photoRepository;
    private PhotoInfoRepository photoInfoRepository;

    @Autowired
    public void setPhotoRepository(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Autowired
    public void setPhotoClient(PhotoClient photoClient) {
        this.photoClient = photoClient;
    }

    @Autowired
    public void setPhotoInfoRepository(PhotoInfoRepository photoInfoRepository) {
        this.photoInfoRepository = photoInfoRepository;
    }

    public void savePhoto(String page, String token) {
        photoRepository.save(Mapper.mapPhotoDtoToPhotoEntity(photoClient.getAllPhoto(page, token)));
    }

    public void savePhotoInfo(String id, String token) {
        photoInfoRepository.save(Mapper.mapPhotoInfoDtoToPhotoInfoEntity(photoClient.getAllPhotoInfo(id, token)));
    }
}
