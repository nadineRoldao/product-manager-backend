CREATE TABLE IF NOT EXISTS products (
    id          BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY         ,
    name        VARCHAR(300)    NOT NULL                                    ,
    category    VARCHAR(100)    NOT NULL                                    ,
    price       DOUBLE          NOT NULL                                    ,
    link        VARCHAR(500)
)