package CAITproject.CAIT.repo;

import CAITproject.CAIT.model.ImageQuestions;
import CAITproject.CAIT.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<ImageQuestions, Integer> {

    @Query(
            """
            SELECT i
            FROM ImageQuestions i
            WHERE i.group.id = :id
            """)
    List<ImageQuestions> getImagesFromGroup(@Param("id") int id);
}
