package andredr.tech.syllabomb.infrastructure.adapter.in.websocket;

import java.util.UUID;
import lombok.Data;

@Data
public class WordSubmitMessage {
    private UUID playerId;
    private String word;
}
