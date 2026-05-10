package andredr.tech.syllabomb.domain.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Player {
    
    private UUID id;
    private String username;
    private int lives;
    private boolean ready;
    private boolean eliminated;

    public void loseLife() {
        if (eliminated) throw new IllegalStateException("Player is already eliminated");
        lives--;
        if(lives <= 0) {
            eliminated = true;
        }
    } 

    public void toggleReady() {
        ready = !ready;
    }
}
