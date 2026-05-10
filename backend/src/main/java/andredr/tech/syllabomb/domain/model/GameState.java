package andredr.tech.syllabomb.domain.model;

public interface GameState {
    void onEnter(GameContext context);
    void onExit(GameContext context);
    GameStatus getStatus();
}
