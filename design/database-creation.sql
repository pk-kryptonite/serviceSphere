-- User Table
CREATE TABLE User (
    user_id INT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(100),
    phone_number VARCHAR(20),
    address VARCHAR(200),
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8)
);

-- Service Provider Table
CREATE TABLE ServiceProvider (
    provider_id INT PRIMARY KEY,
    user_id INT,
    business_name VARCHAR(100),
    description TEXT,
    is_grass_cutter BOOLEAN,
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8),
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

-- Service Category Table
CREATE TABLE ServiceCategory (
    category_id INT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);

-- Service Table
CREATE TABLE Service (
    service_id INT PRIMARY KEY,
    provider_id INT,
    category_id INT,
    service_name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (provider_id) REFERENCES ServiceProvider(provider_id),
    FOREIGN KEY (category_id) REFERENCES ServiceCategory(category_id)
);

-- Appointment Table
CREATE TABLE Appointment (
    appointment_id INT PRIMARY KEY,
    user_id INT,
    service_id INT,
    appointment_date_time DATETIME NOT NULL,
    status VARCHAR(20),
    appointment_latitude DECIMAL(10, 8),
    appointment_longitude DECIMAL(11, 8),
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (service_id) REFERENCES Service(service_id)
);

-- Payment Table
CREATE TABLE Payment (
    payment_id INT PRIMARY KEY,
    user_id INT,
    appointment_id INT,
    amount DECIMAL(10, 2) NOT NULL,
    payment_date DATETIME,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id)
);

-- Review Table
CREATE TABLE Review (
    review_id INT PRIMARY KEY,
    user_id INT,
    service_provider_id INT,
    rating DECIMAL(3, 2) NOT NULL,
    comment TEXT,
    review_date DATETIME,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (service_provider_id) REFERENCES ServiceProvider(provider_id)
);

-- Grass Cutter Table
CREATE TABLE GrassCutter (
    grass_cutter_id INT PRIMARY KEY,
    user_id INT,
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8),
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

-- Grass Cutter Charge Table
CREATE TABLE GrassCutterCharge (
    grass_cutter_charge_id INT PRIMARY KEY,
    grass_cutter_id INT,
    category_id INT,
    charge_per_square_meter DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (grass_cutter_id) REFERENCES GrassCutter(grass_cutter_id),
    FOREIGN KEY (category_id) REFERENCES ServiceCategory(category_id)
);

-- Area Size Table
CREATE TABLE AreaSize (
    area_size_id INT PRIMARY KEY,
    user_id INT,
    area_size_square_meters DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

-- Charge per Square Meter Table
CREATE TABLE ChargePerSquareMeter (
    charge_id INT PRIMARY KEY,
    category_id INT,
    charge_per_square_meter DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES ServiceCategory(category_id)
);

-- Transaction Table
CREATE TABLE Transaction (
    transaction_id INT PRIMARY KEY,
    user_id INT,
    transaction_type VARCHAR(20) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    transaction_date DATETIME,
    description TEXT,
    related_id INT,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (related_id) REFERENCES Payment(payment_id) -- This can be adjusted for other related tables
);

-- Verification Type Table
CREATE TABLE VerificationType (
    verification_type_id INT PRIMARY KEY,
    verification_type_name VARCHAR(50) NOT NULL
);

-- Verification Status Table
CREATE TABLE VerificationStatus (
    verification_status_id INT PRIMARY KEY,
    verification_status_name VARCHAR(50) NOT NULL
);

-- Verification Table
CREATE TABLE Verification (
    verification_id INT PRIMARY KEY,
    service_provider_id INT,
    verification_type_id INT,
    verification_status_id INT,
    verification_document VARCHAR(200),
    verification_selfie VARCHAR(200),
    verification_date DATETIME,
    FOREIGN KEY (service_provider_id) REFERENCES ServiceProvider(provider_id),
    FOREIGN KEY (verification_type_id) REFERENCES VerificationType(verification_type_id),
    FOREIGN KEY (verification_status_id) REFERENCES VerificationStatus(verification_status_id)
);
