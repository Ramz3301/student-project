DROP TABLE IF EXISTS student_child;
DROP TABLE IF EXISTS student_order;
DROP TABLE IF EXISTS passport_office;
DROP TABLE IF EXISTS register_office;
DROP TABLE IF EXISTS country_struct;
DROP TABLE IF EXISTS street;

CREATE TABLE street
(
    street_code integer not null,
    street_name varchar(300),
    PRIMARY KEY (street_code)
);

CREATE TABLE country_struct
(
    area_id   char(12) not null,
    area_name varchar(200),
    PRIMARY KEY (area_id)
);

CREATE TABLE passport_office
(
    pass_office_id      integer  not null,
    pass_office_area_id char(12) not null,
    pass_office_name    varchar(200),
    PRIMARY KEY (pass_office_id),
    FOREIGN KEY (pass_office_area_id) REFERENCES country_struct (area_id) ON DELETE RESTRICT
);

CREATE TABLE register_office
(
    reg_office_id      integer  not null,
    reg_office_area_id char(12) not null,
    reg_office_name    varchar(200),
    PRIMARY KEY (reg_office_id),
    FOREIGN KEY (reg_office_area_id) REFERENCES country_struct (area_id) ON DELETE RESTRICT
);

CREATE TABLE student_order
(
    student_order_id     SERIAL,
    student_order_status INTEGER      NOT NULL,
    student_order_date   TIMESTAMP    NOT NULL,
    h_sur_name           varchar(100) not null,
    h_given_name         varchar(100) not null,
    h_patronymic         varchar(100) not null,
    h_date_of_birth      date         not null,
    h_passport_series    varchar(10)  not null,
    h_passport_number    varchar(10)  not null,
    h_passport_date      date         not null,
    h_passport_office_id integer      not null,
    h_post_index         varchar(10),
    h_street_code        integer      not null,
    h_building           varchar(10)  not null,
    h_extension          varchar(10),
    h_apartment          varchar(10),
    w_sur_name           varchar(100) not null,
    w_given_name         varchar(100) not null,
    w_patronymic         varchar(100) not null,
    w_date_of_birth      date         not null,
    w_passport_series    varchar(10)  not null,
    w_passport_number    varchar(10)  not null,
    w_passport_date      date         not null,
    w_passport_office_id integer      not null,
    w_post_index         varchar(10),
    w_street_code        integer      not null,
    w_building           varchar(10)  not null,
    w_extension          varchar(10),
    w_apartment          varchar(10),
    certificate_id       varchar(20)  not null,
    register_office_id   integer      not null,
    marriage_date        date         not null,
    PRIMARY KEY (student_order_id),
    FOREIGN KEY (h_street_code) REFERENCES street (street_code) ON DELETE RESTRICT,
    FOREIGN KEY (w_street_code) REFERENCES street (street_code) ON DELETE RESTRICT,
    FOREIGN KEY (register_office_id) REFERENCES register_office (reg_office_id) ON DELETE RESTRICT
);

CREATE TABLE student_child
(
    student_child_id     SERIAL,
    student_order_id     integer      not null,
    c_sur_name           varchar(100) not null,
    c_given_name         varchar(100) not null,
    c_patronymic         varchar(100) not null,
    c_date_of_birth      date         not null,
    c_certificate_number varchar(10)  not null,
    c_certificate_date   date         not null,
    c_register_office_id integer      not null,
    c_post_index         varchar(10),
    c_street_code        integer      not null,
    c_building           varchar(10)  not null,
    c_extension          varchar(10),
    c_apartment          varchar(10),
    PRIMARY KEY (student_child_id),
    FOREIGN KEY (c_street_code) REFERENCES street (street_code) ON DELETE RESTRICT,
    FOREIGN KEY (c_register_office_id) REFERENCES register_office (reg_office_id) ON DELETE RESTRICT
);

--
-- SELECT * FROM street;
-- INSERT INTO street (street_code, street_name)
-- VALUES (1, 'Panina')
--
-- INSERT INTO register_office (reg_office_id, reg_office_area_id, reg_office_name)
-- VALUES (1, 100010001000, 'Blahblahblah');




















