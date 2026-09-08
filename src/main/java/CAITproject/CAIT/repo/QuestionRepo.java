package CAITproject.CAIT.repo;

import CAITproject.CAIT.model.Question;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

    @Query(
            """
            SELECT q
            FROM Question q
            WHERE q.group.id = :id
            """)
    List<Question> getQuestionFromGroup(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(
            """
            DELETE FROM Question q
            WHERE q.group.id = :id
            """)
    void deleteAllQuestionFromGroup(@Param("id") int id);
}
