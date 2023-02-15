package bluesight.swimlane;

import bluesight.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SwimlaneRepository extends JpaRepository<Swimlane, Long> {

    @Query("Select s from Swimlane s join fetch s.cards where s.id = :id")
    Swimlane listCardThisSwimlane(Long id);
}
