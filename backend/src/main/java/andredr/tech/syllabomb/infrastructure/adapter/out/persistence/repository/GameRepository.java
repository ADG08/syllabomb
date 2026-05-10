package andredr.tech.syllabomb.infrastructure.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import andredr.tech.syllabomb.infrastructure.adapter.out.persistence.entity.GameEntity;
import java.util.List;
import andredr.tech.syllabomb.domain.model.GameStatus;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, UUID>{
    List<GameEntity> findByStatus(GameStatus status);
}
