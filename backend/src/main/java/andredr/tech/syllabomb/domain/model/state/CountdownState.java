package andredr.tech.syllabomb.domain.model.state;

import andredr.tech.syllabomb.domain.model.GameContext;
import andredr.tech.syllabomb.domain.model.GameState;
import andredr.tech.syllabomb.domain.model.GameStatus;

public class CountdownState implements GameState {

    @Override
    public void onEnter(GameContext context) {}

    @Override
    public void onExit(GameContext context) {}

    @Override
    public GameStatus getStatus() {
        return GameStatus.COUNTDOWN;
    }
}