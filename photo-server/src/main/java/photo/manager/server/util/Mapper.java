package photo.manager.server.util;

import photo.manager.api.dto.Photo;
import photo.manager.api.dto.Picture;
import photo.manager.server.dto.PhotoDto;
import photo.manager.server.dto.PhotoInfoDto;
import photo.manager.server.dto.PictureDto;
import photo.manager.server.entity.PhotoEntity;
import photo.manager.server.entity.PhotoInfoEntity;
import photo.manager.server.entity.PictureEntity;

import java.util.stream.Collectors;

public class Mapper {

    public static Photo mapPhotoDtoToPhoto(PhotoDto photoDto) {
        Photo photo = new Photo();
        photo.setHasMore(photoDto.isHasMore());
        photo.setPage(photoDto.getPage());
        photo.setPageCount(photoDto.getPageCount());
        photo.setPictures(photoDto.getPictures().stream().map(Mapper::mapPictureDtoToPicture).collect(Collectors.toList()));
        return photo;
    }

    private static Picture mapPictureDtoToPicture(PictureDto pictureDto) {
        Picture picture = new Picture();
        picture.setId(pictureDto.getId());
        picture.setCropped_picture(pictureDto.getCropped_picture());
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
}
