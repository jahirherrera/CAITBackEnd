package CAITproject.CAIT.repo;

import CAITproject.CAIT.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group, Integer> {

    Group findByName(String name);
}
