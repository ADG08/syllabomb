package andredr.tech.syllabomb.domain.port.in;

import java.util.UUID;

import andredr.tech.syllabomb.domain.model.GameContext;
import andredr.tech.syllabomb.domain.model.Player;

public interface GameUseCase {
    GameContext createGame();
    GameContext joinGame(UUID gameId, Player player);
    void submitWord(UUID gameId,Player player,String word);
}
