-- Table player
CREATE TABLE player (
    player_id SERIAL PRIMARY KEY,
    player_name VARCHAR(50) NOT NULL,
    registration_date DATE NOT NULL,
    hashed_password VARCHAR(255),
    coins INT
);

-- Table scoreboard
CREATE TABLE scoreboard (
    game_id SERIAL PRIMARY KEY,
    game_date TIMESTAMP NOT NULL,
    duration INT NOT NULL,
    score INT,
    player_id INT,
    player_name VARCHAR(50),
    FOREIGN KEY (player_id) REFERENCES player(player_id)
);

-- Table moto
CREATE TABLE moto (
    moto_id SERIAL PRIMARY KEY,
    color VARCHAR(20) NOT NULL,
    player_id INT,
    image TEXT, -- Remplacement de VARCHAR(MAX) par TEXT
    moto_name VARCHAR(50),
    price INT,
    FOREIGN KEY (player_id) REFERENCES player(player_id)
);

-- Table trail
CREATE TABLE trail (
    trail_id SERIAL PRIMARY KEY,
    color VARCHAR(20),
    price INT,
    name VARCHAR(50)
);

-- Table inventory
CREATE TABLE inventory (
    inventory_id SERIAL PRIMARY KEY,
    player_id INT,
    coins INT,
    FOREIGN KEY (player_id) REFERENCES player(player_id)
);

-- Table asset_moto_inv
CREATE TABLE asset_moto_inv (
    inventory_id INT,
    moto_id INT,
    PRIMARY KEY (inventory_id, moto_id),
    FOREIGN KEY (inventory_id) REFERENCES inventory(inventory_id),
    FOREIGN KEY (moto_id) REFERENCES moto(moto_id)
);

-- Table asset_trail_inv
CREATE TABLE asset_trail_inv (
    inventory_id INT,
    trail_id INT,
    PRIMARY KEY (inventory_id, trail_id),
    FOREIGN KEY (inventory_id) REFERENCES inventory(inventory_id),
    FOREIGN KEY (trail_id) REFERENCES trail(trail_id)
);
