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

INSERT INTO dealerships (name, address, phone) VALUES
('Auto Galaxy', '123 Main St, Springfield', '555-123-4567'),
('Prime Motors', '456 Oak Ave, Rivertown', '555-234-5678'),
('Elite Rides', '789 Pine Rd, Lakeside', '555-345-6789');

INSERT INTO vehicles (vin, year, make, modle, vehicle_type, color, odometer, price, sold) VALUES
('1HGCM82633A123456', 2020, 'Toyota', 'Camry', 'Sedan', 'Blue', 23000, 18500.00, 0),
('2T1BURHE5JC123457', 2021, 'Honda', 'Civic', 'Sedan', 'Red', 15000, 19500.00, 1),
('1FADP3F22JL123458', 2019, 'Ford', 'Focus', 'Hatchback', 'White', 30000, 12500.00, 0),
('1C4RJFAG0JC123459', 2022, 'Jeep', 'Grand Cherokee', 'SUV', 'Black', 10000, 35000.00, 1),
('3FA6P0H70JR123460', 2018, 'Ford', 'Fusion', 'Sedan', 'Silver', 45000, 11000.00, 0),
('WBA3A5C56DF123461', 2023, 'BMW', '320i', 'Sedan', 'Gray', 5000, 41000.00, 0);

INSERT INTO inventory (dealership_id, vin) VALUES
(1, '1HGCM82633A123456'),
(1, '2T1BURHE5JC123457'),
(2, '1FADP3F22JL123458'),
(2, '1C4RJFAG0JC123459'),
(3, '3FA6P0H70JR123460'),
(3, 'WBA3A5C56DF123461');

INSERT INTO sales_contracts (vin) VALUES
('2T1BURHE5JC123457'),
('1C4RJFAG0JC123459');
