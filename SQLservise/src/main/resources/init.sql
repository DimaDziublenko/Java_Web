CREATE TABLE developers (
    id     bigint,
    name   varchar(32),
    age    int,
    gender varchar(32),
    PRIMARY KEY (id)
);

CREATE TABLE skills (
    id          bigint,
    industry    varchar(32),
    skill_level varchar(32),
    PRIMARY KEY (id)
);

CREATE TABLE projects(
    id       bigint,
    title    varchar(124),
    industry varchar(32),
    deadline int,
    PRIMARY KEY (id)
);

CREATE TABLE company (
    id       bigint,
    title    varchar(124),
    industry varchar(32),
    PRIMARY KEY (id)
);

CREATE TABLE customers (
    id      bigint,
    name    varchar(32),
    surname varchar(64),
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