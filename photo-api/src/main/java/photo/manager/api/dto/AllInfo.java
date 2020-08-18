package photo.manager.api.dto;

import java.util.List;

public class AllInfo {
    private List<Photo> photo;

    private List<PhotoInfo> photoInfo;

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public List<PhotoInfo> getPhotoInfo() {
        return photoInfo;
    }

    public void setPhotoInfo(List<PhotoInfo> photoInfo) {
        this.photoInfo = photoInfo;
    }
}
