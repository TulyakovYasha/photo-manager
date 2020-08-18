package photo.manager.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import photo.manager.server.entity.PictureEntity;

@Repository
public interface PictureRepository extends JpaRepository<PictureEntity, Long> {
}
