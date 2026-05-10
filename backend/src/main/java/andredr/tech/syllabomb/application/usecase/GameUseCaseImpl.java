package andredr.tech.syllabomb.application.usecase;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import andredr.tech.syllabomb.domain.model.GameContext;
import andredr.tech.syllabomb.domain.model.Player;
import andredr.tech.syllabomb.domain.port.in.GameUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameUseCaseImpl implements GameUseCase{

    private final Map<UUID, GameContext> games = new ConcurrentHashMap<>(); 

    @Override
    public GameContext createGame() {
        GameContext context = new GameContext(UUID.randomUUID());
        games.put(context.getGameId(), context);
        return context;
    }

    @Override
    public GameContext joinGame(UUID gameId, Player player) {
        GameContext context = getGame(gameId);
        context.getPlayers().add(player);
        return context;
    }

    @Override
    public void submitWord(UUID gameId, Player player, String word) {
    }

    private GameContext getGame(UUID gameId) {
        GameContext context = games.get(gameId);
        if (context == null) throw new IllegalArgumentException("Game not found: " + gameId);
        return context;
    }
    
    
}
