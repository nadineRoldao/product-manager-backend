CREATE TABLE IF NOT EXISTS order_item (
    order_id            BIGINT                  NOT NULL                     ,
    product_id          BIGINT                  NOT NULL                     ,
    amount              INT                     NOT NULL                     ,
    price               DECIMAL(10, 2)          NOT NULL                     ,
    discount            DECIMAL(10, 2)          NOT NULL                     ,
    PRIMARY KEY         (order_id, product_id)                               ,
    FOREIGN KEY         (order_id)              REFERENCES orders     (id)   ,
    FOREIGN KEY         (product_id)            REFERENCES products   (id)   ,
    INDEX order_id      (order_id ASC)                                       ,
    INDEX product_id    (product_id ASC)
)