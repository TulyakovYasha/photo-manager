package photo.manager.server.util;

import photo.manager.api.dto.Photo;
import photo.manager.api.dto.PhotoInfo;
import photo.manager.api.dto.Picture;
import photo.manager.server.dto.PhotoDto;
import photo.manager.server.dto.PhotoInfoDto;
import photo.manager.server.dto.PictureDto;
import photo.manager.server.entity.PhotoEntity;
import photo.manager.server.entity.PhotoInfoEntity;
import photo.manager.server.entity.PictureEntity;

import java.util.stream.Collectors;

public class Mapper {

    public static Photo mapPhotoEntityToPhoto(PhotoEntity photoEntity) {
        Photo photo = new Photo();
        photo.setHasMore(photoEntity.isHasMore());
        photo.setPage(photoEntity.getPage());
        photo.setPageCount(photoEntity.getPageCount());
        photo.setPictures(photoEntity.getPictures().stream().map(Mapper::mapPictureEntityToPicture).collect(Collectors.toList()));
        return photo;
    }

    private static Picture mapPictureEntityToPicture(PictureEntity pictureEntity) {
        Picture picture = new Picture();
        picture.setId(pictureEntity.getExternalId());
        picture.setCropped_picture(pictureEntity.getCropped_picture());
        return picture;
    }

    public static PhotoEntity mapPhotoDtoToPhotoEntity(PhotoDto photoDto) {
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setPage(photoDto.getPage());
        photoEntity.setHasMore(photoDto.isHasMore());
        photoEntity.setPageCount(photoDto.getPageCount());
        photoEntity.setPictures(photoDto.getPictures().stream().map(Mapper::mapPictureDtoToPictureEntity).collect(Collectors.toList()));
        return photoEntity;
    }

    private static PictureEntity mapPictureDtoToPictureEntity(PictureDto pictureDto) {
        PictureEntity pictureEntity = new PictureEntity();
        pictureEntity.setExternalId(pictureDto.getId());
        pictureEntity.setCropped_picture(pictureDto.getCropped_picture());
        return pictureEntity;
    }

    public static PhotoInfoEntity mapPhotoInfoDtoToPhotoInfoEntity(PhotoInfoDto allPhotoInfo) {
        PhotoInfoEntity photoInfoEntity = new PhotoInfoEntity();
        photoInfoEntity.setAuthor(allPhotoInfo.getAuthor());
        photoInfoEntity.setCamera(allPhotoInfo.getCamera());
        photoInfoEntity.setCropped_picture(allPhotoInfo.getCropped_picture());
        photoInfoEntity.setFull_picture(allPhotoInfo.getFull_picture());
        photoInfoEntity.setExternalId(allPhotoInfo.getId());
        photoInfoEntity.setTags(allPhotoInfo.getTags());
        return photoInfoEntity;
    }

    public static PhotoInfo mapPhotoInfoEntityToPhotoInfo(PhotoInfoEntity photoInfoEntity) {
        PhotoInfo photoInfo = new PhotoInfo();
        photoInfo.setAuthor(photoInfoEntity.getAuthor());
        photoInfo.setCamera(photoInfoEntity.getCamera());
        photoInfo.setCropped_picture(photoInfoEntity.getCropped_picture());
        photoInfo.setFull_picture(photoInfoEntity.getFull_picture());
        photoInfo.setTags(photoInfoEntity.getTags());
        photoInfo.setId(photoInfoEntity.getExternalId());
        return photoInfo;
    }
}
