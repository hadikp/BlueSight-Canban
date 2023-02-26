package bluesight.col;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ColRepository extends JpaRepository<Col, Long> {

    @Query(value = "Select c from Col c join fetch c.cards where c.id = :id")
    Col findCardThisColumn(Long id);
}
