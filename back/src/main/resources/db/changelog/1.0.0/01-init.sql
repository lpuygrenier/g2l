-- liquibase formatted sql

--changeset lpuygrenier:001
CREATE TABLE conducteur (
    id uuid PRIMARY KEY,
    reference varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    first_name varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    postal_code varchar(20) NOT NULL,
    email varchar(255) NOT NULL,
    phone_number varchar(50),
    driver_licence varchar(255) NOT NULL
);

--changeset lpuygrenier:002
CREATE TABLE particulier (
    id uuid PRIMARY KEY,
    card_imprint boolean,
    CONSTRAINT fk_particulier_conducteur FOREIGN KEY (id)
        REFERENCES conducteur(id)
);

--changeset lpuygrenier:003
CREATE TABLE entreprise (
    id uuid PRIMARY KEY,
    reference varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    phone varchar(50) NOT NULL,
    address varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    postal_code varchar(20) NOT NULL,
    siren_siret varchar(50) NOT NULL,
    naf varchar(50) NOT NULL,
    tva_number varchar(50) NOT NULL,
    card_imprint boolean
);

--changeset lpuygrenier:004
CREATE TABLE vehicle (
    id uuid PRIMARY KEY,
    name varchar(255) NOT NULL,
    matricule varchar(50) NOT NULL,
    commissioning_date date,
    gas_type uuid NOT NULL,
    type_id uuid NOT NULL,
    category_id uuid NOT NULL,
    kilometer integer,
    money_earned numeric(10,2),
    seats integer,
    color varchar(50)
);

--changeset lpuygrenier:005
CREATE TABLE payment_method (
    id integer PRIMARY KEY,
    label VARCHAR(50) NOT NULL
);

CREATE TABLE customer_type (
    id integer PRIMARY KEY,
    label VARCHAR(50) NOT NULL
);


CREATE TABLE rental_contract (
    id uuid PRIMARY KEY,
    reference varchar(255),
    order_number integer,
    customer_type_id integer NOT NULL,
    customer_id uuid NOT NULL,
    vehicle_id uuid NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL,
    state uuid NOT NULL,
    kilometer integer,
    comment text,
    discount integer,
    has_snow_tire boolean, 
    has_trolley boolean,
    payment_method_id integer NOT NULL,
    FOREIGN KEY (payment_method_id) REFERENCES payment_method(id)
    FOREIGN KEY (customer_type_id) REFERENCES customer_type(id)
    CONSTRAINT fk_rental_vehicle FOREIGN KEY (vehicle_id)
        REFERENCES vehicle(id)
);

CREATE OR REPLACE VIEW rental_contract_view AS
SELECT
rc.*,
1::numeric(10,2) AS base_package,
1::numeric(10,2) AS base_package_all_kilometers,
1::numeric(10,2) AS additional_driver,
1::numeric(10,2) AS snow_tire_amount,
1::numeric(10,2) AS amount_taxes_free,
1::numeric(10,2) AS amount_all_taxes
FROM rental_contract rc;

--changeset lpuygrenier:006
CREATE TABLE rental_contract_drivers (
    rental_contract_id uuid NOT NULL,
    driver_id uuid NOT NULL,
    PRIMARY KEY (rental_contract_id, driver_id),
    CONSTRAINT fk_rental_contract
        FOREIGN KEY (rental_contract_id) REFERENCES rental_contract(id),
    CONSTRAINT fk_driver
        FOREIGN KEY (driver_id) REFERENCES conducteur(id)
);
