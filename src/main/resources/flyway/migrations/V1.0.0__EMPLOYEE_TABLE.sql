CREATE TABLE rdstest.employee (
    emp_id serial PRIMARY KEY NOT NULL,
    name varchar(100),
    designation varchar(60),
    age integer,
    salary integer
);

INSERT INTO rdstest.employee(name, designation, age, salary)
VALUES ('STARK', 'SOFTWARE ENGINEER', 34, 2800),
       ('ADOLF', 'SALESMAN', 44, 1600),
       ('JARVIS', 'MANAGER', 54, 3570),
       ('MILES', 'SALESMAN', 65, 1250),
       ('HILL', 'MANAGER', 45, 2940),
       ('SMITH', 'ANALYST', 26, 3000),
       ('KINSLEY', 'PRESIDENT', 56, 5000),
       ('TIMOTHY', 'SALESMAN', 76, 1500),
       ('ASGHAR', 'SOFTWARE ENGINEER', 33, 3100),
       ('SUMMERS', 'TECHNICAL LEAD', 34, 2950),
       ('FAULKNER', 'ANAYLYST', 35, 3000),
       ('MATTHEWS', 'SOFTWARE ENGINEER', 65, 300),
       ('SHAWN', 'SALESMAN', 63, 500),
       ('SWAN', 'MANAGER', 44, 3420),
       ('HIMBURY', 'ANALYST', 33, 2000),
       ('WILSON', 'ANALYST', 55, 7000),
       ('JENNIFER', 'ANALYST', 44, 5000);