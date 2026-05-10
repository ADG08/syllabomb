CREATE TYPE game_status AS ENUM (
    'WAITING',
    'LOBBY',
    'COUNTDOWN',
    'ROUND_ACTIVE',
    'ROUND_END',
    'GAME_OVER'
);

CREATE TABLE game (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    status game_status NOT NULL DEFAULT 'WAITING',
    current_syllable VARCHAR(5),
    round_number INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE player (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    game_id UUID REFERENCES game(id) ON DELETE CASCADE,
    username VARCHAR(50) NOT NULL,
    lives INT NOT NULL DEFAULT 3,
    is_ready BOOLEAN NOT NULL DEFAULT FALSE,
    is_eliminated BOOLEAN NOT NULL DEFAULT FALSE,
    joined_at TIMESTAMP NOT NULL DEFAULT NOW()
);

ALTER TABLE game
    ADD COLUMN current_player_id UUID REFERENCES player(id) ON DELETE SET NULL;

CREATE INDEX idx_player_game_id ON player(game_id);

CREATE TABLE round (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    game_id UUID NOT NULL REFERENCES game(id) ON DELETE CASCADE,
    player_id UUID NOT NULL REFERENCES player(id) ON DELETE CASCADE,
    round_number INT NOT NULL,
    syllable VARCHAR(5) NOT NULL,
    word_submitted VARCHAR(100) NOT NULL,
    success BOOLEAN NOT NULL,
    duration_ms INT,
    played_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_round_game_id ON round(game_id);
CREATE INDEX idx_round_player_id ON round(player_id);
