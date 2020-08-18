package photo.manager.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import photo.manager.server.entity.PhotoInfoEntity;

public interface PhotoInfoRepository extends JpaRepository<PhotoInfoEntity, Long> {
}
