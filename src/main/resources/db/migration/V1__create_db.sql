CREATE TABLE clients
(
    id   LONG PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL
);

CREATE TABLE planets
(
    id   VARCHAR(20) PRIMARY KEY,
    name VARCHAR(500) NOT NULL
);

CREATE TABLE tickets
(
    id             LONG PRIMARY KEY AUTO_INCREMENT,
    created_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    client_id      LONG NOT NULL REFERENCES clients(id),
    from_planet_id VARCHAR(20) NOT NULL REFERENCES planets(id),
    to_planet_id   VARCHAR(20) NOT NULL REFERENCES planets(id)
);
