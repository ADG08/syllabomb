package andredr.tech.syllabomb.infrastructure.adapter.out.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import andredr.tech.syllabomb.infrastructure.adapter.out.persistence.entity.PlayerEntity;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, UUID>{
    List<PlayerEntity> findByClassId(UUID gameId);
    List<PlayerEntity> findByGameAndEliminatedFalse(UUID gameId);
}