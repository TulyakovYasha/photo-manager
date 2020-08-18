package photo.manager.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import photo.manager.api.dto.AllInfo;
import photo.manager.api.dto.Photo;
import photo.manager.api.dto.PhotoInfo;
import photo.manager.server.dao.PhotoInfoRepository;
import photo.manager.server.dao.PhotoRepository;
import photo.manager.server.dto.PhotoDto;
import photo.manager.server.service.remote.PhotoClient;
import photo.manager.server.util.Mapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PhotoService {

    private PhotoClient photoClient;

    @Value("${agile.server.url}")
    private String agileUrl;

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

    public AllInfo getAllInfo() {
        List<Photo> photos = photoRepository.findAll().stream().map(Mapper::mapPhotoEntityToPhoto).collect(Collectors.toList());
        List<PhotoInfo> photoInfos = photoInfoRepository.findAll().stream().map(Mapper::mapPhotoInfoEntityToPhotoInfo).collect(Collectors.toList());;
        AllInfo allInfo = new AllInfo();
        allInfo.setPhoto(photos);
        allInfo.setPhotoInfo(photoInfos);
        return allInfo;
    }
}
