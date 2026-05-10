package andredr.tech.syllabomb.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import andredr.tech.syllabomb.domain.model.state.WaitingState;
import lombok.Getter;

@Getter
public class GameContext {
    
    private final UUID gameId;
    private GameState currentState;
    private String currentSyllable;
    private int roundNumber;
    private Player currentPlayer;
    private final List<Player> players = new ArrayList<>();

    public GameContext(UUID gameId) {
        this.gameId = gameId;
        this.currentState = new WaitingState();
    }

    public void transitionTo(GameState newContext) {
        this.currentState.onExit(this);
        this.currentState = newContext;
        this.currentState.onEnter(this);
    }

    public GameStatus getStatus() {
        return currentState.getStatus();
    }

    public void setCurrentSyllable(String syllable) {
        this.currentSyllable = syllable;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public void incrementRound() {
        this.roundNumber++;
    }
}
