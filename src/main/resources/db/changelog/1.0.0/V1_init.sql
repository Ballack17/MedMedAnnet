CREATE TABLE med_annet."role"
(
    id UUID NOT NULL,
    name character varying(32) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE med_annet."user"
(
    id UUID NOT NULL,
    login character varying(32) NOT NULL,
    password character varying(64) NOT NULL,
    active boolean NOT NULL,
    role_id UUID NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT login UNIQUE (login),
    CONSTRAINT role_id FOREIGN KEY (role_id)
        REFERENCES med_annet.role (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

CREATE TABLE med_annet."question"
(
    id UUID NOT NULL,
    question_text varchar(256) NOT NULL,
    is_opened_answer boolean NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT question_text UNIQUE (question_text)
);

CREATE TABLE med_annet."answer"
(
    id UUID NOT NULL,
    answer_text varchar(32) NOT NULL,
    question_id UUID NOT NULL,
    is_correct boolean NOT NULL ,
    PRIMARY KEY (id),
    CONSTRAINT question_id FOREIGN KEY (question_id)
        REFERENCES med_annet.question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

CREATE TABLE med_annet."questionnaire"
(
    id UUID NOT NULL,
    user_id UUID NOT NULL,
    question_id UUID NOT NULL,
    answer_id UUID,
    answer_text varchar(64),
    is_correct boolean NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uniq UNIQUE (user_id, question_id),
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES med_annet.user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT question_id FOREIGN KEY (question_id)
        REFERENCES med_annet.question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT answer_id FOREIGN KEY (answer_id)
        REFERENCES med_annet.answer (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);