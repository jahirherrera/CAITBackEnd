package CAITproject.CAIT.repo;

import CAITproject.CAIT.model.Image;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<Image, Integer> {

    @Query(
            """
            SELECT i
            FROM Image i
            WHERE i.group.id = :id
            """)
    List<Image> getImagesFromGroup(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(
            """
            DELETE FROM Image i
            WHERE i.url_image = :url
            """)
    void deleteImageFromUrl(@Param("url") String url);

}
