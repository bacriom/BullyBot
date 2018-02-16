
CREATE TABLE chanel
(
  slack_id_chanel varchar(50) NOT NULL,
  id_victim varchar(50),
  CONSTRAINT chanel_pkey PRIMARY KEY (slack_id_chanel)
);

CREATE TABLE question
(
  id bigint NOT NULL,
  answer_text text,
  id_chanel varchar(50),
  id_questioner varchar(50),
  "text" text,
  time_stamp varchar(255),
  CONSTRAINT question_pkey PRIMARY KEY (id)
)

CREATE TABLE answer
(
  id bigint NOT NULL,
  correct_answer boolean NOT NULL,
  id_thread_ts varchar(255),
  "text" text,
  "timestamp" varchar(255),
  CONSTRAINT answer_pkey PRIMARY KEY (id)
);

