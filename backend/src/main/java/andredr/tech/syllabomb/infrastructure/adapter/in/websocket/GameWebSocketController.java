package andredr.tech.syllabomb.infrastructure.adapter.in.websocket;

import java.util.UUID;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import andredr.tech.syllabomb.domain.port.in.GameUseCase;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GameWebSocketController {
    
    private final GameUseCase gameUseCase;

    @MessageMapping("/game/{gameId}/word")
    @SendTo("/topic/game/{gameId}")
    public Object submitWord(@DestinationVariable UUID gameId, WordSubmitMessage message) {
        return null;
    }
}
