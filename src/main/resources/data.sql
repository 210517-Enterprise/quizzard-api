INSERT INTO app_users (username, password, first_name, last_name, role, email, confirmed) VALUES ('wsingleton', 'revature', 'Wezley', 'Singleton', 'Admin', 'wezley.singleton@revature.com', true);
INSERT INTO app_users (username, password, first_name, last_name, role, email, confirmed) VALUES ('rconnell', 'rolltide', 'Robert', 'Connell', 'Admin', 'robert.connell@revature.com', true);
INSERT INTO app_users (username, password, first_name, last_name, role, email, confirmed) VALUES ('skelsey', 'revasteve', 'Steven', 'Kelsey', 'Dev', 'steven.kelsey@revature.com', true);
INSERT INTO app_users (username, password, first_name, last_name, role, email, confirmed) VALUES ('mknighten', 'knifehand', 'Jason', 'Knighten', 'Basic User', 'jason.knighten@revature.com', true);
INSERT INTO app_users (username, password, first_name, last_name, role, email, confirmed) VALUES ('bkruppa', 'revature', 'Blake', 'Kruppa', 'Premium User', 'blake.kruppa@revature.com', true);
INSERT INTO app_users (username, password, first_name, last_name, role, email, confirmed) VALUES ('trolluser', 'banned', 'Eric', 'Cartman', 'Locked', 'eric.cartman@gmail.com', true);

INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Core Java Question 1', 'Dummy Answer', 'Core Java', 2);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Core Java Question 2', 'Dummy Answer', 'Core Java', 2);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Core Java Question 3', 'Dummy Answer', 'Core Java', 2);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Java Threads Question 1', 'Dummy Answer', 'Java Threads', 2);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Oracle SQL Question 1', 'Dummy Answer', 'Oracle PL/SQL', 2);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Oracle SQL Question 2', 'Dummy Answer', 'Oracle PL/SQL', 2);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Core JavaScript Question 1', 'Dummy Answer', 'Core JavaScript', 5);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Core JavaScript Question 2', 'Dummy Answer', 'Core JavaScript', 5);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Core JavaScript Question 3', 'Dummy Answer', 'Core JavaScript', 5);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Core JavaScript Question 4', 'Dummy Answer', 'Core JavaScript', 5);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Angular Question 1', 'Dummy Answer', 'Angular', 5);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy React Question 1', 'Dummy Answer', 'React', 5);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy React Question 2', 'Dummy Answer', 'React', 5);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy DevOps Principles Question 1', 'Dummy Answer', 'DevOps Principles', 3);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Containerization Question 1', 'Dummy Answer', 'Containerization', 3);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Containerization Question 2', 'Dummy Answer', 'Containerization', 3);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Hibernate Question 1', 'Dummy Answer', 'Hibernate', 1);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Hibernate Question 2', 'Dummy Answer', 'Hibernate', 1);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Core Spring Question 1', 'Dummy Answer', 'Core Spring Framework', 1);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Core Spring Question 2', 'Dummy Answer', 'Core Spring Framework', 1);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Spring Boot Question 1', 'Dummy Answer', 'Spring Boot', 1);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Spring Boot Question 2', 'Dummy Answer', 'Spring Boot', 1);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Microservice Architecture Question 1', 'Dummy Answer', 'Microservice Architecture', 4);
INSERT INTO flashcards (question, answer, category, creator_id) VALUES ('Dummy Microservice Architecture Question 2', 'Dummy Answer', 'Microservice Architecture', 4);

INSERT INTO study_sets (name, owner_id) VALUES ('Core Java Study Set', 4);
INSERT INTO study_sets (name, owner_id) VALUES ('Spring Study Set', 4);
INSERT INTO study_sets (name, owner_id) VALUES ('Core JavaScript Study Set', 5);
INSERT INTO study_sets (name, owner_id) VALUES ('React Study Set', 5);
INSERT INTO study_sets (name, owner_id) VALUES ('DevOps Study Set', 5);

INSERT INTO study_set_cards VALUES (1, 1);
INSERT INTO study_set_cards VALUES (1, 2);
INSERT INTO study_set_cards VALUES (1, 3);
INSERT INTO study_set_cards VALUES (2, 19);
INSERT INTO study_set_cards VALUES (2, 20);
INSERT INTO study_set_cards VALUES (2, 21);
INSERT INTO study_set_cards VALUES (2, 22);
INSERT INTO study_set_cards VALUES (3, 7);
INSERT INTO study_set_cards VALUES (3, 8);
INSERT INTO study_set_cards VALUES (3, 9);
INSERT INTO study_set_cards VALUES (3, 10);
INSERT INTO study_set_cards VALUES (4, 12);
INSERT INTO study_set_cards VALUES (4, 13);
INSERT INTO study_set_cards VALUES (5, 14);
INSERT INTO study_set_cards VALUES (5, 15);
INSERT INTO study_set_cards VALUES (5, 16);

-- correct_answer, answer_a, answer_b, answer_c, answer_d, question_text
INSERT INTO questions (question_text, correct_answer, answer_a, answer_b, answer_c, answer_d)
VALUES ('Which of the following is NOT a falsy value?', 'a', '{}', '0', '""', 'NaN');

INSERT INTO questions (question_text, correct_answer, answer_a, answer_b, answer_c, answer_d)
VALUES ('7 + 7 + "7" = ?', 'd', '147', '21', '"777"', '"147"');

INSERT INTO questions (question_text, correct_answer, answer_a, answer_b, answer_c, answer_d)
VALUES ('NaN == NaN', 'b', 'true', 'false', 'undefined', 'SyntaxError');

INSERT INTO questions (question_text, correct_answer, answer_a, answer_b, answer_c, answer_d)
VALUES ('!!{}', 'a', 'true', 'false', '{}', 'SyntaxError');

INSERT INTO questions (question_text, correct_answer, answer_a, answer_b, answer_c, answer_d)
VALUES ('Which of the following variable declarative keywords are subject to hoisting?', 'c', 'let', 'const', 'var', '(no keyword used)');


COMMIT;
