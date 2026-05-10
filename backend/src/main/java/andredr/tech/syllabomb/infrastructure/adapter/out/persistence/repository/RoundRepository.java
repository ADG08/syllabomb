package andredr.tech.syllabomb.infrastructure.adapter.out.persistence.repository;

import andredr.tech.syllabomb.infrastructure.adapter.out.persistence.entity.RoundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface RoundRepository extends JpaRepository<RoundEntity, UUID> {
    List<RoundEntity> findByGameId(UUID gameId);
    List<RoundEntity> findByGameIdAndSuccessTrue(UUID gameId);
}