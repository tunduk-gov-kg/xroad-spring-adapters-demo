create table people
(
  id         BIGSERIAL PRIMARY KEY NOT NULL,
  pin        VARCHAR(100)          NOT NULL UNIQUE,
  name       VARCHAR(100)          NOT NULL,
  birth_date DATE                  NOT NULL,
  gender     VARCHAR(20)           NOT NULL
);