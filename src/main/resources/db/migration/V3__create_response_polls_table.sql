CREATE TABLE response_polls (
    id_response_poll UUID PRIMARY KEY,
    answer VARCHAR(255) NOT NULL,
    user_id UUID NOT NULL,
    poll_id UUID NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id_user) ON DELETE CASCADE,
    FOREIGN KEY (poll_id) REFERENCES polls(id_poll) ON DELETE CASCADE
);