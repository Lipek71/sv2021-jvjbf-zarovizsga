package finalexam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "teams")
public interface TeamRepository extends JpaRepository<Team, Long> {
}
