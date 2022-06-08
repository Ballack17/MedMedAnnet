INSERT INTO med_annet.role (id, name) VALUES
('98555505-2bf6-473d-ab28-4dd165c00001','ROLE_ADMIN'),
('98555505-2bf6-473d-ab28-4dd165c00002','ROLE_USER');

INSERT INTO med_annet.user(id, login, password, role_id, active) VALUES
('98555505-2bf6-473d-ab28-4dd165c10003', 'Danil', '$2a$10$CGamJWPYokRss2FX6WcBJOgFIDKyUoCYnrGtepfVQyDSTdngSxrzK', '98555505-2bf6-473d-ab28-4dd165c00001', true),
('98555505-2bf6-473d-ab28-4dd165c10004', 'Danil1', '$2a$10$CGamJWPYokRss2FX6WcBJOgFIDKyUoCYnrGtepfVQyDSTdngSxrzK', '98555505-2bf6-473d-ab28-4dd165c00002', true);

INSERT INTO med_annet.question(id, question_text, is_opened_answer) VALUES
('98555505-2bf6-473d-ab28-4dd165c21001', 'What is the biggest country?', false),
('98555505-2bf6-473d-ab28-4dd165c21002', 'What is the smallest country?', true),
('98555505-2bf6-473d-ab28-4dd165c21003', 'What is the biggest island?', true),
('98555505-2bf6-473d-ab28-4dd165c21004', 'What is the highest mountain?', true),
('98555505-2bf6-473d-ab28-4dd165c21005', 'What is the biggest planet at solar system?', true);

INSERT INTO med_annet.answer(id, answer_text, question_id, is_correct) VALUES
('98555505-2bf6-473d-ab28-4dd165c21006', 'Russia', '98555505-2bf6-473d-ab28-4dd165c21001', true),
('98555505-2bf6-473d-ab28-4dd165c21008', 'China', '98555505-2bf6-473d-ab28-4dd165c21001', false),
('98555505-2bf6-473d-ab28-4dd165c21009', 'USA', '98555505-2bf6-473d-ab28-4dd165c21001', false),
('98555505-2bf6-473d-ab28-4dd165c21010', 'Brazil', '98555505-2bf6-473d-ab28-4dd165c21001', false),
('98555505-2bf6-473d-ab28-4dd165c21007', 'Vatican', '98555505-2bf6-473d-ab28-4dd165c21002', true),
('98555505-2bf6-473d-ab28-4dd165c21012', 'Greenland', '98555505-2bf6-473d-ab28-4dd165c21003', true),
('98555505-2bf6-473d-ab28-4dd165c21013', 'Everest', '98555505-2bf6-473d-ab28-4dd165c21004', true),
('98555505-2bf6-473d-ab28-4dd165c21014', 'Dzhomolungma', '98555505-2bf6-473d-ab28-4dd165c21004', true),
('98555505-2bf6-473d-ab28-4dd165c21011', 'Jupiter', '98555505-2bf6-473d-ab28-4dd165c21005', true);

INSERT INTO med_annet.questionnaire(id, user_id, question_id, answer_id, answer_text, is_correct) VALUES
('98555505-2bf6-473d-ab28-4dd165c30021', '98555505-2bf6-473d-ab28-4dd165c10003','98555505-2bf6-473d-ab28-4dd165c21001' , '98555505-2bf6-473d-ab28-4dd165c21006', null, true),
('98555505-2bf6-473d-ab28-4dd165c30022', '98555505-2bf6-473d-ab28-4dd165c10003','98555505-2bf6-473d-ab28-4dd165c21002' , null, 'Vatican', true),
('98555505-2bf6-473d-ab28-4dd165c30023', '98555505-2bf6-473d-ab28-4dd165c10003','98555505-2bf6-473d-ab28-4dd165c21003' , null, 'Greenland', true),
('98555505-2bf6-473d-ab28-4dd165c30024', '98555505-2bf6-473d-ab28-4dd165c10003','98555505-2bf6-473d-ab28-4dd165c21004' , null, 'Everest', true),
('98555505-2bf6-473d-ab28-4dd165c30025', '98555505-2bf6-473d-ab28-4dd165c10003','98555505-2bf6-473d-ab28-4dd165c21005' , null, 'xz', false),
('98555505-2bf6-473d-ab28-4dd165c30026', '98555505-2bf6-473d-ab28-4dd165c10004','98555505-2bf6-473d-ab28-4dd165c21001' , '98555505-2bf6-473d-ab28-4dd165c21006', null, true),
('98555505-2bf6-473d-ab28-4dd165c30027', '98555505-2bf6-473d-ab28-4dd165c10004','98555505-2bf6-473d-ab28-4dd165c21002' , null, 'xz', false),
('98555505-2bf6-473d-ab28-4dd165c30028', '98555505-2bf6-473d-ab28-4dd165c10004','98555505-2bf6-473d-ab28-4dd165c21003' , null, 'xz', false),
('98555505-2bf6-473d-ab28-4dd165c30029', '98555505-2bf6-473d-ab28-4dd165c10004','98555505-2bf6-473d-ab28-4dd165c21004' , null, 'xz', false),
('98555505-2bf6-473d-ab28-4dd165c30030', '98555505-2bf6-473d-ab28-4dd165c10004','98555505-2bf6-473d-ab28-4dd165c21005' , null, 'xz', false);