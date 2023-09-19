CREATE TABLE IF NOT EXISTS orders (
    id          BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    client_id   BIGINT          NOT NULL                            ,
    date        DATETIME        NOT NULL                            ,
    status      VARCHAR(100)    NOT NULL                            ,
    INDEX client_id (client_id ASC)
)