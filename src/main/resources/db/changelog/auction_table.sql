CREATE TABLE auction(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    description VARCHAR(255),
    photos VARCHAR(255),
    category_id INT,
    minimum_price INT,
    buy_now INT,
    start_date DATETIME,
    end_date DATETIME,
    FOREIGN KEY (category_id)
        REFERENCES category(id)
)
