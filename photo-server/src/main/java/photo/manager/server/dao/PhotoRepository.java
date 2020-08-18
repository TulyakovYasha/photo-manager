package photo.manager.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import photo.manager.server.entity.PhotoEntity;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
}
