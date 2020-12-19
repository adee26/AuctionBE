CREATE TABLE bidding
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    auction_id INT,
    user_id    INT,
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (auction_id) REFERENCES auction (id)
)
