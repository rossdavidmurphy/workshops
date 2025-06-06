CREATE DATABASE car_dealership;

CREATE TABLE dealerships (
	dealership_id INT AUTO_INCREMENT,
	name VARCHAR(50),
	address VARCHAR(50),
	phone VARCHAR(12),
    PRIMARY KEY (dealership_id)
    
);

CREATE TABLE vehicles (
	vin VARCHAR(17),
    year INT,
    make CHAR(50),
    modle CHAR(100),
    vehicle_type CHAR(50),
    color CHAR(30),
    odometer BIGINT,
    price DECIMAL(10, 2),
    sold TINYINT NOT NULL DEFAULT 0,
    PRIMARY KEY (vin)
);

CREATE TABLE inventory (
	dealership_id INT,
    vin VARCHAR(17),
    FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    FOREIGN KEY (vin) REFERENCES vehicles(vin),
    PRIMARY KEY (dealership_id, vin)
);

CREATE TABLE sales_contracts (
	contract_id INT AUTO_INCREMENT,
    vin VARCHAR(17),
    FOREIGN KEY (vin) REFERENCES vehicles(vin),
    PRIMARY KEY (contract_id)
);

