-- Customer entity
-- aggregate root
DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer (
    id         BIGINT IDENTITY PRIMARY KEY,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email VARCHAR(255)
);
-- RetailItem entity
-- aggregate root
DROP TABLE IF EXISTS RetailItem;
CREATE TABLE RetailItem (
    id          BIGINT IDENTITY PRIMARY KEY,
    title       VARCHAR(255),
    description VARCHAR(255),
    currentPrice INT
);
-- Orders entity
-- aggregate root
-- Refers to Customer aggregate root by Id
DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders (
    id BIGINT IDENTITY PRIMARY KEY,
    Customer BIGINT,
    shippingAddress VARCHAR(255),
    shippingCost INT
);
-- OrderItem entity
-- belongs to Orders aggregate.
-- Refers to RetailItem aggregate root by Id
DROP TABLE IF EXISTS OrderItem;
CREATE TABLE OrderItem (
    quantity INT,
    price INT,
    retailItem_id BIGINT,
    Orders BIGINT,
    Orders_Key SMALLINT,
    PRIMARY KEY (Orders, Orders_Key),
    FOREIGN KEY (Orders) References Orders(id)
);
