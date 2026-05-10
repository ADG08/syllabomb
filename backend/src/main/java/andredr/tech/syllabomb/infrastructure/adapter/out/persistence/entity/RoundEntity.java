package andredr.tech.syllabomb.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "round")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoundEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private GameEntity game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerEntity player;

    @Column(name = "round_number", nullable = false)
    private int roundNumber;

    @Column(nullable = false, length = 5)
    private String syllable;

    @Column(name = "word_submitted", nullable = false, length = 100)
    private String wordSubmitted;

    @Column(nullable = false)
    private boolean success;

    @Column(name = "duration_ms")
    private Integer durationMs;

    @Column(name = "played_at", nullable = false, updatable = false)
    private LocalDateTime playedAt;

    @PrePersist
    protected void onCreate() {
        playedAt = LocalDateTime.now();
    }
}