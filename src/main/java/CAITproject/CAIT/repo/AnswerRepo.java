package CAITproject.CAIT.repo;

import CAITproject.CAIT.model.Answer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Integer> {
    @Modifying
    @Transactional
    @Query(
            """
            DELETE FROM Answer a
            WHERE a.question.id = :id
            """)
    void deleteAllAnswerFromQuestion(@Param("id") int id);
}
