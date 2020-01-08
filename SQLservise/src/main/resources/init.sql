CREATE TABLE developers (
    id     bigint,
    name   varchar(30),
    age    int,
    gender varchar(6),
    PRIMARY KEY (id)
);

CREATE TABLE skills (
    id          bigint,
    industry    varchar(30),
    skill_level varchar(7),
    PRIMARY KEY (id)
);

CREATE TABLE projects(
    id       bigint,
    title    varchar(255),
    industry varchar(30),
    deadline int,
    PRIMARY KEY (id)
);

CREATE TABLE companies (
    id       bigint,
    title    varchar(255),
    industry varchar(30),
    PRIMARY KEY (id)
);

CREATE TABLE customers (
    id      bigint,
    name    varchar(30),
    surname varchar(50),
    PRIMARY KEY (id)
);

CREATE TABLE developer_project (
    developer_id bigint,
    project_id   bigint,
    FOREIGN KEY (developer_id) REFERENCES developers,
    FOREIGN KEY (project_id) REFERENCES projects
)

CREATE TABLE developer_skill (
    developer_id bigint,
    skill_id     bigint,
    FOREIGN KEY (developer_id) REFERENCES developers,
    FOREIGN KEY (skill_id) REFERENCES skills
)

CREATE TABLE company_project (
    company_id bigint,
    project_id bigint,
    FOREIGN KEY (company_id) REFERENCES companies,
    FOREIGN KEY (project_id) REFERENCES projects
)

CREATE TABLE customer_project (
    customer_id bigint,
    project_id  bigint,
    FOREIGN KEY (customer_id) REFERENCES customers,
    FOREIGN KEY (project_id) REFERENCES projects
)