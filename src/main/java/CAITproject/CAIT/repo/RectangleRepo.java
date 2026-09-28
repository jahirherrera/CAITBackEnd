package CAITproject.CAIT.repo;

import CAITproject.CAIT.model.ImageQuestions;
import CAITproject.CAIT.model.Rectangle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RectangleRepo extends JpaRepository<Rectangle, Integer> {

    @Query(
            """
            SELECT r
            FROM Rectangle r
            WHERE r.image.id = :id
            """)
    List<Rectangle> getRectanglesFromImage(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(
            """
            DELETE FROM Rectangle r
            WHERE r.image.id = :id
            """)
    void deleteAllSquareFromImage(@Param("id") int id);
}
