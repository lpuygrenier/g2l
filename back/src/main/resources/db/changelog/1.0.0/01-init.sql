--liquibase formatted sql

--changeset lpuygrenier:01
CREATE SCHEMA customer;
CREATE SCHEMA referentiel;
CREATE SCHEMA rental;

CREATE TABLE referentiel.vehicle (
    id SERIAL PRIMARY KEY,
    year INTEGER
);

CREATE TABLE referentiel.vehicleType (
    type_name VARCHAR(50)
);

CREATE TABLE referentiel.vehicleCoefPrice (
    coef_price DECIMAL(5,2)
);

CREATE TABLE referentiel.CustomerType (
    type_name VARCHAR(50)
);

CREATE TABLE referentiel.user (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(100),
);

CREATE TABLE referentiel.vehicleRevision (
    id SERIAL PRIMARY KEY,
    vehicle_id INTEGER REFERENCES referentiel.vehicle(id),
    revision_date DATE,
);

CREATE TABLE referentiel.UtilityCategory (
    id SERIAL PRIMARY KEY,
    category_name VARCHAR(50)
);

CREATE TABLE referentiel.TourismCategory (
    id SERIAL PRIMARY KEY,
    category_name VARCHAR(50)
);

CREATE TABLE customer.customer (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    customer_type_id INTEGER REFERENCES referentiel.CustomerType(id)
    compagny_id INTEGER REFERENCES customer.compagny(id)
);

CREATE TABLE customer.compagny (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(200),
);

CREATE TABLE rental.rental (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER REFERENCES customer.customer(id),
    vehicle_id INTEGER REFERENCES referentiel.vehicle(id),
    start_date DATE,
    end_date DATE,
    total_price DECIMAL(10,2)
);
