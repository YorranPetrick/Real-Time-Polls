CREATE TABLE polls (
    id_poll UUID PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL, -- Enum convertido para string
    responses INT NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    creator_id UUID NOT NULL,
    FOREIGN KEY (creator_id) REFERENCES user(id_user) ON DELETE CASCADE
);